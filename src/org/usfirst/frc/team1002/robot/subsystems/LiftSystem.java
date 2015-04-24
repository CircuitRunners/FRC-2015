package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;
import org.usfirst.frc.team1002.robot.commands.Lift;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSystem extends Subsystem {
	public static CANTalon liftMotor;

	public static DigitalInput limitSensorTop;
	public static DigitalInput limitSensorBot;

	/**
	 * Internal lift speed setter. Use the Lift command instead.
	 *
	 * @param speed Internal speed value.
	 */
	public static void lift(double speed) {
		if (limitSensorBot.get() && speed < 0 || limitSensorTop.get() && speed > 0) speed = 0;
		liftMotor.set(speed);
	}

	public LiftSystem() {
		liftMotor = new CANTalon(RobotMap.liftMotor);
		limitSensorTop = new DigitalInput(RobotMap.limitSwitches[0]);
		limitSensorBot = new DigitalInput(RobotMap.limitSwitches[1]);
		lift(0);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Lift(0));
	}
}
