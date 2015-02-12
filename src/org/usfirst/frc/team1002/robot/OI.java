package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Lift;
import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	JoystickButton upButton;
	JoystickButton downButton;
	JoystickButton gyroReset;
	JoystickButton cartesianToggle;

	public OI(GenericHID joystick) {
		upButton = new JoystickButton(joystick, 6);
		downButton = new JoystickButton(joystick, 4);
		gyroReset = new JoystickButton(joystick, 2);
		cartesianToggle = new JoystickButton(joystick, 11);

		// Forklift
		upButton.whileHeld(new Lift(1));
		downButton.whileHeld(new Lift(-1));
		upButton.whenReleased(new Lift(0));
		downButton.whenReleased(new Lift(0));

		// Switch between Cartesian and polar
		if (cartesianToggle.get()) {
			Drive.isCartesian = !Drive.isCartesian;
		}

		// Reset the gyro angle
		if (gyroReset.get()) {
			Drive.gyro.reset();
		}
	}

}
