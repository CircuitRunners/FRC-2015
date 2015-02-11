package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Auton;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

    // Static Instances of subsystems
    public static final Joystick stick = new Joystick(RobotMap.stick);
    public static final Drive drive = new Drive();
    public static final Forklift forklift = new Forklift();
    public static final Dashboard dash = new Dashboard();

    // Secondary handlers
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
        Auton.run();
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

        // Switch between Cartesian and polar
        if (stick.getRawButton(11)) {
            Drive.isCartesian = !Drive.isCartesian;
        }

        // Drive the robot
        Drive.move(stick);
    }

    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}