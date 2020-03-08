package com.lme;

import static com.lme.Direction.FORWARD;
import static com.lme.Orientation.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicRobotMovesForwardTest {

  private int robotId = 1;
  private int initialGridX = 3;
  private int initialGridY = 3;

  private Grid grid;

  @BeforeEach
  public void setup() {
    grid = new Grid(initialGridX, initialGridY);
  }

  @Test
  @SneakyThrows
  public void testFORWARDMoveSetsChangesStateInRobotAndCoordinate() {
    Coordinate initialCoordinate = grid.getCoordinate(1, 1);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, WEST);
    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertTrue(unit.move(FORWARD));
    assertEquals(unit.getCurrentOrientation(), WEST);
    assertEquals(new Coordinate(0, 1), unit.getCurrentCoordinate());
    assertEquals(unit.getCurrentDirection(), FORWARD);
    assertEquals(unit.getId(), robotId);
    assertFalse(unit.isLost());
  }

  @Test
  @SneakyThrows
  public void testWhenRobotIsAskedToMoveOutOfTheLastCoordinateRobotIsLostAndScented() {
    Coordinate initialCoordinate = grid.getCoordinate(0, 1);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, WEST);

    assertTrue(unit.getId() == robotId);
    assertTrue(unit.getCurrentCoordinate().equals(initialCoordinate));
    assertTrue(unit.getCurrentOrientation().equals(WEST));
    assertFalse(unit.move(FORWARD));
    assertTrue(unit.getCurrentCoordinate().equals(initialCoordinate));
    assertTrue(unit.isLost());
    assertTrue(initialCoordinate.isScented());
    final Set<Scent> scentSet = initialCoordinate.getScentSet();
    assertTrue(scentSet.size() == 1);
    Scent scent = scentSet.stream().findFirst().get();
    assertTrue(scent.getOrientation().equals(WEST));
    assertTrue(scent.getDirection().equals(FORWARD));
  }

  @Test
  @SneakyThrows
  public void testWhenRobotIsAskedToMoveOutToScentButDoesNotMove() {
    Coordinate initialCoordinate = grid.getCoordinate(0, 0);
    initialCoordinate.addScent(new Scent(WEST, FORWARD));
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, WEST);

    assertFalse(unit.move(FORWARD));
    assertFalse(unit.isLost());
  }

  @Test
  @SneakyThrows
  public void testGivenEastWhenFORWARDMovedThenRobotMovedFORWARD() {
    Coordinate initialCoordinate = grid.getCoordinate(1, 1);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, WEST);
    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertTrue(unit.move(FORWARD));
    assertTrue(unit.getCurrentOrientation().equals(WEST));
    assertEquals(unit.getCurrentCoordinate(), new Coordinate(0, 1));
    assertEquals(unit.getCurrentDirection(), FORWARD);
    assertEquals(unit.getId(), robotId);
    assertFalse(unit.isLost());
  }

  @Test
  @SneakyThrows
  public void testRightMoveSetsChangesStateInRobotAndCoordinate() {
    Coordinate initialCoordinate = grid.getCoordinate(1, 1);
    BasicRobot unit = new BasicRobot(robotId, grid, initialCoordinate, WEST);

    assertEquals(unit.getCurrentCoordinate(), initialCoordinate);
    assertTrue(unit.move(FORWARD));
    assertEquals(unit.getCurrentOrientation(), WEST);
    assertEquals(new Coordinate(0, 1), unit.getCurrentCoordinate());
    assertEquals(unit.getCurrentDirection(), FORWARD);
    assertEquals(unit.getId(), robotId);
    assertFalse(unit.isLost());
  }
}
