package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.ExtArmSystem;
import org.usfirst.frc.team1002.robot.subsystems.ForkSystem;

public class ExtArm extends MotorCommand {

	public ExtArm(double speed) {
		super("ExtArm", speed);
		requires(Robot.extArmSystem);
	}

	public ExtArm(double speed, double runTime) {
		super("ExtArm", speed, runTime);
		requires(Robot.extArmSystem);
	}

	@Override
	protected void end() {
		ExtArmSystem.arm(0);
	}

	// Called repeatedly when this Command is scheduled to run
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
