package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.command.Command;

public class LiftUp extends Command {

    public LiftUp() {
        requires(new Forklift());
    }

    @Override
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Forklift.LiftUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return !Forklift.getLimitTop();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Forklift.stopLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Forklift.stopLift();
    }
}
