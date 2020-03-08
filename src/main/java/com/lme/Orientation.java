package com.lme;

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

  public static Orientation id(Character id) {
    for (Orientation e : values()) {
      if (e.id == id) {
        return e;
      }
    }
    return null;
  }
}
