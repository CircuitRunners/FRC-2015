package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	Dashboard.publish("X Axis: " + ((Double) Robot.xbox.getX()).toString(), "Y Axis: " + ((Double) Robot.xbox.getY()).toString(), "Twist Axis: " + ((Double) Robot.xbox.getTwist()).toString(),
		"Throttle: " + ((Double) Drive.multiplier).toString(), driveType);
	SmartDashboard.putString("DB/String 10", "TEST!!");
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
