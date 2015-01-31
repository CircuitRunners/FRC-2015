package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    CANTalon forkliftMotor;
    DigitalInput limitSensor;
    
    public Forklift(){
    	forkliftMotor = new CANTalon(RobotMap.forkliftMotor);
    	limitSensor = new DigitalInput(RobotMap.limitTop);
    	this.sstopLift();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public void LiftUp(){
    	if(!limitSensor.get()){
    		forkliftMotor.set(1);
    	}else{
    		forkliftMotor.set(0);
    	}
  
    }
    
    public void sstopLift(){
    	forkliftMotor.set(0);
    }
    
    public void LiftDown(){
    	forkliftMotor.set(-1);
    }
    
    public boolean getLimit(){
    	return limitSensor.get();
    }
}

