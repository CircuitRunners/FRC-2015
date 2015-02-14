package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Auto;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Robot extends IterativeRobot {

    // Static Instances of subsystems
    public static final Joystick xbox = new Joystick(RobotMap.stick);
    public static final Drive drive = new Drive();
    public static final Forklift forklift = new Forklift();
    public static final Dashboard dash = new Dashboard();

    // Secondary handlers
    public static OI oi;

    // Camera
    public static AxisCamera camera;

    @Override
    public void robotInit() {
	oi = new OI();
	camera = new AxisCamera("10.10.2.11");
    }

    @Override
    public void disabledPeriodic() {
	Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
	for (int i = 0; i < 1; i++)
	    Auto.run();
	return;
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
	Drive.move(xbox);
    }

    @Override
    public void testPeriodic() {
	LiveWindow.run();
    }
}
