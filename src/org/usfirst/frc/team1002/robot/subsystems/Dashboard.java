package org.usfirst.frc.team1002.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard extends Subsystem {

	public static boolean getButton(int index) {
		return SmartDashboard.getBoolean("DB/Button " + index, false);
	}

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
