package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.Auto;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;
import org.usfirst.frc.team1002.robot.subsystems.ForkSystem;
import org.usfirst.frc.team1002.robot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Robot extends IterativeRobot {

	// Static instances of systems
	public static final Joystick joystickMove = new Joystick(RobotMap.stick[0]);
	public static final Drive drive = new Drive();
	public static final ForkSystem forkSystem = new ForkSystem();
	public static final LiftSystem liftSystem = new LiftSystem();
	public static final Dashboard dash = new Dashboard();

	// Secondary handlers
	public static OI oi;

	// Camera
	public static AxisCamera camera;

	// Auto
	CommandGroup auto;

	@Override
	public void autonomousInit() {
		auto = new Auto((int) Math.floor(Dashboard.getNumber(0)));
		Scheduler.getInstance().add(auto);
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void robotInit() {
		oi = new OI(joystickMove);
		camera = new AxisCamera("10.10.2.11");
	}

	@Override
	public void teleopInit() {
		if (!auto.isCanceled() && auto != null) auto.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		Drive.move(joystickMove);
		// oi.override();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
