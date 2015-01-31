//package org.usfirst.frc.team1002.robot.commands;
//
//import org.usfirst.frc.team1002.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *Should never be called. If this is called, there is a problem
// */
//public class OpenFork extends Command {
//
//    public OpenFork() {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	Robot.roller.startRollers();
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	Robot.roller.stopRollers();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
