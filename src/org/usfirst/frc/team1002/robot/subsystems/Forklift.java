package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Victor forkliftMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	forkliftMotor = new Victor(RobotMap.forkliftMotor);

    }
    
    public void LiftUp(){
    	forkliftMotor.set(1);
    }
    
    public void stopLift(){
    	forkliftMotor.set(0);
    }
    
    public void LiftDown(){
    	forkliftMotor.set(-1);
    }
}

