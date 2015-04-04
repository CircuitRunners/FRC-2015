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
				addSequential(new Move(-0.25, 0, 0));
				break;
			case 2:
				addSequential(new Move(0, 0, 0));
				addParallel(new Lift(-1));
				addParallel(new Fork(-0.666));
				break;
			default:
				addSequential(new Move(0, -0.25, 0), 1);
				addSequential(new Fork(1), 0.25);
				addSequential(new Lift(1), 0.5);
				addParallel(new Move(0, 0.5, 0), 2);
				addParallel(new Move(0, 0, 0.5), 1);
				addParallel(new Lift(-1), 0.25);
				addSequential(new Fork(-1), 0.25);
				addSequential(new Move(0, 0.25, 0), 1);
				break;
		}
	}
}
