package org.usfirst.frc.team1002.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup {

	/**
	 * Runs an autonomous mode from one of multiple set modes.
	 *
	 * @param mode The autonomous mode to use.
	 */
	public Auto(int mode) {
		switch (mode) {
			case 1:
				addSequential(new Move(-0.5, 0, 0), 2.5);
				break;
			case 2:
				break;
			case 3:
				addSequential(new Move(0, -0.25, 0), 1);
				addSequential(new Fork(1), 0.25);
				addSequential(new Lift(1), 0.5);
				addSequential(new Move(0, 0.5, 0), 2);
				addSequential(new Move(0, 0, 0.5), 1);
				addSequential(new Lift(-1), 0.25);
				addSequential(new Fork(-1), 0.25);
				addSequential(new Move(0, 0.25, 0), 1);
				break;
			case 4:
				// 1st container and tote
				addSequential(new Move(-0.5, 0, -0.5), 1);
				addSequential(new ExtArm(1), 0.5);
				addSequential(new Move(0.5, 0, 0.5), 1);
				addSequential(new ExtArm(-1), 0.5);
				
				// container 2
				addSequential(new Move(-0.5, 0, -0.5), 1);
				addSequential(new ExtArm(1), 0.5);
				addSequential(new Move(0.5, 0, 0.5), 1);
				addSequential(new ExtArm(-1), 0.5);
				
				// container 3
				addSequential(new Move(-0.5, 0, -0.5), 1);
				addSequential(new ExtArm(1), 0.5);
				addSequential(new Move(0.5, 0, 0.5), 1);
				addSequential(new ExtArm(-1), 0.5);
				
				// move towards step container 1
				addSequential(new Move(-0.5, 0, -0.5), 1);
				addSequential(new Move(0, -0.5, 0), 1);
				addSequential(new ExtArm(1), 0.5);
				addSequential(new ExtArm(-1), 0.5);
				break;
			default:
				addSequential(new Move(0, -0.25, 0), 1);
				addSequential(new ExtArm(1), 1);
				addSequential(new ExtArm(-1), 1);
				addSequential(new Move(0, 0.25, 0), 1);
				break;
		}
	}
}
