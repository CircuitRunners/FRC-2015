package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.ForkSystem;

public class Fork extends MotorCommand {
	/**
	 * Opens or closes the forks.
	 *
	 * @param speed The speed (-1 to 1) at which to open (-) or close (+) the
	 * forks.
	 */
	public Fork(double speed) {
		super("Fork", speed);
		requires(Robot.forkSystem);
	}

	/**
	 * Opens or closes the forks.
	 *
	 * @param speed The speed (-1 to 1) at which to open (-) or close (+) the
	 * forks.
	 * @param timeout The delay in seconds to stop the fork.
	 */
	public Fork(double speed, double timeout) {
		super("Fork", speed, timeout);
		requires(Robot.forkSystem);
	}

	@Override
	protected void end() {
		ForkSystem.fork(0);
	}

	@Override
	protected void execute() {
		ForkSystem.fork(getSpeed());
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void interrupted() {
		ForkSystem.fork(0);
	}

	@Override
	protected boolean isFinished() {
		return super.isFinished();
	}
}
