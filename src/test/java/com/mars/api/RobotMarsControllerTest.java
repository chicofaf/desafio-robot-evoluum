package com.mars.api;

import com.mars.api.controller.RobotMarsController;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RobotMarsControllerTest {
    @Test
    public void testProcessWalkCommandsWithValidInstructions(){
        ResponseEntity mockResponse = new ResponseEntity<>("(2,0,S)", HttpStatus.OK);
        RobotMarsController controller  = mock(RobotMarsController.class);
        when(controller.processWalkCommands("MMRMMRMM")).thenReturn(mockResponse);
        ResponseEntity responseEntity = controller.processWalkCommands("MMRMMRMM");
        assertEquals(responseEntity.getBody(),"(2,0,S)");
    }
}
