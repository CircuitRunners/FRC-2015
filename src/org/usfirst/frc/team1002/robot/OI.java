package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Fork;
import org.usfirst.frc.team1002.robot.commands.Lift;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    JoystickButton liftUpButton;
    JoystickButton liftDownButton;
    JoystickButton gyroReset;
    JoystickButton cartesianToggle;
    JoystickButton forkIn;
    JoystickButton forkOut;

    public OI(GenericHID... joystick) {
	this.liftUpButton = new JoystickButton(joystick[0], 5);
	this.liftDownButton = new JoystickButton(joystick[0], 3);
	this.forkIn = new JoystickButton(joystick[0], 1);
	this.forkOut = new JoystickButton(joystick[0], 2);

	this.liftUpButton.whileHeld(new Lift(1));
	this.liftDownButton.whileHeld(new Lift(-1));

	this.liftUpButton.whenReleased(new Lift(0));
	this.liftDownButton.whenReleased(new Lift(0));

	this.forkIn.whileHeld(new Fork(1));
	this.forkOut.whileHeld(new Fork(-0.666));

	this.forkIn.whenReleased(new Fork(0));
	this.forkOut.whenReleased(new Fork(0));
    }
}
