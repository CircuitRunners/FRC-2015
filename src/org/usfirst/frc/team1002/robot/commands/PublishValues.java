package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PublishValues extends Command {

    public PublishValues() {
	requires(Robot.dash);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
	String driveType;
	if (Drive.isCartesian) {
	    driveType = "Cartesian";
	} else {
	    driveType = "Polar";
	}
	Dashboard.publish(((Double) Robot.xbox.getX()).toString(), ((Double) Robot.xbox.getY()).toString(),
		((Double) Robot.xbox.getTwist()).toString(), ((Boolean) Forklift.limitSensorBot.get()).toString(),
		((Boolean) Forklift.limitSensorTop.get()).toString(), ((Boolean) Forklift.limitSensorFork.get()).toString(), driveType);
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
