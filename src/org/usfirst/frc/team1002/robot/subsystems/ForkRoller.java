package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *--------------------------------------------------------
 *            Luka's Code
 *--------------------------------------------------------
 */
public class ForkRoller extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Victor forkLeftRoller;
    Victor forkRightRoller;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	forkLeftRoller = new Victor(RobotMap.forkLeftRoller);
    	forkRightRoller = new Victor(RobotMap.forkRightRoller);
    }
    
    	public void enslaveRollers(){
    		
    		//I am assuming that the Left Roller is inverted
    		//I've lowered the motor power so as not to rip the tension rope
    		forkLeftRoller.set(-0.25);
    		forkRightRoller.set(0.25);	
    	}
        
    	public void emancipateRollers(){
    		//FOUR SCORE AND SEVEN YEARS AGOOO!!
    		forkLeftRoller.set(0);
    		forkRightRoller.set(0);	
    	}
    	
    }

