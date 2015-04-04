package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.ExtArmSystem;
import org.usfirst.frc.team1002.robot.subsystems.ForkSystem;

import edu.wpi.first.wpilibj.command.Command;

public class ExtArm extends Command {

	public double speed;

	public ExtArm(double speedIn) {
		requires(Robot.extArmSystem);
		speed = speedIn;
	}

	@Override
	protected void end() {
		ExtArmSystem.arm(0);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		ExtArmSystem.arm(speed);
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
		return false;
	}
}
