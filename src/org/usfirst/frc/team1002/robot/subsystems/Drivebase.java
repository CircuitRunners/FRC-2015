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

	RobotDrive rd;

	final double spinDeadZoneConstant = 0.3;

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
		rd = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor,
				rightBackMotor);

		rd.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		rd.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
	}

	public void goPolar() {
		rd.mecanumDrive_Cartesian(Robot.stick.getX(), Robot.stick.getY(),
				spinThrottle(Robot.stick.getTwist()), 0);
	}

	public void goCartesian() {
		rd.mecanumDrive_Cartesian(throttle(Robot.stick.getX()),
				throttle(Robot.stick.getY()),
				spinThrottle(Robot.stick.getTwist()), -gyro.getAngle());
	}

	public double throttle(double input) {

		if (input > -0.2 && input < 0.2) {
			input = 0;
		}
		return Math.pow(input, 3) * ((-Robot.stick.getThrottle() + 1) / 2);
	}

	public double spinThrottle(double input) {
		if (input > -spinDeadZoneConstant && input < spinDeadZoneConstant) {
			input = 0;
		}
		return Math.pow(input, 3) * ((-Robot.stick.getThrottle() + 1) / 2);
	}

	@Override
	public void initDefaultCommand() {
	}
}
