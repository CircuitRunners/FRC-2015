package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PublishValues extends Command {

    public PublishValues() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(new Dashboard());
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @SuppressWarnings("boxing")
    @Override
    protected void execute() {
        String isPolar;
        if(Robot.isPolar) isPolar = "Polar"; else isPolar = "Cartestian";
        
        Dashboard.publish(((Double) Robot.stick.getX()).toString(),
                ((Double) Robot.stick.getY()).toString(),
                ((Double) Robot.stick.getTwist()).toString(),
                ((Integer) Drive.leftFrontEncoder.getRaw()).toString(),
                isPolar);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
