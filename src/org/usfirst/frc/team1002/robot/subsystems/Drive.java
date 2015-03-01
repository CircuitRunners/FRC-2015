package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {

    // Motors
    public static Victor leftFrontMotor;
    public static Victor rightFrontMotor;
    public static Victor leftBackMotor;
    public static Victor rightBackMotor;

    // Gyro
    public static Gyro gyro;

    // RobotDrive
    public static RobotDrive robotDrive;

    // Deadzone Constants
    public static final double SPIN_DEADZONE_CONSTANT = 0.1;
    public static final double STICK_DEADZONE_CONSTANT = 0.15;

    public Drive() {
	leftFrontMotor = new Victor(RobotMap.motors[0]);
	rightFrontMotor = new Victor(RobotMap.motors[1]);
	rightBackMotor = new Victor(RobotMap.motors[2]);
	leftBackMotor = new Victor(RobotMap.motors[3]);

	gyro = new Gyro(RobotMap.gyro);

	robotDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

	robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
	robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }

    public static void move(double x, double y, double rotation, boolean cartesian) {
	if (cartesian) {
	    robotDrive.mecanumDrive_Cartesian(x, y, rotation, gyro.getAngle());
	} else {
	    robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}
    }

    public static void move(double x, double y, double rotation) {
	robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
    }

    /**
     * Alternate move function. Takes joystick input and automatically throttles
     * and sets.
     * 
     * @param joystick is the joystick used
     */
    public static void move(GenericHID joystick) {
	robotDrive.mecanumDrive_Cartesian(throttle(joystick.getX()), throttle(joystick.getY()), spinThrottle(joystick.getTwist()), 0);
    }

    private static double throttle(double input) {
	if (input > -STICK_DEADZONE_CONSTANT && input < STICK_DEADZONE_CONSTANT) { return 0; }
	return input * ((-Robot.joystickMove.getThrottle() + 1) / 2);
    }

    private static double spinThrottle(double input) {
	if (input > -SPIN_DEADZONE_CONSTANT && input < SPIN_DEADZONE_CONSTANT) { return 0; }
	return input * ((-Robot.joystickMove.getThrottle() + 1) / 2) * 0.5;
    }

    @Override
    public void initDefaultCommand() {
    }
}
