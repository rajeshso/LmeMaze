package com.lme;

public class App {

  public static void main(String[] args) throws Exception {
    Grid grid = new Grid(5, 3);
    BasicRobot robot1 = new BasicRobot(1, grid, grid.getCoordinate(1, 1), Orientation.id('E'));
    //RFRFRFRF
    robot1.move(Direction.id('R'));
    robot1.move(Direction.id('F'));
    robot1.move(Direction.id('R'));
    robot1.move(Direction.id('F'));
    robot1.move(Direction.id('R'));
    robot1.move(Direction.id('F'));
    robot1.move(Direction.id('R'));
    robot1.move(Direction.id('F'));
    BasicRobot robot2 = new BasicRobot(2, grid, grid.getCoordinate(3, 2), Orientation.id('N'));
    //FRRFLLFFRRFLL
    robot2.move(Direction.id('F'));
    robot2.move(Direction.id('R'));
    robot2.move(Direction.id('R'));
    robot2.move(Direction.id('F'));
    robot2.move(Direction.id('L'));
    robot2.move(Direction.id('L'));
    robot2.move(Direction.id('F'));
    robot2.move(Direction.id('F'));
    robot2.move(Direction.id('R'));
    robot2.move(Direction.id('R'));
    robot2.move(Direction.id('L'));
    robot2.move(Direction.id('L'));

    System.out.println(robot1);
    System.out.println(robot2);

  }
}
