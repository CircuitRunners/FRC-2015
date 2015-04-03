package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;

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
	Dashboard.publish("Project Fizz, lel");
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
