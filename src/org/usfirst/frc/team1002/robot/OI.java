package org.usfirst.frc.team1002.robot;

import org.usfirst.frc.team1002.robot.commands.LiftDown;
import org.usfirst.frc.team1002.robot.commands.LiftStop;
import org.usfirst.frc.team1002.robot.commands.LiftUp;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    JoystickButton upButton = new JoystickButton(Robot.stick, 6);
    JoystickButton downButton = new JoystickButton(Robot.stick, 4);
    JoystickButton driveToggle = new JoystickButton(Robot.stick, 1);
    JoystickButton gyroResetButton = new JoystickButton(Robot.stick, 2);

    public OI() {
        if (!downButton.get()) {
            upButton.whileHeld(new LiftUp());
        }

        if (!upButton.get()) {
            downButton.whileHeld(new LiftDown());
        }

        upButton.whenReleased(new LiftStop());
        downButton.whenReleased(new LiftStop());

    }

}
