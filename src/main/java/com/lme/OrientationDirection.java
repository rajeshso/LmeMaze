package com.lme;

import lombok.Getter;

@Getter
public enum OrientationDirection {

  NORTH_LEFT(-1, 0),
  NORTH_RIGHT(1, 0),
  NORTH_FORWARD(0, 1),

  SOUTH_LEFT(-1, 0),
  SOUTH_RIGHT(1, 0),
  SOUTH_FORWARD(0, -1),

  EAST_LEFT(0, 1),
  EAST_RIGHT(0, -1),
  EAST_FORWARD(1, 0),

  WEST_LEFT(0, -1),
  WEST_RIGHT(0, 1),
  WEST_FORWARD(-1, 0);

  private final int x;
  private final int y;

  OrientationDirection(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static OrientationDirection of(Orientation orientation, Direction direction) {
    return OrientationDirection.valueOf(orientation.name() + "_" + direction.name());
  }
}
