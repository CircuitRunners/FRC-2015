package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.ForkSystem;

import edu.wpi.first.wpilibj.command.Command;

public class Fork extends Command {
	private final double speed;
	private final double timeout;

	/**
	 * Opens or closes the forks.
	 * 
	 * @param speedIn The speed (-1 to 1) at which to open (-) or close (+) the
	 * forks.
	 */
	public Fork(double speedIn) {
		requires(Robot.forkSystem);
		speed = speedIn;
		timeout = 0;
	}

	/**
	 * Opens or closes the forks.
	 * 
	 * @param speedIn The speed (-1 to 1) at which to open (-) or close (+) the
	 * forks.
	 * @param runTime The delay in seconds to stop the fork.
	 */
	public Fork(double speedIn, double runTime) {
		requires(Robot.forkSystem);
		speed = speedIn;
		timeout = runTime;
	}

	@Override
	protected void end() {
		ForkSystem.fork(0);
	}

	@Override
	protected void execute() {
		ForkSystem.fork(speed);
	}

	@Override
	protected void initialize() {
		if (timeout != 0) setTimeout(timeout);
	}

	@Override
	protected void interrupted() {
		ForkSystem.fork(0);
	}

	@Override
	protected boolean isFinished() {
		if (timeout == 0) return speed == 0;
		return speed == 0 || isTimedOut();
	}
}
