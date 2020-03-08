package com.lme;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Grid {
    private Map<String, Coordinate> coordinateMap;

    Grid(int x, int y) {
        coordinateMap = new HashMap<>(x*y);
        IntStream.range(0,x).forEach( x1-> IntStream.range(0,y).forEach(y1-> coordinateMap.put(x1+"|"+y1, new Coordinate(x1,y1))));
        System.out.println("coordinateMap is "+ coordinateMap);
        System.out.println("coordinateMap contains 0,1 - " + coordinateMap.containsKey("0|1") + " " + coordinateMap.containsValue(new Coordinate(0,1)));
        System.out.println("coordinateMap contains 5,5 - " + coordinateMap.containsKey("5|5") + " " + coordinateMap.containsValue(new Coordinate(5,5)));

    }

    boolean contains(int x,  int y) {
        return coordinateMap.containsKey(x+"|"+y);
    }

    public Coordinate getCoordinate(int x, int y) {
        return  coordinateMap.get(x+"|"+y);
    }

//Do Something on the computer
}
