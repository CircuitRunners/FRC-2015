package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Driverstation extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void publish(){
    	SmartDashboard.putString("DB/String 0", ((Double) Robot.drivebase.leftFrontMotor.getSpeed()).toString());
    	SmartDashboard.putString("DB/String 1", ((Double) Robot.drivebase.leftBackMotor.getSpeed()).toString());
    	SmartDashboard.putString("DB/String 2", ((Double) Robot.drivebase.rightFrontMotor.getSpeed()).toString());
    	SmartDashboard.putString("DB/String 3", ((Double) Robot.drivebase.rightBackMotor.getSpeed()).toString());
    	SmartDashboard.putString("DB/String 4", ((Double) RobotMap.gyro.getAngle()).toString());
    	SmartDashboard.putString("DB/String 5", ((Double) RobotMap.stick.getThrottle()).toString());
    	SmartDashboard.putString("DB/String 6", ((Integer) Robot.drivebase.dozer.getRaw()).toString());
    	SmartDashboard.putString("DB/String 7", ((Integer) RobotMap.stick.getPOV(0)).toString());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

