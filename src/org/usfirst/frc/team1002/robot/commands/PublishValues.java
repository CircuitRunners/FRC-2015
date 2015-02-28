package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
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
        Dashboard.publish(((Double) Robot.joystickMove.getX()).toString(), ((Double) Robot.joystickMove.getY()).toString(),
                ((Double) Robot.joystickMove.getTwist()).toString(), ((Boolean) Forklift.limitSensorBot.get()).toString(),
                ((Boolean) Forklift.limitSensorTop.get()).toString(), ((Boolean) Forklift.limitSensorFork.get()).toString());
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
