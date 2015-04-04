package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;
import org.usfirst.frc.team1002.robot.commands.ExtArm;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ExtArmSystem extends Subsystem {

	private static Talon extMotor;

	public static void arm(double speed) {
		extMotor.set(speed);
	}

	public ExtArmSystem() {
		extMotor = new Talon(RobotMap.extMotor);
		extMotor.set(0);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ExtArm(0));
	}
}
