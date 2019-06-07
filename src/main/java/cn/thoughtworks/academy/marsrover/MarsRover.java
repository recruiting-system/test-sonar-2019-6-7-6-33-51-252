package cn.thoughtworks.academy.marsrover;

import static cn.thoughtworks.academy.marsrover.Direction.WEST;

public class MarsRover {

    private final Rover[][] rovers;
    private Rover rover;
    private int x;
    private int y;

    public MarsRover(int width, int height) {
        rovers = new Rover[width + 1][height + 1];
    }

    public MarsRover place(Rover rover) {
        rover.setMarsRover(this);
        this.rover = rover;
        return this;
    }

    public MarsRover at(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public void faceTo(Direction direction) {
        rover.setDirection(direction);
        rovers[x][y] = rover;
    }

    public Rover get(int x, int y) {
        return rovers[x][y];
    }


    public MarsRover move(Rover rover) throws RoverNotFoundException {
        for (int x = 0; x < rovers.length; x++) {
            for (int y = 0; y < rovers[x].length; y++) {
                if (rover.equals(rovers[x][y])) {
                    this.x = x;
                    this.y = y;
                    return this;
                }
            }
        }
        throw new RoverNotFoundException();
    }

    public void to(Direction direction) {
        if (direction.equals(WEST)) {
            rovers[x - 1][y] = rovers[x][y];
        } else if (direction.equals(Direction.SOUTH)) {
            rovers[x][y - 1] = rovers[x][y];
        } else if (direction.equals(Direction.EAST)) {
            rovers[x + 1][y] = rovers[x][y];
        } else if (direction.equals(Direction.NORTH)) {
            rovers[x][y + 1] = rovers[x][y];
        }
        rovers[x][y] = null;
    }
}
