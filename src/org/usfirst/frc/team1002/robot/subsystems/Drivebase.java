
package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivebase extends Subsystem {
    Victor leftFrontMotor;
    Victor rightFrontMotor;
    Victor leftBackMotor;
    Victor rightBackMotor;
    
    RobotDrive rd;
    
    public Drivebase() {
    	leftFrontMotor = new Victor(RobotMap.leftFrontMotor);
    	rightFrontMotor = new Victor(RobotMap.rightFrontMotor);
    	leftBackMotor = new Victor(RobotMap.leftBackMotor);
    	rightBackMotor = new Victor(RobotMap.rightBackMotor);	
    	
    	rd = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
    	
    	rd.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    	rd.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }
    
    public void goPolar(){
    	rd.mecanumDrive_Polar(throttle(RobotMap.stick.getMagnitude()), throttle(((180 - RobotMap.stick.getDirectionDegrees()))), -RobotMap.stick.getTwist());
    }
    
    public void goCartesian(){
    	rd.mecanumDrive_Cartesian(-throttle(RobotMap.stick.getX()), throttle(RobotMap.stick.getY()), throttle(RobotMap.stick.getTwist()), -RobotMap.gyro.getAngle());
    }
    
    public double xXx_inputModifierm8__xXx(double input){
    	if (input > -0.1 && input < 0.1) {
    		input = 0;
    	}
    	return input * (((-1 * RobotMap.stick.getThrottle()) + 1) / 2);
    }
    
    public double throttle(double input){
    	return xXx_inputModifierm8__xXx(input);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void calibration() {
    	if (RobotMap.stick.getRawButton(5)) {
    		leftFrontMotor.set(1);
    		rightFrontMotor.set(1);
    		leftBackMotor.set(1);
    		rightBackMotor.set(1);
    		} else if (RobotMap.stick.getRawButton(6)) {
    			leftFrontMotor.set(-1);
    		    rightFrontMotor.set(-1);
    		   	leftBackMotor.set(-1);
    		   	rightBackMotor.set(-1);	
    		} else {
    			leftFrontMotor.set(0);
        		rightFrontMotor.set(0);
        		leftBackMotor.set(0);
        		rightBackMotor.set(0);
    		}
    	}
    }


