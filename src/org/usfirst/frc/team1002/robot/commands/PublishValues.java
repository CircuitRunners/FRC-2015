package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.ForkSystem;
import org.usfirst.frc.team1002.robot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

public class PublishValues extends Command {

	public PublishValues() {
		requires(Robot.dash);
	}

	@Override
	protected void end() {
	}

	@Override
	protected void execute() {
		Dashboard.publish("Throttle", "Lift Limit Top", "Lift Limit Bot", "Fork Limit", "", ((Double) Robot.joystickMove.getThrottle()).toString(), ((Boolean) LiftSystem.limitSensorTop.get()).toString(), ((Boolean) LiftSystem.limitSensorBot.get()).toString(), ((Boolean) ForkSystem.limitSensorFork.get()).toString());
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
