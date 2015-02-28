package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Drive;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto extends Command {

    public Auto() {
	requires(Robot.drive);
	requires(Robot.forklift);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
	double time;
	time = Timer.getFPGATimestamp();
	while (Timer.getFPGATimestamp() - time < 1) {
	    Drive.move(0, -0.25, 0);
	}
	Drive.move(0, 0, 0);
	time = Timer.getFPGATimestamp();
	while (Timer.getFPGATimestamp() - time < 0.25) {
	    Forklift.forkMotor.set(1);
	}
	Forklift.forkMotor.set(0);
	time = Timer.getFPGATimestamp();
	while (Timer.getFPGATimestamp() - time < 0.5) {
	    Forklift.liftMotor.set(1);
	}
	Forklift.liftMotor.set(0);
	time = Timer.getFPGATimestamp();
	while (Timer.getFPGATimestamp() - time < 2) {
	    Drive.move(0, 0.5, 0);
	}
	time = Timer.getFPGATimestamp();
	while (Timer.getFPGATimestamp() - time < 0.1) {
	    Drive.move(0, 0, 0);
	}
	time = Timer.getFPGATimestamp();
	while (Timer.getFPGATimestamp() - time < 1) {
	    Drive.move(0, 0, 0.5);
	}
	time = Timer.getFPGATimestamp();
	while (Timer.getFPGATimestamp() - time < 0.25) {
	    Forklift.liftMotor.set(-1);
	}
	Forklift.liftMotor.set(0);
	time = Timer.getFPGATimestamp();
	while (Timer.getFPGATimestamp() - time < 0.25) {
	    Forklift.forkMotor.set(-1);
	}
	Forklift.forkMotor.set(0);
	time = Timer.getFPGATimestamp();
	while (Timer.getFPGATimestamp() - time < 1) {
	    Drive.move(0, 0.25, 0);
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
	return true;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
