package com.lme;

import lombok.NonNull;
import lombok.ToString;

@ToString
public class BasicRobot implements Robot {
    private final int id;
    private final Grid grid;
    private Coordinate coordinate;
    private Direction direction;
    private Cardinal cardinal;
    private boolean isLost = false;

    public BasicRobot(final int id, @NonNull final Grid grid, @NonNull final Coordinate coordinate, @NonNull final Cardinal cardinal) throws Exception {
        this.id = id;
        this.grid = grid;
        if (!grid.contains(coordinate.getX(),coordinate.getY())) {
           throw new Exception("Invalid Coordinate "+ coordinate.toString());
        }
        this.coordinate = coordinate;
        this.cardinal = cardinal;
    }

    @Override
    public int getId() {
        return id;
    }

    //TODO
    @Override
    public boolean move(@NonNull final Direction newDirection) {
        switch(newDirection) {
            case RIGHT: {
                if (!grid.contains(coordinate.getX()+1, coordinate.getY())) {
                    this.setLost(newDirection);
                    return false;
                } else if (!grid.getCoordinate(coordinate.getX()+1, coordinate.getY()).containsScent(cardinal, newDirection)) {
                    this.direction = newDirection;
                    this.coordinate = grid.getCoordinate(coordinate.getX()+1, coordinate.getY());
                    return true;
                }
                break;
            }
            default:
                return false;
        }
        return false;
    }

    //TODO: Is this required?
    @Override
    public void turn(Cardinal cardinal) {
        this.cardinal = cardinal;
    }

    @Override
    public Cardinal getCurrentCardinal() {
        return cardinal;
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return coordinate;
    }

    @Override
    public Direction getCurrentDirection() {
        return direction;
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

    private void setLost(Direction newDirection) {
        coordinate.addScent(new Scent(cardinal, newDirection));
        this.isLost = true;
    }

    @Override
    public boolean isLost() {
        return isLost;
    }
}
