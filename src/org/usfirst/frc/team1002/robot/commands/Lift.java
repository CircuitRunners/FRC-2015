package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command {

    private double speed;

    public Lift(double speedIn) {
	requires(Robot.forklift);
	this.speed = speedIn;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
	Forklift.lift(this.speed);
    }

    @Override
    protected boolean isFinished() {
	return this.speed == 0;
    }

    @Override
    protected void end() {
	Forklift.lift(0);
    }

    @Override
    protected void interrupted() {
	Forklift.lift(0);
    }
}
