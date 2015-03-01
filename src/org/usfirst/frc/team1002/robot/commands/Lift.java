package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command {
    private double speed;
    private double timeout;

    /**
     * Lifts forklift.
     *
     * @param speedIn The speed (-1 to 1) to lift the forklift.
     */
    public Lift(double speedIn) {
	requires(Robot.liftSystem);
	this.speed = speedIn;
    }

    /**
     * Lifts forklift.
     *
     * @param speedIn The speed (-1 to 1) to lift the forklift.
     * @param runTime The delay in seconds to stop the lift.
     */
    public Lift(double speedIn, double runTime) {
	requires(Robot.liftSystem);
	this.speed = speedIn;
	this.timeout = runTime;
    }

    @Override
    protected void initialize() {
	if (timeout != 0) {
	    setTimeout(timeout);
	}
    }

    @Override
    protected void execute() {
	LiftSystem.lift(this.speed);
    }

    @Override
    protected boolean isFinished() {
	if (timeout == 0) { return this.speed == 0; }
	return this.speed == 0 || isTimedOut();
    }

    @Override
    protected void end() {
	LiftSystem.lift(0);
    }

    @Override
    protected void interrupted() {
	LiftSystem.lift(0);
    }
}
