package org.usfirst.frc.team1002.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {

    public static void publish(Object... input) {
        int numberKey = 0;
        int stringKey = 0;
        int booleanKey = 0;
        for (final Object value : input) {
            if (value.getClass() == double.class) {
                SmartDashboard.putNumber("DB/Slider " + numberKey, (double) value);
                numberKey++;
            } else if (value.getClass() == String.class) {
                SmartDashboard.putString("DB/String " + stringKey, (String) value);
                stringKey++;
            } else if (value.getClass() == boolean.class) {
                SmartDashboard.putBoolean("DB/Button " + booleanKey, (boolean) value);
                booleanKey++;
            }
        }
    }
}
