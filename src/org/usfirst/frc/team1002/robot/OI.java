package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Fork;
import org.usfirst.frc.team1002.robot.commands.Lift;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    JoystickButton upButton;
    JoystickButton downButton;
    JoystickButton gyroReset;
    JoystickButton cartesianToggle;
    JoystickButton forkIn;
    JoystickButton forkOut;

    public OI() {
	upButton = new JoystickButton(Robot.xbox, 4);
	downButton = new JoystickButton(Robot.xbox, 1);
	gyroReset = new JoystickButton(Robot.xbox, 7);
	cartesianToggle = new JoystickButton(Robot.xbox, 8);
	forkIn = new JoystickButton(Robot.xbox, 3);
	forkOut = new JoystickButton(Robot.xbox, 2);

	// Forklift
	upButton.whileHeld(new Lift(1));
	downButton.whileHeld(new Lift(-1));

	upButton.whenReleased(new Lift(0));
	downButton.whenReleased(new Lift(0));

	forkIn.whileHeld(new Fork(-1));
	forkOut.whileHeld(new Fork(0.666));

	forkIn.whenReleased(new Fork(0));
	forkOut.whenReleased(new Fork(0));
    }
}
