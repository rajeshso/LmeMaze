package com.lme;

public interface Robot {
    int getId();
    boolean move(Direction direction);
    void turn(Cardinal cardinal);
    Cardinal getCurrentCardinal();
    Coordinate getCurrentCoordinate();
    Direction getCurrentDirection();
    Grid getGrid();
    //void setLost(Direction newDirection);
    boolean isLost();
}
