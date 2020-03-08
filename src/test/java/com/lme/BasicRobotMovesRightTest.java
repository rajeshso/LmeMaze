package com.lme;

import static com.lme.Direction.RIGHT;
import static com.lme.Orientation.NORTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class BasicRobotMovesRightTest {

  private int robotId = 1;
  private int initialGridX = 3;
  private int initialGridY = 3;
  private int initialCoordinateX = 0;
  private int initialCoordinateY = 0;
  private Orientation orientation = NORTH;


  @Test
  @SneakyThrows
  public void testRightMoveSetsChangesStateInRobotAndCoordinate() {
    Grid grid = new Grid(initialGridX, initialGridY);
    Coordinate initialCoordinate = grid.getCoordinate(initialCoordinateX, initialCoordinateY);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, orientation);

    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertTrue(unit.move(RIGHT));
    assertEquals(unit.getCurrentOrientation(), NORTH);
    assertEquals(unit.getCurrentCoordinate(),
        new Coordinate(initialCoordinateX + 1, initialCoordinateY));
    assertEquals(unit.getCurrentDirection(), RIGHT);
    assertEquals(unit.getId(), robotId);
    assertFalse(unit.isLost());
  }

  @Test
  @SneakyThrows
  public void testWhenRobotIsAskedToMoveOutOfTheLastCoordinateRobotIsLostAndScented() {
    Grid grid = new Grid(initialGridX, initialGridY);
    Coordinate initialCoordinate = grid.getCoordinate(2, 0);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, orientation);

    assertEquals(unit.getId(), robotId);
    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertEquals(unit.getCurrentOrientation(), NORTH);
    assertFalse(unit.move(RIGHT));
    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertTrue(unit.isLost());
    assertTrue(initialCoordinate.isScented());
    final Set<Scent> scentSet = initialCoordinate.getScentSet();
    assertTrue(scentSet.size() == 1);
    Scent scent = scentSet.stream().findFirst().get();
    assertEquals(scent.getOrientation(), NORTH);
    assertEquals(scent.getDirection(), RIGHT);
  }

  @Test
  @SneakyThrows
  public void testWhenRobotIsAskedToMoveOutToScentButDoesNotMove() {
    Grid grid = new Grid(initialGridX, initialGridY);
    Coordinate initialCoordinate = grid.getCoordinate(2, 0);
    initialCoordinate.addScent(new Scent(NORTH, RIGHT));
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, orientation);
    assertFalse(unit.move(RIGHT));
    assertFalse(unit.isLost());
  }
}
