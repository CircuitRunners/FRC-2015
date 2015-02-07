package org.usfirst.frc.team1002.robot;

import java.util.Arrays;
import java.util.List;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // port mappings, List<Integer> for grouped modules and int for single
    // modules

    // motor ports
    public static final List<Integer> motors = Arrays.asList(0, 1, 2, 3);
    // joystick port
    public static final int stick = 0;
    // gyro
    public static final int gyro = 0;
    // limit switches
    public static final List<Integer> limitSwitches = Arrays.asList(8, 9);
    // encoders
    public static final int[][] encoders = { { 0, 1 }, { 2, 3 } };
    // forklift motor
    public static final int forkliftMotor = 0;
}
