
package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivebase extends Subsystem {
    
    Victor leftFrontMotor;
    Victor rightFrontMotor;
    Victor leftBackMotor;
    Victor rightBackMotor;
    
    RobotDrive rd;
    
    public Drivebase(){
    	leftFrontMotor = new Victor(RobotMap.leftFrontMotor);
    	rightFrontMotor = new Victor(RobotMap.leftBackMotor);
    	leftBackMotor = new Victor(RobotMap.rightFrontMotor);
    	rightBackMotor = new Victor(RobotMap.rightBackMotor);
    	
    	rd = new RobotDrive(leftFrontMotor, rightFrontMotor, leftBackMotor, rightBackMotor);
    }
    
    public void go(){
    	rd.arcadeDrive(RobotMap.stick);
    }
    
    public void publishValues(){
    	SmartDashboard.putNumber("DB/Slider 0", leftFrontMotor.getSpeed());
    	SmartDashboard.putNumber("DB/Slider 1", rightFrontMotor.getSpeed());
    	SmartDashboard.putNumber("DB/Slider 2", leftBackMotor.getSpeed());
    	SmartDashboard.putNumber("DB/Slider 3", rightBackMotor.getSpeed());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

