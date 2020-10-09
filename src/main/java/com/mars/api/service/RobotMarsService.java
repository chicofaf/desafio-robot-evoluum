package com.mars.api.service;

import com.mars.api.controller.RobotMarsController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RobotMarsService {

    @PostMapping("rest/mars/{instructions}")
    public ResponseEntity walkOnMars(@PathVariable("instructions") String instructions) {
        return new RobotMarsController().processWalkCommands(instructions);
    }


}
