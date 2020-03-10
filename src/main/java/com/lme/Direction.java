package com.lme;

import java.util.Arrays;
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
    //Default is Forward
    return Arrays.stream(values()).filter( v -> v.id == id).findAny().orElse(FORWARD);
  }

}
