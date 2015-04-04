package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.ExtArmSystem;
import org.usfirst.frc.team1002.robot.subsystems.ForkSystem;

public class ExtArm extends MotorCommand {

	/**
	 * Manipulates the extension arm.
	 *
	 * @param speed The speed (-1 to 1) at which to extend (-) or bring in (+)
	 * the extension arm.
	 */
	public ExtArm(double speed) {
		super("ExtArm", speed);
		requires(Robot.extArmSystem);
	}

	/**
	 * Manipulates the extension arm.
	 *
	 * @param speed The speed (-1 to 1) at which to extend (-) or bring in (+)
	 * the extension arm.
	 * @param timeout The delay in seconds to stop the fork.
	 */
	public ExtArm(double speed, double timeout) {
		super("ExtArm", speed, timeout);
		requires(Robot.extArmSystem);
	}

	@Override
	protected void end() {
		ExtArmSystem.arm(0);
	}

	@Override
	protected void execute() {
		ExtArmSystem.arm(getSpeed());
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
