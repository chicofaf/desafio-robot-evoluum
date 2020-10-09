package com.mars.api;

import com.mars.api.robot.CommandProcessor;
import com.mars.api.robot.Commands;
import com.mars.api.robot.Robot;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommandProcessorTest {
    @Test
    public void processInstructionsWhenCommandIsInvalid(){
        ResponseEntity responseEntity = new CommandProcessor().processInstructions("KJH");
        assertEquals(responseEntity.getBody(), "Invalid command!");
    }
    @Test
    public void processInstructionsWhenCommandIsValid(){
        ResponseEntity mockResponse = new ResponseEntity<>("(2,0,S)", HttpStatus.OK);
        CommandProcessor commandProcessor  = mock(CommandProcessor.class);
        when(commandProcessor.processInstructions("MMRMMRMM")).thenReturn(mockResponse);
        ResponseEntity responseEntity = commandProcessor.processInstructions("MMRMMRMM");
        assertEquals(responseEntity.getBody(),"(2,0,S)");
    }
    @Test
    public void buildListInstructions(){
        ArrayList<String> result = new CommandProcessor().buildListInstructions("MMRMMRMM");
        assertEquals(result.isEmpty(),false);
    }

    @Test
    public void shouldValidatePosition(){
        assertEquals(new CommandProcessor().isValidPosition(4,4),true);
    }

    @Test
    public void shouldRotateRobot(){
        Robot robotMock = new Robot(0,0,"N");
        Robot result = new CommandProcessor().rotateDirection(robotMock, Commands.R.name());
        assertEquals(result.getCardinalPoint(),"E");
    }
    @Test
    public void shouldWalkForwardY(){
        Robot robotMock = new Robot();
        Robot result = new CommandProcessor().walkForwardAndBack(robotMock);
        assertEquals(result.getY(), 1);
    }
    @Test
    public void shouldWalkBackY(){
        Robot robotMock = new Robot(0,1,"S");
        Robot result = new CommandProcessor().walkForwardAndBack(robotMock);
        assertEquals(result.getY(), 0);
    }
    @Test
    public void shouldWalkForwardX(){
        Robot robotMock = new Robot(1,0,"W");
        Robot result = new CommandProcessor().walkForwardAndBack(robotMock);
        assertEquals(result.getX(), 0);
    }
    @Test
    public void shouldWalkBackX(){
        Robot robotMock = new Robot(0,0,"E");
        Robot result = new CommandProcessor().walkForwardAndBack(robotMock);
        assertEquals(result.getX(), 1);
    }
}
