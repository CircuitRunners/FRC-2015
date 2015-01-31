package org.usfirst.frc.team1002.server.mapper;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

public class CircuitMapper {

        Joystick[] sticks;
        Victor[] driveMotors;
        Victor[] modules;

        public CircuitMapper(Joystick[] sticks, Victor[] driveMotors, Victor[] modules) {
            sticks = this.sticks;
            driveMotors = this.driveMotors;
            modules = this.modules;
        }
        
        public Victor getMotor(int motor) {
            return driveMotors[motor];
        }

        public Victor getModule(int module) {
            return modules[module];
        }

        public Joystick getStick(int stick) {
            return sticks[stick];
        }
}
