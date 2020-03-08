package com.lme;

import lombok.NonNull;

public class BasicRobot implements Robot {

  private final int id;
  private final Grid grid;
  private Coordinate coordinate;
  private Direction direction;
  private Orientation orientation;
  private boolean isLost = false;

  public BasicRobot(final int id, @NonNull final Grid grid, @NonNull final Coordinate coordinate,
      @NonNull final Orientation orientation) throws Exception {
    this.id = id;
    this.grid = grid;
    if (!grid.contains(coordinate.getX(), coordinate.getY())) {
      throw new Exception("Invalid Coordinate " + coordinate.toString());
    }
    this.coordinate = coordinate;
    this.orientation = orientation;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public boolean move(@NonNull final Direction newDirection) {
    OrientationDirection orientationDirection = OrientationDirection.of(orientation, newDirection);
    if (isLost()) {
      return false;
    } else if (getCurrentCoordinate().isScented() && getCurrentCoordinate().containsScent(
        orientation, newDirection)) {
      return false;
    } else if (!grid.contains(coordinate.getX() + orientationDirection.getX(),
        coordinate.getY() + orientationDirection.getY())) {
      this.setLost(newDirection);
      return false;
    } else {
      this.direction = newDirection;
      this.coordinate = grid.getCoordinate(coordinate.getX() + orientationDirection.getX(),
          coordinate.getY() + orientationDirection.getY());
      return true;
    }
  }

  @Override
  public Orientation getCurrentOrientation() {
    return orientation;
  }

  @Override
  public Coordinate getCurrentCoordinate() {
    return coordinate;
  }

  @Override
  public Direction getCurrentDirection() {
    return direction;
  }

  private void setLost(Direction newDirection) {
    coordinate.addScent(new Scent(orientation, newDirection));
    this.isLost = true;
  }

  @Override
  public boolean isLost() {
    return isLost;
  }

  @Override
  public String toString() {
    final Coordinate currentCoordinate = getCurrentCoordinate();
    String lost = isLost() ? "LOST" : "";
    return currentCoordinate.getX() + " " + currentCoordinate.getY() + " " + getCurrentOrientation()
        .getId() + " " + lost;
  }
}
