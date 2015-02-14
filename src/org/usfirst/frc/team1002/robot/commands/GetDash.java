package org.usfirst.frc.team1002.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GetDash extends Command {

    @Override
    protected void initialize() {
    }

    public static boolean execute(int i) {
	return SmartDashboard.getBoolean("DB/Button " + i);
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

    @Override
    protected void execute() {
    }
}
