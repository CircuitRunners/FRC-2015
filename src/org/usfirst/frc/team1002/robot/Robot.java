package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Auto;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	// Static Instances of subsystems
	public static final Joystick joystick = new Joystick(RobotMap.stick);
	public static final Drive drive = new Drive();
	public static final Forklift forklift = new Forklift();
	public static final Dashboard dash = new Dashboard();

	// Secondary handlers
	public static OI oi;

	@Override
	public void robotInit() {
		oi = new OI(joystick);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		Auto.run();
	}

	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		// Drive the robot
		Drive.move(joystick);
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}