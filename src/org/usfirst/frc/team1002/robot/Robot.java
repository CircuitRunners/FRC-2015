package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.DriveCartesian;
import org.usfirst.frc.team1002.robot.commands.DrivePolar;
import org.usfirst.frc.team1002.robot.subsystems.Drivebase;
import org.usfirst.frc.team1002.robot.subsystems.Driverstation;
//import org.usfirst.frc.team1002.robot.subsystems.ForkRoller;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static final Drivebase drivebase = new Drivebase();
	public static final Driverstation driverstation = new Driverstation();
	public static final Forklift forklift = new Forklift();
	//public static final ForkRoller roller = new ForkRoller();
	public static OI oi;

    Command autonomousCommand;
    
    Command drive;
    Command driveC;

    public void robotInit() {
		oi = new OI();
		drive = new DrivePolar();
		driveC = new DriveCartesian();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        //Scheduler.getInstance().add(drive);
        Scheduler.getInstance().add(drive);
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        if (RobotMap.stick.getRawButton(2)){
        	RobotMap.gyro.reset();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}