package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Fork extends Command {
    private double speed;

    public Fork(double speedIn) {
	requires(Robot.forklift);
	this.speed = speedIn;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
	Forklift.fork(this.speed);
    }

    @Override
    protected boolean isFinished() {
	return this.speed == 0;
    }

    @Override
    protected void end() {
	Forklift.fork(0);
    }

    @Override
    protected void interrupted() {
	Forklift.fork(0);
    }
}
