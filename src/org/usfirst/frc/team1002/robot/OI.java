package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Lift;
import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	JoystickButton upButton = new JoystickButton(Robot.stick, 6);
	JoystickButton downButton = new JoystickButton(Robot.stick, 4);
	JoystickButton gyroReset = new JoystickButton(Robot.stick, 2);
	JoystickButton cartesianToggle = new JoystickButton(Robot.stick, 11);

	public OI() {

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
