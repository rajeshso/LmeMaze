package com.lme;

import lombok.Getter;

@Getter
public enum Direction {

  LEFT('L'),
  RIGHT('R'),
  FORWARD('F');

  private final Character id;


  Direction(Character id) {
    this.id = id;
  }

  public static Direction id(Character id) {
    for (Direction e : values()) {
      if (e.id == id) {
        return e;
      }
    }
    return null;
  }

}
