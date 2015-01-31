package org.usfirst.frc.team1002.server;

import java.util.Arrays;

import javax.net.ssl.SSLEngineResult.Status;

import org.usfirst.frc.team1002.server.mapper.CircuitMapper;
import org.usfirst.frc.team1002.server.net.CircuitSender;

public class CircuitServer {

    CircuitMapper mapper;
    CircuitSender sender;
    Arrays status;

	public CircuitServer(CircuitSender sender, CircuitMapper mapper) {
                this.sender = sender;
                this.mapper = mapper;
	}

    public CircuitServer getServer() {
        return this;
    }

    public CircuitSender getSender() {
        return sender;
    }

    public CircuitMapper getMapper() {
        return mapper;
    }

    public Status setStatus(int code) {
        return Status.BUFFER_OVERFLOW;
    }

    public void addStatus(int code) {
    	
    }

    public void rmStatus(int code) {
		
    }

    public String getStatusString(int code) {
        String status = null;
        return status;
    }
}
