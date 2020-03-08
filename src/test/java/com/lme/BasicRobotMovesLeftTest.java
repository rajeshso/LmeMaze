package com.lme;

import static com.lme.Direction.LEFT;
import static com.lme.Orientation.EAST;
import static com.lme.Orientation.SOUTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class BasicRobotMovesLeftTest {

  private int robotId = 1;
  private int initialGridX = 3;
  private int initialGridY = 3;

  @Test
  @SneakyThrows
  public void testLeftMoveSetsChangesStateInRobotAndCoordinate() {
    Grid grid = new Grid(initialGridX, initialGridY);
    Coordinate initialCoordinate = grid.getCoordinate(1, 1);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, SOUTH);

    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertTrue(unit.move(LEFT));
    assertEquals(unit.getCurrentOrientation(), SOUTH);
    assertEquals(new Coordinate(0, 1), unit.getCurrentCoordinate());
    assertEquals(unit.getCurrentDirection(), LEFT);
    assertEquals(unit.getId(), robotId);
    assertFalse(unit.isLost());
  }

  @Test
  @SneakyThrows
  public void testWhenRobotIsAskedToMoveOutOfTheLastCoordinateRobotIsLostAndScented() {
    Grid grid = new Grid(initialGridX, initialGridY);
    Coordinate initialCoordinate = grid.getCoordinate(0, 1);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, SOUTH);

    assertEquals(unit.getId(), robotId);
    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertEquals(unit.getCurrentOrientation(), SOUTH);
    assertFalse(unit.move(LEFT));
    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertTrue(unit.isLost());
    assertTrue(initialCoordinate.isScented());
    final Set<Scent> scentSet = initialCoordinate.getScentSet();
    assertTrue(scentSet.size() == 1);
    Scent scent = scentSet.stream().findFirst().get();
    assertTrue(scent.getOrientation().equals(SOUTH));
    assertTrue(scent.getDirection().equals(LEFT));
  }

  @Test
  @SneakyThrows
  public void testWhenRobotIsAskedToMoveOutToScentButDoesNotMove() {
    Grid grid = new Grid(initialGridX, initialGridY);
    Coordinate initialCoordinate = grid.getCoordinate(0, 0);
    initialCoordinate.addScent(new Scent(SOUTH, LEFT));
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, SOUTH);

    assertFalse(unit.move(LEFT));
    assertFalse(unit.isLost());
  }

  @Test
  @SneakyThrows
  public void testGivenEastWhenLeftMovedThenRobotMovedLeft() {
    Grid grid = new Grid(initialGridX, initialGridY);
    Coordinate initialCoordinate = grid.getCoordinate(1, 1);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, EAST);

    assertTrue(unit.getCurrentCoordinate().equals(initialCoordinate));
    assertTrue(unit.move(LEFT));
    assertTrue(unit.getCurrentOrientation().equals(EAST));
    assertTrue(unit.getCurrentCoordinate().equals(new Coordinate(1, 1 + 1)));
    assertTrue(unit.getCurrentDirection().equals(LEFT));
    assertTrue(unit.getId() == robotId);
    assertFalse(unit.isLost());
  }

  @Test
  @SneakyThrows
  public void testRightMoveSetsChangesStateInRobotAndCoordinate() {
    Grid grid = new Grid(initialGridX, initialGridY);
    Coordinate initialCoordinate = grid.getCoordinate(1, 1);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, SOUTH);

    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertTrue(unit.move(LEFT));
    assertEquals(unit.getCurrentOrientation(), SOUTH);
    assertEquals(new Coordinate(0, 1), unit.getCurrentCoordinate());
    assertEquals(unit.getCurrentDirection(), LEFT);
    assertEquals(unit.getId(), robotId);
    assertFalse(unit.isLost());
  }
}
