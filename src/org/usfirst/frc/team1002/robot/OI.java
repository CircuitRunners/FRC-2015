package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Fork;
import org.usfirst.frc.team1002.robot.commands.Lift;
import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    JoystickButton upButton;
    JoystickButton downButton;
    JoystickButton gyroReset;
    JoystickButton cartesianToggle;
    JoystickButton forkIn;
    JoystickButton forkOut;

    public OI(GenericHID joystick) {
	this.upButton = new JoystickButton(joystick, 6);
	this.downButton = new JoystickButton(joystick, 4);
	this.gyroReset = new JoystickButton(joystick, 2);
	this.cartesianToggle = new JoystickButton(joystick, 11);
	this.forkIn = new JoystickButton(joystick, 3);
	this.forkOut = new JoystickButton(joystick, 5);

	// Forklift
	this.upButton.whileHeld(new Lift(1));
	this.downButton.whileHeld(new Lift(-1));

	this.upButton.whenReleased(new Lift(0));
	this.downButton.whenReleased(new Lift(0));

	this.forkIn.whileHeld(new Fork(1));
	this.forkOut.whileHeld(new Fork(-0.666));

	this.forkIn.whenReleased(new Fork(0));
	this.forkOut.whenReleased(new Fork(0));

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
