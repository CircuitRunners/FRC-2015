package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Auton;
import org.usfirst.frc.team1002.robot.subsystems.Drive;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

    // fundamental systems
    public static final Drive drive = new Drive();
    public static final Forklift forklift = new Forklift();
    public static final Joystick stick = new Joystick(RobotMap.stick);
    public static final Auton auto = new Auton();

    // secondary handlers
    public static OI oi;

    @Override
    public void robotInit() {
        oi = new OI();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        drive.robotControl = true;
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        drive.robotControl = false;
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        drive.move();
    }

    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}