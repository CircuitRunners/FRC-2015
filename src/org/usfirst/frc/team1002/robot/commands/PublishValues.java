package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.ForkSystem;

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
    	Dashboard.publish("Throttle", "Lift Limit Top", "Lift Limit Bot", "Fork Limit", "CircuitRunners 2015", ((Double) Robot.joystickMove.getThrottle()).toString(), ((Boolean) Robot.liftSystem.limitSensorTop.get()).toString(), ((Boolean) Robot.liftSystem.limitSensorBot.get()).toString(), ((Boolean) Robot.forkSystem.limitSensorFork.get()).toString(), "by akilan and mastercoms");
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
