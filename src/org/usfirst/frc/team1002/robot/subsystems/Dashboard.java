package org.usfirst.frc.team1002.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard extends Subsystem {
	/**
	 * Request a button value from a specified index and receive the boolean
	 * value of that button.
	 *
	 * @param index The button in that place in the dashboard.
	 * @return Returns the button value as a boolean.
	 */
	public static boolean getButton(int index) {
		return SmartDashboard.getBoolean("DB/Button " + index, false);
	}

	/**
	 * Request a slider from a specified index and receive the double value of
	 * that button.
	 *
	 * @param index The slider in that place in the dashboard.
	 * @return Returns the slider value as a double.
	 */
	public static double getNumber(int index) {
		return SmartDashboard.getNumber("DB/Slider " + index, 0);
	}

	public static void publish(boolean... booleans) {
		int key = 0;
		for (final boolean value : booleans) {
			SmartDashboard.putBoolean("DB/LED " + key, value);
			key++;
		}
	}

	/**
	 * Publish numbers to the Dashboard's next available key.
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

	public static void publish(String... strings) {
		int key = 0;
		for (final String value : strings) {
			SmartDashboard.putString("DB/String " + key, value);
			key++;
		}
	}

	@Override
	public void initDefaultCommand() {

	}
}
