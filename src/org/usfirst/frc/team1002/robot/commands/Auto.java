package org.usfirst.frc.team1002.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup {

    public Auto() {
        addSequential(new Move(-0.5, 0, 0));
        addSequential(new Move(0, 0, 0));
        addSequential(new Lift(-1));
        addSequential(new Lift(1));
        addSequential(new Move(0.5, 0, 0));
        addSequential(new Move(0, 0, 0));
    }
}