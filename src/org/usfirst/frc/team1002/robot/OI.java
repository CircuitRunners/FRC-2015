package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Fork;
import org.usfirst.frc.team1002.robot.commands.Lift;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    JoystickButton upButton;
    JoystickButton downButton;
    JoystickButton forkIn;
    JoystickButton forkOut;

    public OI(GenericHID... joystick) {
		upButton = new JoystickButton(joystick[1], 5);
		downButton = new JoystickButton(joystick[1], 3);
		forkIn = new JoystickButton(joystick[1], 1);
		forkOut = new JoystickButton(joystick[1], 2);
		
		upButton.whileHeld(new Lift(1));
		downButton.whileHeld(new Lift(-1));

		upButton.whenReleased(new Lift(0));
		downButton.whenReleased(new Lift(0));

		forkIn.whileHeld(new Fork(1));
		forkOut.whileHeld(new Fork(-0.666));

		forkIn.whenReleased(new Fork(0));
		forkOut.whenReleased(new Fork(0));
    }
}
