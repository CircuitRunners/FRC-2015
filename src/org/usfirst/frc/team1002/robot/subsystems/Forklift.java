package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;
import org.usfirst.frc.team1002.robot.commands.LiftStop;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static CANTalon forkliftMotor;
    public static DigitalInput limitSensorTop;
    public static DigitalInput limitSensorBot;

    public Forklift() {
        forkliftMotor = new CANTalon(RobotMap.forkliftMotor);
        limitSensorTop = new DigitalInput(RobotMap.limitSwitches[0]);
        limitSensorBot = new DigitalInput(RobotMap.limitSwitches[1]);
        stopLift();
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LiftStop());

    }

    public static void LiftUp() {
        if (limitSensorTop.get()) {
            forkliftMotor.set(-1);
        } else {
            forkliftMotor.set(0);
        }

    }

    public static void stopLift() {
        forkliftMotor.set(0);
    }

    public static void LiftDown() {
        if (limitSensorBot.get()) {
            forkliftMotor.set(1);
        } else {
            forkliftMotor.set(0);
        }
    }

    public static boolean getLimitTop() {
        return limitSensorTop.get();
    }

    public static boolean getLimitBot() {
        return limitSensorBot.get();
    }
}
