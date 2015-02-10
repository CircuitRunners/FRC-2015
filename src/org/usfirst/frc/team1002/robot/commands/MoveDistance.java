package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class MoveDistance extends Command {

    public final int turns;

    public MoveDistance(@SuppressWarnings("hiding") int turns) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(new Drive());
        this.turns = turns;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Drive.moveTurns(turns);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
