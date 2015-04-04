package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	// Motors
	public static VictorSP leftFrontMotor;
	public static VictorSP rightFrontMotor;
	public static VictorSP leftBackMotor;
	public static VictorSP rightBackMotor;

	// Gyro
	public static Gyro gyro;

	// RobotDrive
	public static RobotDrive robotDrive;

	// Deadzone Constants
	public static final double SPIN_DEADZONE_CONSTANT = 0.1;
	public static final double STICK_DEADZONE_CONSTANT = 0.15;

	// toggle drive reverse
	public static boolean toggle = false;

	/**
	 * Alternate move function. Takes joystick input and automatically throttles
	 * and sets.
	 *
	 * @param joystick is the joystick used
	 */
	public static void move(double x, double y, double rotation) {
		robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}

	public static void move(double x, double y, double rotation, boolean cartesian) {
		if (cartesian)
			robotDrive.mecanumDrive_Cartesian(x, y, rotation, gyro.getAngle());
		else
			robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}

	/**
	 * Alternate move function. Takes joystick input and automatically throttles
	 * and sets.
	 *
	 * @param joystick is the joystick used
	 */
	public static void move(GenericHID joystick) {
		if (!toggle)
			robotDrive.mecanumDrive_Cartesian(throttle(joystick.getX()), throttle(joystick.getY()), spinThrottle(joystick.getTwist()), 0);
		else
			robotDrive.mecanumDrive_Cartesian(throttle(joystick.getX()), throttle(joystick.getY()), spinThrottle(joystick.getTwist()), 180);
	}

	private static double spinThrottle(double input) {
		if (input > -SPIN_DEADZONE_CONSTANT && input < SPIN_DEADZONE_CONSTANT) return 0;
		return input * ((-Robot.joystickMove.getThrottle() + 1) / 2) * 0.5;
	}

	private static double throttle(double input) {
		if (input > -STICK_DEADZONE_CONSTANT && input < STICK_DEADZONE_CONSTANT) return 0;
		return input * ((-Robot.joystickMove.getThrottle() + 1) / 2);
	}

	public static void toggle() {
		toggle = !toggle;
	}

	public Drive() {
		leftFrontMotor = new VictorSP(RobotMap.motors[0]);
		rightFrontMotor = new VictorSP(RobotMap.motors[1]);
		rightBackMotor = new VictorSP(RobotMap.motors[2]);
		leftBackMotor = new VictorSP(RobotMap.motors[3]);

		gyro = new Gyro(RobotMap.gyro);

		robotDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
	}

	@Override
	public void initDefaultCommand() {
	}
}
