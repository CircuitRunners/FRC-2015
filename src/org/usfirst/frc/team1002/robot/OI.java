package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Fork;
import org.usfirst.frc.team1002.robot.commands.Lift;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// buttons
    JoystickButton upButton;
    JoystickButton downButton;
    JoystickButton forkIn;
    JoystickButton forkOut;

    /**
     * Receive a joystick and then map controls to it.
     * 
     * @param joysticks The joysticks used for buttons
     */
    public OI(GenericHID... joysticks) {
    	// button map
		upButton = new JoystickButton(joysticks[0], 5);
		downButton = new JoystickButton(joysticks[0], 3);
		forkIn = new JoystickButton(joysticks[0], 1);
		forkOut = new JoystickButton(joysticks[0], 2);
		
		// button controls
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
