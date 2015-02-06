package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivebase extends Subsystem {
    Victor leftFrontMotor;
    Victor rightFrontMotor;
    Victor leftBackMotor;
    Victor rightBackMotor;

    Gyro gyro;

    Encoder encoder;

    RobotDrive robotDrive;

    public boolean isPolar = true;

    static final double spinDeadzoneConstant = 0.3;
    static final double stickDeadzoneConstant = 0.1;

    public Drivebase() {
        // initialize motors
        leftFrontMotor = new Victor(RobotMap.motors.get(0));
        rightFrontMotor = new Victor(RobotMap.motors.get(1));
        leftBackMotor = new Victor(RobotMap.motors.get(2));
        rightBackMotor = new Victor(RobotMap.motors.get(3));

        // initialize gyro
        gyro = new Gyro(RobotMap.gyro);

        // initialize encoder
        encoder = new Encoder(0, 1);
        robotDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }

    public void move(double x, double y, double rotation) {
        if (isPolar) {
            robotDrive.mecanumDrive_Cartesian(throttle(x), throttle(y), spinThrottle(rotation), 0);
        } else {
            robotDrive.mecanumDrive_Cartesian(x, y, rotation, -gyro.getAngle());
        }
    }

    public double throttle(double input) {
        if (input > -0.2 && input < 0.2) {
            input = 0;
        }
        return Math.pow(input, 3) * ((-Robot.stick.getThrottle() + 1) / 2);
    }

    public double spinThrottle(double input) {
        if (input > -spinDeadzoneConstant && input < spinDeadzoneConstant) {
            input = 0;
        }
        return Math.pow(input, 3) * ((-Robot.stick.getThrottle() + 1) / 2);
    }

    @Override
    public void initDefaultCommand() {
    }
}
