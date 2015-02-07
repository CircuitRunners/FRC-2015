package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auton extends CommandGroup {

    public Auton() {
        new LiftDown().start();
        Timer.delay(1);
        new LiftUp().start();
        Timer.delay(0.5);
        Robot.drive.move(0.5, 0, 0);
        Timer.delay(2);
        Robot.drive.move(0, 0, 0);
    }
}
