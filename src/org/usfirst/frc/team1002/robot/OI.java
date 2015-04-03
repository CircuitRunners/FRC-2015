package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Fork;
import org.usfirst.frc.team1002.robot.commands.Lift;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// buttons
	JoystickButton liftUpButton;
	JoystickButton liftDownButton;
	JoystickButton forkInButton;
	JoystickButton forkOutButton;
	GenericHID[] joysticks;

	/**
	 * Receive a joystick and then map controls to it.
	 *
	 * @param joysticks The joysticks used for buttons
	 */
	public OI(GenericHID... joysticks) {
		// collect joysticks for later use
		this.joysticks = joysticks;

		// button map
		liftUpButton = new JoystickButton(joysticks[0], 5);
		liftDownButton = new JoystickButton(joysticks[0], 3);
		forkInButton = new JoystickButton(joysticks[0], 1);
		forkOutButton = new JoystickButton(joysticks[0], 2);

		// button controls
		liftUpButton.whileHeld(new Lift(1));
		liftDownButton.whileHeld(new Lift(-1));

		liftUpButton.whenReleased(new Lift(0));
		liftDownButton.whenReleased(new Lift(0));

		forkInButton.whileHeld(new Fork(1));
		forkOutButton.whileHeld(new Fork(-0.666));

		forkInButton.whenReleased(new Fork(0));
		forkOutButton.whenReleased(new Fork(0));
	}

	public void override() {
		if (joysticks[0].getRawButton(5) || joysticks[0].getRawButton(3) || joysticks[0].getRawButton(1) || joysticks[0].getRawButton(2) || joysticks[0].getRawButton(12)) {
			// button map
			liftUpButton = new JoystickButton(joysticks[0], 5);
			liftDownButton = new JoystickButton(joysticks[0], 3);
			forkInButton = new JoystickButton(joysticks[0], 1);
			forkOutButton = new JoystickButton(joysticks[0], 2);

			liftUpButton.whileHeld(new Lift(1));
			liftDownButton.whileHeld(new Lift(-1));

			liftUpButton.whenReleased(new Lift(0));
			liftDownButton.whenReleased(new Lift(0));

			forkInButton.whileHeld(new Fork(1));
			forkOutButton.whileHeld(new Fork(-0.666));

			forkInButton.whenReleased(new Fork(0));
			forkOutButton.whenReleased(new Fork(0));
		} else {
			// button map
			liftUpButton = new JoystickButton(joysticks[1], 5);
			liftDownButton = new JoystickButton(joysticks[1], 3);
			forkInButton = new JoystickButton(joysticks[1], 1);
			forkOutButton = new JoystickButton(joysticks[1], 2);

			liftUpButton.whileHeld(new Lift(1));
			liftDownButton.whileHeld(new Lift(-1));

			liftUpButton.whenReleased(new Lift(0));
			liftDownButton.whenReleased(new Lift(0));

			forkInButton.whileHeld(new Fork(1));
			forkOutButton.whileHeld(new Fork(-0.666));

			forkInButton.whenReleased(new Fork(0));
			forkOutButton.whenReleased(new Fork(0));
		}
	}
}
