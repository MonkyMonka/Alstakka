package com.monky.alstakka.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum DupeVariant {
    ONE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7);

    private static final DupeVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(DupeVariant::getId)).toArray(DupeVariant[]::new);
    private final int id;

    DupeVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static DupeVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
