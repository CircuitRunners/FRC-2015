package org.usfirst.frc.team1002.robot;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static int leftFrontMotor = 0;
	public static int rightFrontMotor = 1;
	public static int rightBackMotor = 2;
	public static int leftBackMotor = 3;
	public static int forkliftMotor = 4;
	public static int forkLeftRoller = 5;
	public static int forkRightRoller = 6;

	public static Joystick stick = new Joystick(0);
	public static Gyro gyro = new Gyro(0);
	
}
