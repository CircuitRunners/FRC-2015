package org.usfirst.frc.team1002.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetDash extends Command {

    public SetDash(double... numbers) {
	int key = 0;
	for (final double value : numbers) {
	    SmartDashboard.putNumber("DB/Slider " + key, value);
	    key++;
	}
    }

    @Override
    protected void initialize() {
    }

    /**
     * Publish numbers to Dashboard
     * 
     * @param numbers are the numbers to place on the dashboard
     */
    public static void execute(double... numbers) {
	int key = 0;
	for (final double value : numbers) {
	    SmartDashboard.putNumber("DB/Slider " + key, value);
	    key++;
	}
    }

    /**
     * Publish strings to Dashboard
     * 
     * @param strings are the strings to place on the dashboard
     */
    public static void execute(String... strings) {
	int key = 0;
	for (final String value : strings) {
	    SmartDashboard.putString("DB/String " + key, value);
	    key++;
	}
    }

    /**
     * Publish booleans to Dashboard
     * 
     * @param booleans are the booleans to place on the dashboard
     */
    public static void execute(boolean... booleans) {
	int key = 0;
	for (final boolean value : booleans) {
	    SmartDashboard.putBoolean("DB/LED " + key, value);
	    key++;
	}
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
