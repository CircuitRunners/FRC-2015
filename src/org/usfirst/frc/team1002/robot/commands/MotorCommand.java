package org.usfirst.frc.team1002.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class MotorCommand extends Command {

	private final double speed;
	private final boolean timed;

	/**
	 * Constructs a command involving a motor.
	 *
	 * @param name The name of the command.
	 * @param speed The speed to set the motor to.
	 */
	public MotorCommand(String name, double speed) {
		super(name);
		this.speed = speed;
		timed = false;
	}

	/**
	 * Constructs a command involving a motor with a timeout.
	 *
	 * @param name The name of the command.
	 * @param speed The speed to set the motor to.
	 * @param timeout The delay in seconds to stop the motor.
	 */
	public MotorCommand(String name, double speed, double timeout) {
		super(name, timeout);
		this.speed = speed;
		timed = true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void execute() {
	}

	protected double getSpeed() {
		return speed;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected boolean isFinished() {
		if (timed) return speed == 0 || isTimedOut();
		return speed == 0;
	}

	protected boolean isTimed() {
		return timed;
	}
}
