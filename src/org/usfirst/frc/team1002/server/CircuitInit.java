package org.usfirst.frc.team1002.server;

import org.usfirst.frc.team1002.server.mapper.CircuitMapper;
import org.usfirst.frc.team1002.server.net.CircuitSender;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

public class CircuitInit {

        CircuitServer server;
        CircuitMapper mapper;
        CircuitSender sender;

        public CircuitInit(Joystick[] sticks, Victor[] driveMotors, Victor[] modules) {
            sender = new CircuitSender();
            mapper = new CircuitMapper(sticks, driveMotors, modules);
            server = new CircuitServer(sender, mapper);
        }
}
