package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Fork extends Command {
    private double speed;
    private double timeout;

    public Fork(double speedIn) {
	requires(Robot.forklift);
	this.speed = speedIn;
	this.timeout = 0;
    }

    public Fork(double speedIn, double runTime) {
	requires(Robot.forklift);
	this.speed = speedIn;
	this.timeout = runTime;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
	if (timeout != 0) {
	    setTimeout(timeout);
	}
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
	Forklift.fork(this.speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
	if (timeout == 0) { return this.speed == 0; }
	return this.speed == 0 || isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
	Forklift.fork(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
	Forklift.fork(0);
    }
}
