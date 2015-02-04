
package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
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
    Encoder dozer;
    
    RobotDrive rd;
    
    final double spinDeadZoneConstant = 0.3;
    
    public Drivebase() {
    	leftFrontMotor = new Victor(RobotMap.leftFrontMotor);
    	rightFrontMotor = new Victor(RobotMap.rightFrontMotor);
    	leftBackMotor = new Victor(RobotMap.leftBackMotor);
    	rightBackMotor = new Victor(RobotMap.rightBackMotor);
    	dozer = new Encoder(0, 1);
    	rd = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
    	
    	rd.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    	rd.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }
    
    public void goPolar(){
    	rd.mecanumDrive_Cartesian(throttle(RobotMap.stick.getX()), throttle(RobotMap.stick.getY()), spinThrottle(RobotMap.stick.getTwist()), 0);
    }
    
    public void goCartesian(){
    /*	if(RobotMap.stick.getPOV(pov)){
    		stuff
    	}
    	else if(stff){
    		
    	}*/
    	rd.mecanumDrive_Cartesian(throttle(RobotMap.stick.getX()), throttle(RobotMap.stick.getY()), spinThrottle(RobotMap.stick.getTwist()), -RobotMap.gyro.getAngle());
    }
    
    public double xXx_inputModifierm8_xXx(double input){
    	
    	if (input > -0.2 && input < 0.2) {
    		input = 0;
    	}
    	return Math.pow(input, 3) * (((-RobotMap.stick.getThrottle()) + 1) / 2);
    }
    
    public double spinModifier(double input){
    	if(input > -spinDeadZoneConstant && input < spinDeadZoneConstant){
    		input=0;
    	}
    	return Math.pow(input, 3) * (((-RobotMap.stick.getThrottle()) + 1) / 2);
    }
    
    public double throttle(double input){
    	return xXx_inputModifierm8_xXx(input);
    }
    
    public double spinThrottle(double input){
    	return spinModifier(input);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //Fix this so it doesn't use delay. Delay is bad. wusu
//    public void forward(double time) {
//    	leftFrontMotor.set(1);
//		rightFrontMotor.set(1);
//		leftBackMotor.set(1);
//		rightBackMotor.set(1);
//		Timer.delay(time);
//		leftFrontMotor.set(0);
//		rightFrontMotor.set(0);
//		leftBackMotor.set(0);
//		rightBackMotor.set(0);
//   }
}