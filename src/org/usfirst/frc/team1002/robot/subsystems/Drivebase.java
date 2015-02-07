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

    static final double SPINDEADZONECONSTANT = 0.3;
    static final double STICKDEADZONECONSTANT = 0.1;

    public Drivebase() {
        // initialize motors
        leftFrontMotor = new Victor(RobotMap.motors.get(0));
        rightFrontMotor = new Victor(RobotMap.motors.get(1));
        rightBackMotor = new Victor(RobotMap.motors.get(2));
        leftBackMotor = new Victor(RobotMap.motors.get(3));

        // initialize gyro
        gyro = new Gyro(RobotMap.gyro);

        // initialize encoder
        encoder = new Encoder(0, 1);
        robotDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
    }

    public void move(double x, double y, double rotation) {
        if (isPolar) {
            robotDrive.mecanumDrive_Cartesian(throttle(x), throttle(y), spinThrottle(rotation), 0);
        } else {
            robotDrive.mecanumDrive_Cartesian(throttle(x), throttle(y), spinThrottle(rotation), -gyro.getAngle());
        }
    }

    public void moveRight() {
        robotDrive.mecanumDrive_Cartesian(.5, 0, 0, 0);
    }

    public void moveLeft() {
        robotDrive.mecanumDrive_Cartesian(-.5, 0, 0, 0);
    }

    public void moveForwards() {
        robotDrive.mecanumDrive_Cartesian(0, 0.5, 0, 0);
    }

    public void moveBacks() {
        robotDrive.mecanumDrive_Cartesian(0, -0.5, 0, 0);
    }

    public void moveTurnways() {
        robotDrive.mecanumDrive_Cartesian(0, 0, .5, 0);
    }

    public void moveCounterturnways() {
        robotDrive.mecanumDrive_Cartesian(0, 0, -0.5, 0);
    }

    public void moveStop() {
        robotDrive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }

    public double throttle(double input) {
        if (input > -STICKDEADZONECONSTANT && input < STICKDEADZONECONSTANT) {
            input = 0;
        }
        return Math.pow(input, 3) * ((-Robot.stick.getThrottle() + 1) / 2);
    }

    public double spinThrottle(double input) {
        if (input > -SPINDEADZONECONSTANT && input < SPINDEADZONECONSTANT) {
            input = 0;
        }
        return Math.pow(input, 5) * ((-Robot.stick.getThrottle() + 1) / 2);
    }

    @Override
    public void initDefaultCommand() {
    }
}
