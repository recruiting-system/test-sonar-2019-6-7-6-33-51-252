package cn.thoughtworks.academy.marsrover;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static cn.thoughtworks.academy.marsrover.Direction.*;
import static cn.thoughtworks.academy.marsrover.RoverCommand.MOVE;
import static cn.thoughtworks.academy.marsrover.RoverCommand.TURN_LEFT;
import static cn.thoughtworks.academy.marsrover.RoverCommand.TURN_RIGHT;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class MarsRoverTest {

    private MarsRover marsRover;

    @Before
    public void setUp() throws Exception {
        marsRover = new MarsRover(5, 5);
    }

    @Test
    public void should_init_app() {
        assertNotNull(marsRover);
    }

    @Test
    public void should_place_rover_on_the_map() {
        Rover rover = new Rover();

        marsRover.place(rover).at(1, 2).faceTo(NORTH);

        Rover roverOnMap = marsRover.get(1, 2);
        assertEquals(rover, roverOnMap);
        assertEquals(NORTH, rover.getDirection());
    }

    @Test
    public void should_execute_commands() {
        Rover rover = new Rover();
        marsRover.place(rover).at(1, 2).faceTo(NORTH);

        List<RoverCommand> commands = new ArrayList<RoverCommand>();
        commands.add(TURN_LEFT);
        commands.add(MOVE);
        commands.add(TURN_LEFT);
        commands.add(MOVE);
        commands.add(TURN_LEFT);
        commands.add(MOVE);
        commands.add(TURN_LEFT);
        commands.add(MOVE);
        commands.add(MOVE);
        rover.execute(commands);

        Rover roverOnMap = marsRover.get(1, 3);
        assertEquals(rover, roverOnMap);
        assertEquals(NORTH, rover.getDirection());
    }

    @Test
    public void should_execute_more_commands() {
        Rover rover = new Rover();
        marsRover.place(rover).at(3, 3).faceTo(EAST);

        List<RoverCommand> commands = new ArrayList<RoverCommand>();
        commands.add(MOVE);
        commands.add(MOVE);
        commands.add(TURN_RIGHT);
        commands.add(MOVE);
        commands.add(MOVE);
        commands.add(TURN_RIGHT);
        commands.add(MOVE);
        commands.add(TURN_RIGHT);
        commands.add(TURN_RIGHT);
        commands.add(MOVE);
        rover.execute(commands);

        Rover roverOnMap = marsRover.get(5, 1);
        assertEquals(rover, roverOnMap);
        assertEquals(EAST, rover.getDirection());
    }
}
