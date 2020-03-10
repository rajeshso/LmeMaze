package com.lme;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum Orientation {
  NORTH('N'),
  SOUTH('S'),
  WEST('W'),
  EAST('E');

  private final Character id;

  Orientation(Character id) {
    this.id = id;
  }

  //Default is North
  public static Orientation id(Character id) {
    return Arrays.stream(values()).filter(v -> v.id == id).findAny().orElse(NORTH);
  }
}
