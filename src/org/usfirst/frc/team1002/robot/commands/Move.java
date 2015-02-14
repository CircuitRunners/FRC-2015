package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Move extends Command {

    private static double x;
    private static double y;
    private static double rotation;

    public Move(double x, double y, double rotation) {
        requires(Robot.drive);
        Move.x = x;
        Move.y = y;
        Move.rotation = rotation;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Drive.move(x, y, rotation);
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