package org.usfirst.frc.team1002.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class MotorCommand extends Command {

	private final double speed;
	private final boolean timed;

	public MotorCommand(String name, double speed) {
		super(name);
		this.speed = speed;
		timed = false;
	}

	public MotorCommand(String name, double speed, double timeout) {
		super(name, timeout);
		this.speed = speed;
		timed = true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	protected double getSpeed() {
		return speed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (timed) return speed == 0 || isTimedOut();
		return speed == 0;
	}

	protected boolean isTimed() {
		return timed;
	}
}
