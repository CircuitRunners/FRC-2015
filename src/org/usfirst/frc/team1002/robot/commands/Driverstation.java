package org.usfirst.frc.team1002.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Driverstation extends Command {

	public Driverstation(Object value, String key) {
		if (value.getClass() == double.class) {
			SmartDashboard.putNumber(key, (double) value);
		} else if (value.getClass() == String.class) {
			SmartDashboard.putString(key, (String) value);
		} else if (value.getClass() == int.class) {
			SmartDashboard.putNumber(key, (double) value);
		} else if (value.getClass() == boolean.class) {
			SmartDashboard.putBoolean(key, (boolean) value);
		}
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
