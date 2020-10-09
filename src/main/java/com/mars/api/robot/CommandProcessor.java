package com.mars.api.robot;

import com.mars.api.exploration.CardinalPoints;
import com.mars.api.exploration.DirectionRules;
import com.mars.api.exploration.ExplorationArea;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CommandProcessor {
    public ResponseEntity processInstructions(String instructionsInput){
        if(!Pattern.compile("^[mMlLrR]+$").matcher(instructionsInput).matches()) {
            return new ResponseEntity<>( "Invalid command!", HttpStatus.BAD_REQUEST);
        }
        ArrayList<String> instructions = buildListInstructions(instructionsInput);
        return executeInstructions(instructions);
    }

    public ArrayList<String> buildListInstructions(String instructionsInput){
        char[] characters = instructionsInput.toCharArray();
        ArrayList<String> instructions = new ArrayList<>();
        for (char c : characters) {
            instructions.add(String.valueOf(c));
        }
        return instructions;
    }

    public ResponseEntity executeInstructions(ArrayList<String> instructions){
        Robot robot = new Robot();

        for(String instruction : instructions){
            if(instruction.equalsIgnoreCase(Commands.M.name())){
                robot = walkForwardAndBack(robot);
            } else {
                robot = rotateDirection(robot, instruction);
            }

        }
        if(!isValidPosition(robot.getX(),robot.getY())){
            return new ResponseEntity<>("Invalid position!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("("+ robot.getX()+","+ robot.getY()+","+ robot.getCardinalPoint()+")", HttpStatus.OK);
    }

    public Robot walkForwardAndBack(Robot robot){
        if(robot.getCardinalPoint().equalsIgnoreCase(CardinalPoints.N.name())){
            robot.setY(robot.getY() + 1);
            return robot;
        }
        if(robot.getCardinalPoint().equalsIgnoreCase(CardinalPoints.S.name())){
            robot.setY(robot.getY() - 1);
            return robot;
        }
        if(robot.getCardinalPoint().equalsIgnoreCase(CardinalPoints.E.name())){
            robot.setX(robot.getX() + 1);
            return robot;
        }
        if(robot.getCardinalPoint().equalsIgnoreCase(CardinalPoints.W.name())){
            robot.setX(robot.getX() - 1);
            return robot;
        }
        return robot;
    }

    public Robot rotateDirection(Robot robot, String instruction){
        if(instruction.equalsIgnoreCase(Commands.L.name())){
            robot.setCardinalPoint(DirectionRules.RULES.get(robot.getCardinalPoint()).get(Commands.L.name()));
        }
        if(instruction.equalsIgnoreCase(Commands.R.name())){
            robot.setCardinalPoint(DirectionRules.RULES.get(robot.getCardinalPoint()).get(Commands.R.name()));
        }
        return robot;
    }

    public Boolean isValidPosition(Integer x, Integer y){
        if(x >= ExplorationArea.X_MIN
        && x <= ExplorationArea.X_MAX
        && y >= ExplorationArea.Y_MIN
        && y <= ExplorationArea.Y_MAX){
            return true;
        }
        return false;
    }

}
