package com.lme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GridTests {

  @Test
  public void testCreateGridShouldResultInAllTheValuesInCoordinate() {
    Grid unit = new Grid(2, 2);
    assertTrue(unit.contains(0,0));
    assertTrue(unit.contains(0,1));
    assertTrue(unit.contains(1,0));
    assertTrue(unit.contains(1,1));
    assertFalse(unit.contains(2,2));
  }

  @Test
  public void testCreateGridShouldGetAllTheValuesInCoordinate() {
    Grid unit = new Grid(2, 2);
    assertEquals( 0, unit.getCoordinate(0,0).getX());
    assertEquals( 0, unit.getCoordinate(0,0).getY());

    assertEquals( 0, unit.getCoordinate(0,1).getX());
    assertEquals( 1, unit.getCoordinate(0,1).getY());

    assertEquals( 1, unit.getCoordinate(1,0).getX());
    assertEquals( 0, unit.getCoordinate(1,0).getY());

    assertEquals( 1, unit.getCoordinate(1,1).getX());
    assertEquals( 1, unit.getCoordinate(1,1).getY());
  }

}
