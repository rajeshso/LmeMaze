package com.lme;

import java.util.HashSet;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Coordinate {

  private final int x;
  private final int y;
  private Set<Scent> scentSet;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
    this.scentSet = new HashSet<>();
  }

  public void addScent(Scent scent) {
    scentSet.add(scent);
  }

  public boolean isScented() {
    return scentSet.size() != 0;
  }

  boolean containsScent(Orientation orientation, Direction direction) {
    return this.scentSet.contains(new Scent(orientation, direction));
  }
}