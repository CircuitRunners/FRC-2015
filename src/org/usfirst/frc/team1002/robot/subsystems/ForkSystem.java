package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;
import org.usfirst.frc.team1002.robot.commands.Fork;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ForkSystem extends Subsystem {
    public static Talon forkMotor;

    public static DigitalInput limitSensorFork;

    public ForkSystem() {
		forkMotor = new Talon(RobotMap.forkMotor);
		limitSensorFork = new DigitalInput(RobotMap.limitSwitches[2]);
		fork(0);
    }

    @Override
    public void initDefaultCommand() {
    	setDefaultCommand(new Fork(0));
    }

    public static void fork(double speed) {
		if (!limitSensorFork.get() && speed < 0 && !Dashboard.getButton(1)) speed = 0;
		forkMotor.set(speed);
    }
}
