package com.lme;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Scent {
    private final Cardinal cardinal;
    private final Direction direction;
}
