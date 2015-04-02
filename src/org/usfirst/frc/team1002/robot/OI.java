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
    
    JoystickButton upButton2;
    JoystickButton downButton2;
    JoystickButton forkIn2;
    JoystickButton forkOut2;
    
    JoystickButton stopDriverTwo;
    
	String shouldIStopDriverTwo = null;

    public OI(GenericHID... joystick) {
		upButton = new JoystickButton(joystick[0], 5);
		downButton = new JoystickButton(joystick[0], 3);
		forkIn = new JoystickButton(joystick[0], 1);
		forkOut = new JoystickButton(joystick[0], 2);
		
		upButton2 = new JoystickButton(joystick[1], 5);
		downButton2 = new JoystickButton(joystick[1], 3);
		forkIn2 = new JoystickButton(joystick[1], 1);
		forkOut2 = new JoystickButton(joystick[1], 2);
		
		stopDriverTwo = new JoystickButton(joystick[0], 12);
	
		if (upButton.get() || downButton.get() || forkIn.get() || forkOut.get() || stopDriverTwo.get()) {
			upButton.whileHeld(new Lift(1));
			downButton.whileHeld(new Lift(-1));
	
			upButton.whenReleased(new Lift(0));
			downButton.whenReleased(new Lift(0));
	
			forkIn.whileHeld(new Fork(1));
			forkOut.whileHeld(new Fork(-0.666));
	
			forkIn.whenReleased(new Fork(0));
			forkOut.whenReleased(new Fork(0));
		} else {
			upButton2.whileHeld(new Lift(1));
			downButton2.whileHeld(new Lift(-1));
	
			upButton2.whenReleased(new Lift(0));
			downButton2.whenReleased(new Lift(0));
	
			forkIn2.whileHeld(new Fork(1));
			forkOut2.whileHeld(new Fork(-0.666));
	
			forkIn2.whenReleased(new Fork(0));
			forkOut2.whenReleased(new Fork(0));
		}
    }
}
