package com.example.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListSample {

    @SafeVarargs
    public static <T> List<T> create(final T... t) {
        return Arrays.stream(t).collect(Collectors.toList());
    }

    @SafeVarargs
    public static <T> List<T> createByLimit1(final int limit, final T... t) {
        return create(t).stream().limit(limit).collect(Collectors.toList());
    }

    @SafeVarargs
    public static <T> List<T> createByLimit2(final int limit, final T... t) {
        return Arrays.stream(t, 0, limit).collect(Collectors.toList());
    }
}
