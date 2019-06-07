package cn.thoughtworks.academy.marsrover;

import java.util.List;

import static cn.thoughtworks.academy.marsrover.Direction.*;
import static cn.thoughtworks.academy.marsrover.RoverCommand.MOVE;
import static cn.thoughtworks.academy.marsrover.RoverCommand.TURN_LEFT;
import static cn.thoughtworks.academy.marsrover.RoverCommand.TURN_RIGHT;

public class Rover {
    private Direction direction;
    private MarsRover marsRover;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void execute(List<RoverCommand> commands) {
        for (RoverCommand command : commands) {
            execute(command);
        }
    }

    private void execute(RoverCommand command) {
        if (command.equals(TURN_LEFT)) {
            turnLeft();
        } else if (command.equals(TURN_RIGHT)) {
            turnRight();
        } else if (command.equals(MOVE)) {
            moveForward();
        }

    }

    private void turnRight() {
        if (direction.equals(NORTH)) {
            this.direction = EAST;
        } else if (direction.equals(WEST)) {
            this.direction = NORTH;
        } else if (direction.equals(SOUTH)) {
            this.direction = WEST;
        } else if (direction.equals(EAST)) {
            this.direction = SOUTH;
        }
    }

    private void moveForward() {
        try {
            marsRover.move(this).to(this.direction);
        } catch (RoverNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void turnLeft() {
        if (direction.equals(NORTH)) {
            this.direction = WEST;
        } else if (direction.equals(WEST)) {
            this.direction = SOUTH;
        } else if (direction.equals(SOUTH)) {
            this.direction = EAST;
        } else if (direction.equals(EAST)) {
            this.direction = NORTH;
        }
    }

    public void setMarsRover(MarsRover marsRover) {
        this.marsRover = marsRover;
    }
}
