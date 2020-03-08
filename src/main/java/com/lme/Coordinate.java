package com.lme;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.Set;

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
        this.scentSet = Collections.emptySet();
    }

    public void addScent(Scent scent) {
        scentSet.add(scent);
    }

    public boolean isScented() {
        return scentSet.size()!=0;
    }

    public boolean containsScent(Cardinal cardinal, Direction direction) {
        return this.scentSet.contains(new Scent(cardinal, direction));
    }
}