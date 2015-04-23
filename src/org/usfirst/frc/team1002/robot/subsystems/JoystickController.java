package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickController extends Joystick {
	
    // Deadzone Constants
    public static final double SPIN_DEADZONE_CONSTANT = 0.1;
    public static final double STICK_DEADZONE_CONSTANT = 0.15;

	public JoystickController(int port) {
		super(port);
	}

	public double getX(boolean deadband) {
		return throttle(getX());
	}
	
	public double getY(boolean deadband) {
		return throttle(getY());
	}
	
	public double getTwist(boolean deadband) {
		return spinThrottle(getTwist());
	}
	
	private static double spinThrottle(double input) {
        if (input > -SPIN_DEADZONE_CONSTANT && input < SPIN_DEADZONE_CONSTANT) {
            return 0;
        }
        return input * ((-Robot.joystickMove.getThrottle() + 1) / 2) * 0.5;
    }

    private static double throttle(double input) {
        if (input > -STICK_DEADZONE_CONSTANT && input < STICK_DEADZONE_CONSTANT) {
            return 0;
        }
        return input * ((-Robot.joystickMove.getThrottle() + 1) / 2);
    }
}
