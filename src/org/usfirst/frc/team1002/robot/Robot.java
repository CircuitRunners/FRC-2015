package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Auton;
import org.usfirst.frc.team1002.robot.subsystems.Drivebase;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

    // fundamental systems
    public static final Drivebase drivebase = new Drivebase();
    public static final Forklift forklift = new Forklift();
    public static final Joystick stick = new Joystick(RobotMap.stick);
    public static final Auton auto = new Auton();

    // secondary handlers
    public static OI oi;

    // should we use robot set inputs (true) or joystick inputs (false)?
    public boolean robotControl = false;

    // robot set move values
    public double X;
    public double Y;
    public double Rotation;

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
        // schedule the autonomous command (example)
        // auto.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        // Scheduler.getInstance().run();
        // auto.runAuto();
        forklift.LiftDown();
        Timer.delay(0.5);
        forklift.LiftUp();
        Timer.delay(1);
        drivebase.moveRight();
        Timer.delay(0.25);
        drivebase.move(0, 0, 0);
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        // Scheduler.getInstance().removeAll();
        // auto.cancel();
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
        robotControl = false;
        move();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void move() {
        final double x = stick.getX();
        final double y = stick.getY();
        final double rotation = stick.getTwist();
        if (robotControl) {
            drivebase.move(X, Y, Rotation);
        } else {
            drivebase.move(x, y, rotation);
        }
    }
}