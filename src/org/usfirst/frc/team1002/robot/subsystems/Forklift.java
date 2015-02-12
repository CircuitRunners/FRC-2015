package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;
import org.usfirst.frc.team1002.robot.commands.Lift;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {

    // Motor
    public static CANTalon forkliftMotor;

    // Sensors
    // Limit Switches
    public static DigitalInput limitSensorTop;
    public static DigitalInput limitSensorBot;

    public Forklift() {
	forkliftMotor = new CANTalon(RobotMap.forkliftMotor);
	limitSensorTop = new DigitalInput(RobotMap.limitSwitches[0]);
	limitSensorBot = new DigitalInput(RobotMap.limitSwitches[1]);
	lift(0);
    }

    @Override
    public void initDefaultCommand() {
	setDefaultCommand(new Lift(0));
    }

    /**
     * Lifts forklift
     *
     * @param speed
     *            is the speed to lift the forklift
     */
    public static void lift(double speed) {
	double speedOut = speed;
	if (!limitSensorBot.get() && speed < 0 || !limitSensorTop.get()
		&& speed > 0) {
	    speedOut = 0;
	}
	forkliftMotor.set(speedOut);
    }
}
