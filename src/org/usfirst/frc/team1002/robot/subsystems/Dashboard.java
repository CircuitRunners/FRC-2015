package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.commands.PublishValues;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Dashboard extends Subsystem {

    @Override
    public void initDefaultCommand() {
	setDefaultCommand(new PublishValues());
    }

    /**
     * Publish values to Dashboard
     * 
     * @param inputs
     *            are the objects to place on the dashboard
     */
    @SuppressWarnings("boxing")
    public static void publish(Object... inputs) {
	int numberKey = 0;
	int stringKey = 0;
	int booleanKey = 0;
	for (final Object value : inputs) {
	    if (value instanceof Double && numberKey < 10) {
		SmartDashboard.putNumber(
			"DB/Slider " + numberKey, (double) value); //$NON-NLS-1$
		numberKey++;
	    } else if (value instanceof String && stringKey < 10) {
		SmartDashboard.putString(
			"DB/String " + stringKey, (String) value); //$NON-NLS-1$
		stringKey++;
	    } else if (value instanceof Boolean && booleanKey < 10) {
		SmartDashboard.putBoolean(
			"DB/Button " + booleanKey, (boolean) value); //$NON-NLS-1$
		booleanKey++;
	    }
	}
    }

}
