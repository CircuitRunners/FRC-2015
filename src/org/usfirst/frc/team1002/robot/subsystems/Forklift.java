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
    CANTalon forkliftMotor;
    DigitalInput limitSensorTop;
    DigitalInput limitSensorBot;

    public Forklift() {
        forkliftMotor = new CANTalon(RobotMap.forkliftMotor);
        limitSensorTop = new DigitalInput(RobotMap.limitSwitches.get(0));
        limitSensorBot = new DigitalInput(RobotMap.limitSwitches.get(1));
        stopLift();
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LiftStop());

    }

    public void LiftUp() {
        if (limitSensorTop.get()) {
            forkliftMotor.set(-1);
        } else {
            forkliftMotor.set(0);
        }

    }

    public void stopLift() {
        forkliftMotor.set(0);
    }

    public void LiftDown() {
        if (limitSensorBot.get()) {
            forkliftMotor.set(1);
        } else {
            forkliftMotor.set(0);
        }
    }

    public boolean getLimitTop() {
        return limitSensorTop.get();
    }

    public boolean getLimitBot() {
        return limitSensorBot.get();
    }
}
