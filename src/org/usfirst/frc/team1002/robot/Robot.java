package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.DriveCartesian;
import org.usfirst.frc.team1002.robot.commands.DrivePolar;
import org.usfirst.frc.team1002.robot.subsystems.Drivebase;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static final Drivebase drivebase = new Drivebase();
	public static final Forklift forklift = new Forklift();
	public static final Joystick stick = new Joystick(RobotMap.stick);
	public static OI oi;

	Command autonomousCommand;

	Command drivePolar;
	Command driveCartesian;

	@Override
	public void robotInit() {
		oi = new OI();
		drivePolar = new DrivePolar();
		driveCartesian = new DriveCartesian();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		// Scheduler.getInstance().add(drive);
		Scheduler.getInstance().add(drivePolar);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}