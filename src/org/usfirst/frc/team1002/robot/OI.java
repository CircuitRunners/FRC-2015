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
		upButton = new JoystickButton(joysticks[1], 5);
		downButton = new JoystickButton(joysticks[1], 3);
		forkIn = new JoystickButton(joysticks[1], 1);
		forkOut = new JoystickButton(joysticks[1], 2);
		
		// button controls
		upButton.whileHeld(new Lift(1));
		downButton.whileHeld(new Lift(-1));

		upButton.whenReleased(new Lift(0));
		downButton.whenReleased(new Lift(0));

		forkIn.whileHeld(new Fork(1));
		forkOut.whileHeld(new Fork(-0.666));

		forkIn.whenReleased(new Fork(0));
		forkOut.whenReleased(new Fork(0));566666666666666666666665555
    }
    
    public void override() {
    	if (joysticks[0].getRawButton(5) || joysticks[0].getRawButton() || joysticks[0].getRawButton(5) || )
    	upButton = new JoystickButton(joysticks[0], 5);
    }
}
