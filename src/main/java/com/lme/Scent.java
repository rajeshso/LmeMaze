package com.lme;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Scent {
  private final Orientation orientation;
  private final Direction direction;
}
