package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
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

    // Encoders
    public static Encoder leftFrontEncoder;
    public static Encoder rightFrontEncoder;
    public static Encoder leftBackEncoder;
    public static Encoder rightBackEncoder;

    private static final double DISTANCE_PER_PULSE = 0;

    // RobotDrive
    public static RobotDrive robotDrive;

    public static boolean isCartesian = false;

    // Deadzone Constants
    public static final double SPIN_DEADZONE_CONSTANT = 0.1;
    public static final double STICK_DEADZONE_CONSTANT = 0.15;

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

	leftFrontEncoder.reset();
	rightFrontEncoder.reset();
	rightBackEncoder.reset();
	leftBackEncoder.reset();
	leftFrontEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
	rightFrontEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
	rightBackEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
	leftBackEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);

	robotDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

	robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
	robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }

    /**
     * Default move function. Polar is used unless changed.
     * 
     * @param x is the speed to move in the x-direction
     * @param y is the speed to move in the y-direction
     * @param rotation is the speed to rotate
     * @param isCartesian defines whether Cartesian or polar is to be used
     */
    public static void move(double x, double y, double rotation) {
	if (isCartesian) {
	    robotDrive.mecanumDrive_Cartesian(x, y, rotation, gyro.getAngle());
	} else {
	    robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}
    }

    /**
     * Alternate move function. Takes joystick input and automatically throttles
     * and sets.
     * 
     * @param joystick is the joystick used
     * @param isCartesian defines whether Cartesian or polar is to be used
     */
    public static void move(GenericHID joystick) {
	if (isCartesian) {
	    robotDrive.mecanumDrive_Cartesian(throttle(joystick.getX()), throttle(joystick.getY()), spinThrottle(joystick.getTwist()), gyro.getAngle());
	} else {
	    robotDrive.mecanumDrive_Cartesian(throttle(joystick.getX()), throttle(joystick.getY()), spinThrottle(joystick.getTwist()), 0);
	}
    }

    /**
     * Move function using encoder input
     * 
     * @param turns is the number of encoder turns to move
     */
    public static void moveTurns(int turns) {
	while (Math.abs((leftFrontEncoder.getRaw() + leftBackEncoder.getRaw() + rightBackEncoder.getRaw() + rightFrontEncoder.getRaw()) / 4) < turns) {
	    move(-0.5, 0, 0);
	}
	move(0, 0, 0);
    }

    /**
     * Throttles joystick input using a deadzone and throttle scaler
     * 
     * @param input is the raw input from the joystick
     * @return
     */
    private static double throttle(double input) {
	double output = input;
	if (input > -STICK_DEADZONE_CONSTANT && input < STICK_DEADZONE_CONSTANT) {
	    output = 0;
	}
	return output * ((-Robot.joystickThrottle.getY() + 1) / 2);
    }

    /**
     * Throttles joystick twist input using a deadzone and throttle scaler
     * 
     * @param input is the raw input from the joystick
     * @return
     */
    private static double spinThrottle(double input) {
	double output = input;
	if (input > -SPIN_DEADZONE_CONSTANT && input < SPIN_DEADZONE_CONSTANT) {
	    output = 0;
	}
	return output * ((-Robot.joystickThrottle.getY() + 1) / 2) * 0.5;
    }

    @Override
    public void initDefaultCommand() {
    }
}
