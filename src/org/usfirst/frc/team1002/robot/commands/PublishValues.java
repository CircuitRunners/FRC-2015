package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.ForkSystem;
import org.usfirst.frc.team1002.robot.subsystems.LiftSystem;

public class PublishValues {
	public static void execute() {
		Dashboard.publish("Throttle", "Lift Limit Top", "Lift Limit Bot", "Fork Limit", "Autonomous Mode", ((Double) Robot.joystickMove.getThrottle()).toString(), ((Boolean) LiftSystem.limitSensorTop.get()).toString(), ((Boolean) LiftSystem.limitSensorBot.get()).toString(), ((Boolean) ForkSystem.limitSensorFork.get()).toString(), ((Double) Dashboard.getNumber(0)).toString());
	}

	public PublishValues() {
	}

	protected void end() {
	}

	protected void initialize() {

	}

	protected void interrupted() {
	}

	protected boolean isFinished() {
		return false;
	}
}
