package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.RobotMap;
import org.usfirst.frc.team1002.robot.commands.Dashboard;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    Victor leftFrontMotor;
    Victor rightFrontMotor;
    Victor leftBackMotor;
    Victor rightBackMotor;

    Gyro gyro;

    Encoder leftFrontEncoder;
    Encoder rightFrontEncoder;
    Encoder leftBackEncoder;
    Encoder rightBackEncoder;

    RobotDrive robotDrive;

    public boolean isPolar = true;

    static final double SPINDEADZONECONSTANT = 0.1;
    static final double STICKDEADZONECONSTANT = 0.15;

    public Drive() {
        leftFrontMotor = new Victor(RobotMap.motors[0]);
        rightFrontMotor = new Victor(RobotMap.motors[1]);
        rightBackMotor = new Victor(RobotMap.motors[2]);
        leftBackMotor = new Victor(RobotMap.motors[3]);

        gyro = new Gyro(RobotMap.gyro);

        leftFrontEncoder = new Encoder(RobotMap.encoders[0][0], RobotMap.encoders[0][1]);
        rightFrontEncoder = new Encoder(RobotMap.encoders[1][0], RobotMap.encoders[1][1]);
        rightBackEncoder = new Encoder(RobotMap.encoders[2][0], RobotMap.encoders[2][1]);
        leftBackEncoder = new Encoder(RobotMap.encoders[3][0], RobotMap.encoders[3][1]);

        robotDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }

    public void move() {
        final double x = Robot.stick.getX();
        final double y = Robot.stick.getY();
        final double rotation = Robot.stick.getTwist();
        Dashboard.publish(x, y, rotation, Robot.stick.getPOVCount());
        if (isPolar) {
            robotDrive.mecanumDrive_Cartesian(throttle(x), throttle(y), spinThrottle(rotation), 0);
        } else {
            robotDrive.mecanumDrive_Cartesian(throttle(x), throttle(y), spinThrottle(rotation), -gyro.getAngle());
        }
    }

    public void move(double x, double y, double rotation) {
        robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
    }

    public void moveEncoderOne() {
        while (Math.abs(rightFrontEncoder.getRaw()) < 1000) {
            move(-0.5, 0, 0);
        }
        move(0, 0, 0);
    }

    public static double throttle(double input) {
        double output = input;
        if (input > -STICKDEADZONECONSTANT && input < STICKDEADZONECONSTANT) {
            output = 0;
        }
        return Math.pow(output, 3) * ((-Robot.stick.getThrottle() + 1) / 2);
    }

    public static double spinThrottle(double input) {
        double output = input;
        if (input > -SPINDEADZONECONSTANT && input < SPINDEADZONECONSTANT) {
            output = 0;
        }
        return Math.pow(output, 3) * ((-Robot.stick.getThrottle() + 1) / 2) * 0.5;
    }

    @Override
    public void initDefaultCommand() {
    }
}
