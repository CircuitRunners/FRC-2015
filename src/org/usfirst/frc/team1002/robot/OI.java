package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Lift;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	JoystickButton upButton = new JoystickButton(Robot.stick, 6);
	JoystickButton downButton = new JoystickButton(Robot.stick, 4);
	JoystickButton gyroResetButton = new JoystickButton(Robot.stick, 2);

	public OI() {
		if (!downButton.get()) {
			upButton.whileHeld(new Lift(1));
		}

		if (!upButton.get()) {
			downButton.whileHeld(new Lift(-1));
		}

		upButton.whenReleased(new Lift(0));
		downButton.whenReleased(new Lift(0));

	}

}
