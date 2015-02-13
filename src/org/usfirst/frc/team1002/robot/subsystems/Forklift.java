package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;
import org.usfirst.frc.team1002.robot.commands.Lift;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {
    public static CANTalon liftMotor;
    public static Talon forkMotor;

    public static DigitalInput limitSensorTop;
    public static DigitalInput limitSensorBot;

    public static DigitalInput limitSensorFork;

    public Forklift() {
	liftMotor = new CANTalon(RobotMap.liftMotor);
	forkMotor = new Talon(RobotMap.forkMotor);
	limitSensorTop = new DigitalInput(RobotMap.limitSwitches[0]);
	limitSensorBot = new DigitalInput(RobotMap.limitSwitches[1]);
	limitSensorFork = new DigitalInput(7);
	lift(0);
    }

    @Override
    public void initDefaultCommand() {
	setDefaultCommand(new Lift(0));
    }

    /**
     * Lifts forklift
     *
     * @param speed is the speed to lift the forklift
     */
    public static void lift(double speed) {
	if (limitSensorBot.get() && speed < 0 || limitSensorTop.get() && speed > 0) speed = 0;
	liftMotor.set(speed);
    }

    public static void fork(double speed) {
	if (limitSensorFork.get()) speed = 0;
	forkMotor.set(speed);
    }
}
