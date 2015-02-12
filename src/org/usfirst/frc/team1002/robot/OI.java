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
		this.upButton = new JoystickButton(joystick, 6);
		this.downButton = new JoystickButton(joystick, 4);
		this.gyroReset = new JoystickButton(joystick, 2);
		this.cartesianToggle = new JoystickButton(joystick, 11);

		// Forklift
		this.upButton.whileHeld(new Lift(1));
		this.downButton.whileHeld(new Lift(-1));
		this.upButton.whenReleased(new Lift(0));
		this.downButton.whenReleased(new Lift(0));

		// Switch between Cartesian and polar
		if (this.cartesianToggle.get()) {
			Drive.isCartesian = !Drive.isCartesian;
		}

		// Reset the gyro angle
		if (this.gyroReset.get()) {
			Drive.gyro.reset();
		}
	}

}
