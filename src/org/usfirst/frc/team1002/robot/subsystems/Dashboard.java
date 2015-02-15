package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.commands.PublishValues;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Dashboard extends Subsystem {

    /**
     * Publish numbers to Dashboard
     * 
     * @param numbers are the numbers to place on the dashboard
     */
    public static void publish(double... numbers) {
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
    public static void publish(String... strings) {
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
    public static void publish(boolean... booleans) {
	int key = 0;
	for (final boolean value : booleans) {
	    SmartDashboard.putBoolean("DB/LED " + key, value);
	    key++;
	}
    }

    public void initDefaultCommand() {
	setDefaultCommand(new PublishValues());
    }
}
