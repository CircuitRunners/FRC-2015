//package org.usfirst.frc.team1002.robot.subsystems;
//
//import org.usfirst.frc.team1002.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *There is no motor in order to roller the fork, hence this should never be called.
// */
//public class ForkRoller extends Subsystem {
//    
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.
//    Victor forkLeftRoller;
//    Victor forkRightRoller;
//    final double rollerMotorValue = 0.25;
//    
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//    	forkLeftRoller = new Victor(RobotMap.forkLeftRoller);
//    	forkRightRoller = new Victor(RobotMap.forkRightRoller);
//    }
//    
//    	public void startRollers(){
//    		forkLeftRoller.set(-rollerMotorValue);
//    		forkRightRoller.set(rollerMotorValue);	
//    	}
//        
//    	public void stopRollers(){
//    		forkLeftRoller.set(0);
//    		forkRightRoller.set(0);	
//    	}
//    	
//    }

