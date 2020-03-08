package com.lme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.lme.Cardinal.NORTH;
import static com.lme.Direction.RIGHT;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicRobotTest {
    private BasicRobot unit;
    int robotId = 1;
    int initialGridX = 3;
    int initialGridY = 3;
    int initialCoordinateX = 0;
    int initialCoordinateY = 0;
    Cardinal initialCardinal = NORTH;

    @BeforeEach
    public void setup() throws Exception {
        Grid grid = new Grid(initialGridX,initialGridY);
        Coordinate initialCoordinate = new Coordinate(initialCoordinateX,initialCoordinateY);
        unit = new BasicRobot(robotId, grid, initialCoordinate, initialCardinal);
    }

    @Test
    public void testRightMoveSetsChangesStateInRobotAndCoordinate() {
        assertTrue(unit.getCurrentCoordinate().equals(new Coordinate(initialCoordinateX, initialCoordinateY)));
        assertTrue(unit.move(RIGHT));
        assertTrue(unit.getCurrentCardinal().equals(NORTH));
        assertTrue(unit.getCurrentCoordinate().equals(new Coordinate(initialCoordinateX+1,initialCoordinateY)));
        assertTrue(unit.getCurrentDirection().equals(RIGHT));
        assertTrue(unit.getId() == robotId);
        assertFalse(unit.isLost());
    }

    @Test
    public void testWhenRobotIsAskedToMoveOutOfTheLastCoordinateRobotIsLostAndScented() {
        //unit.
    }
}
