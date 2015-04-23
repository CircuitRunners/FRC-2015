package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
    // Motors
    public static VictorSP leftFrontMotor;
    public static VictorSP rightFrontMotor;
    public static VictorSP leftBackMotor;
    public static VictorSP rightBackMotor;

    // Gyro
    public static Gyro gyro;

    // Robot drive
    public static RobotDrive robotDrive;

    // Backwards drive toggle
    public static boolean toggle = false;

    /**
     * Alternate move function. Takes joystick input and automatically throttles
     * and sets.
     *
     * @param joystick The joystick used.
     */
    public static void move(double x, double y, double rotation) {
        robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
    }

    /**
     * Internal move function. Use the move command instead.
     */
    public static void move(double x, double y, double rotation, boolean cartesian) {
        if (cartesian) {
            robotDrive.mecanumDrive_Cartesian(x, y, rotation, gyro.getAngle());
        } else {
            robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
        }
    }

    /**
     * Alternate move function. Takes joystick input and automatically throttles
     * and sets.
     *
     * @param joystick The joystick used.
     */
    public static void move(JoystickController joystick) {
        if (!toggle) {
            robotDrive.mecanumDrive_Cartesian(joystick.getX(true), joystick.getY(true), joystick.getTwist(true),
                    0);
        } else {
            robotDrive.mecanumDrive_Cartesian(joystick.getX(true), joystick.getY(true), joystick.getTwist(true),
                    180);
        }
    }

    

    public static void toggle() {
        toggle = !toggle;
    }

    public Drive() {
        leftFrontMotor = new VictorSP(RobotMap.motors[0]);
        rightFrontMotor = new VictorSP(RobotMap.motors[1]);
        rightBackMotor = new VictorSP(RobotMap.motors[2]);
        leftBackMotor = new VictorSP(RobotMap.motors[3]);

        robotDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

        gyro = new Gyro(RobotMap.gyro);

        robotDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }

    @Override
    public void initDefaultCommand() {
    }
}
