package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.commands.PublishValues;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Dashboard extends Subsystem {

    public Dashboard() {
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new PublishValues());

    }

    @SuppressWarnings("boxing")
    public static void publish(Object... input) {
        int numberKey = 0;
        int stringKey = 0;
        int booleanKey = 0;
        for (final Object value : input) {
            if (value instanceof Double && numberKey < 10) {
                SmartDashboard.putNumber("DB/Slider " + numberKey, (double) value);
                numberKey++;
            } else if (value instanceof String && stringKey < 10) {
                SmartDashboard.putString("DB/String " + stringKey, (String) value);
                stringKey++;
            } else if (value instanceof Boolean && booleanKey < 10) {
                SmartDashboard.putBoolean("DB/Button " + booleanKey, (boolean) value);
                booleanKey++;
            }
        }
    }

}
