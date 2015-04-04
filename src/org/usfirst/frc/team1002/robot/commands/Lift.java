package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.LiftSystem;

public class Lift extends MotorCommand {
	/**
	 * Lifts forklift.
	 *
	 * @param speedIn The speed (-1 to 1) to lift the forklift.
	 */
	public Lift(double speed) {
		super("Lift", speed);
		requires(Robot.liftSystem);
	}

	/**
	 * Lifts forklift.
	 *
	 * @param speedIn The speed (-1 to 1) to lift the forklift.
	 * @param runTime The delay in seconds to stop the lift.
	 */
	public Lift(double speed, double runTime) {
		super("Lift", speed, runTime);
		requires(Robot.liftSystem);
	}

	@Override
	protected void end() {
		LiftSystem.lift(0);
	}

	@Override
	protected void execute() {
		LiftSystem.lift(getSpeed());
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void interrupted() {
		LiftSystem.lift(0);
	}

	@Override
	protected boolean isFinished() {
		return super.isFinished();
	}
}
