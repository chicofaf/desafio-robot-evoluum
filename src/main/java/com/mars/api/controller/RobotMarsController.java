package com.mars.api.controller;

import com.mars.api.robot.CommandProcessor;
import org.springframework.http.ResponseEntity;

public class RobotMarsController {
    public ResponseEntity processWalkCommands(String instructionsInput){
        return new CommandProcessor().processInstructions(instructionsInput);
    }
}
