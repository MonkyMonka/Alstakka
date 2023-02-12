package com.monky.alstakka.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum AlstakkaVariant {
    BLACK(0),
    BROWN(1),
    CREAMY(2),
    WHITE(3);

    private static final AlstakkaVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(AlstakkaVariant::getId)).toArray(AlstakkaVariant[]::new);
    private final int id;

    AlstakkaVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static AlstakkaVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
