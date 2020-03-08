package com.lme;

import static com.lme.Direction.FORWARD;
import static com.lme.Direction.LEFT;
import static com.lme.Direction.RIGHT;
import static com.lme.Orientation.EAST;
import static com.lme.Orientation.NORTH;
import static com.lme.Orientation.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class TwoRobotsTests {

  private int robotId1 = 1;
  private int robotId2 = 2;

  private int initialGridX = 5;
  private int initialGridY = 3;

  @Test
  @SneakyThrows
  public void testTwoRobotsShouldNotBeFunctionalIfLost() {
    Grid grid = new Grid(initialGridX, initialGridY);

    Coordinate initialCoordinateRobot1 = grid.getCoordinate(0, 0);
    Coordinate initialCoordinateRobot2 = grid.getCoordinate(4, 2);

    BasicRobot robot1 = new BasicRobot(robotId1, grid, initialCoordinateRobot1, WEST);
    BasicRobot robot2 = new BasicRobot(robotId2, grid, initialCoordinateRobot2, EAST);

    robot1.move(FORWARD);
    robot2.move(FORWARD);

    assertEquals("0 0 W LOST", robot1.toString());
    assertEquals("4 2 E LOST", robot2.toString());

    robot1.move(FORWARD);
    robot2.move(FORWARD);

    assertEquals("0 0 W LOST", robot1.toString());
    assertEquals("4 2 E LOST", robot2.toString());
  }

  @Test
  @SneakyThrows
  public void testTwoRobotsShouldShareTheSameGrid() {
    Grid grid = new Grid(initialGridX, initialGridY);

    Coordinate initialCoordinateRobot1 = grid.getCoordinate(1, 1);
    Coordinate initialCoordinateRobot2 = grid.getCoordinate(3, 2);

    BasicRobot robot1 = new BasicRobot(robotId1, grid, initialCoordinateRobot1, EAST);
    BasicRobot robot2 = new BasicRobot(robotId2, grid, initialCoordinateRobot2, NORTH);

    robot1.move(RIGHT);
    robot1.move(FORWARD);
    robot1.move(RIGHT);
    robot1.move(FORWARD);
    robot1.move(RIGHT);
    robot1.move(FORWARD);
    robot1.move(RIGHT);
    robot1.move(FORWARD);

    robot2.move(FORWARD);
    robot2.move(RIGHT);
    robot2.move(RIGHT);
    robot2.move(FORWARD);
    robot2.move(LEFT);
    robot2.move(LEFT);
    robot2.move(FORWARD);
    robot2.move(FORWARD);
    robot2.move(RIGHT);
    robot2.move(RIGHT);
    robot2.move(FORWARD);
    robot2.move(LEFT);
    robot2.move(LEFT);
    assertEquals("2 0 E LOST", robot1.toString());
    assertEquals("3 2 N LOST", robot2.toString());

  }

  @Test
  @SneakyThrows
  public void testRobot2ShouldIgnoreInstructionIfScented() {
    Grid grid = new Grid(initialGridX, initialGridY);

    Coordinate initialCoordinateRobot1 = grid.getCoordinate(0, 0);
    Coordinate initialCoordinateRobot2 = grid.getCoordinate(2, 1);

    BasicRobot robot1 = new BasicRobot(robotId1, grid, initialCoordinateRobot1, WEST);
    BasicRobot robot2 = new BasicRobot(robotId2, grid, initialCoordinateRobot2, WEST);

    robot1.move(FORWARD);
    assertTrue(robot1.isLost());

    robot2.move(LEFT);
    robot2.move(FORWARD);
    robot2.move(FORWARD);
    robot2.move(FORWARD);

    assertEquals("0 0 W LOST", robot1.toString());
    assertEquals("0 0 W ", robot2.toString());

    robot2.move(FORWARD);
    assertEquals("0 0 W ", robot2.toString());
    assertFalse(robot2.isLost());
  }

  @Test
  @SneakyThrows
  public void testRobot2ShouldTakeValidInstructionOnScentedCoordinate() {
    Grid grid = new Grid(initialGridX, initialGridY);

    Coordinate initialCoordinateRobot1 = grid.getCoordinate(0, 0);
    Coordinate initialCoordinateRobot2 = grid.getCoordinate(2, 1);

    BasicRobot robot1 = new BasicRobot(robotId1, grid, initialCoordinateRobot1, WEST);
    BasicRobot robot2 = new BasicRobot(robotId2, grid, initialCoordinateRobot2, WEST);

    robot1.move(FORWARD);
    assertTrue(robot1.isLost());

    robot2.move(LEFT);
    robot2.move(FORWARD);
    robot2.move(FORWARD);
    robot2.move(FORWARD);

    assertEquals("0 0 W LOST", robot1.toString());
    assertEquals("0 0 W ", robot2.toString());

    robot2.move(FORWARD);
    assertEquals("0 0 W ", robot2.toString());
    robot2.move(RIGHT);
    assertEquals("0 1 W ", robot2.toString());

  }

}
