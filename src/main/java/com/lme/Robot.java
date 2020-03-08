package com.lme;

public interface Robot {

  int getId();

  boolean move(Direction direction);

  Orientation getCurrentOrientation();

  Coordinate getCurrentCoordinate();

  Direction getCurrentDirection();

  boolean isLost();
}
