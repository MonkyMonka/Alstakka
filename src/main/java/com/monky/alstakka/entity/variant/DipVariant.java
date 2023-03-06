package com.monky.alstakka.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum DipVariant {
    ONE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7);

    private static final DipVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(DipVariant::getId)).toArray(DipVariant[]::new);
    private final int id;

    DipVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static DipVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
