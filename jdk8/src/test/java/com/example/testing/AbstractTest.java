package com.example.testing;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assume.assumeTrue;

public class AbstractTest {

    @Getter
    @AllArgsConstructor
    protected static class Fixture<T, R> {
        private final T input1;
        private final R expected;
    }

    @Getter
    @AllArgsConstructor
    protected static class BiFixture<T, U, R> {
        private final T input1;
        private final U input2;
        private final R expected;
    }

    @Getter
    @AllArgsConstructor
    protected static class FixtureByLabel<T, R> {
        private final String label;
        private final T input1;
        private final R expected;
    }

    @Getter
    protected static class BiFixtureByLabel<T, U, R> extends FixtureByLabel<T, R> {
        private final U input2;

        public BiFixtureByLabel(final String label, final T input1, final U input2, final R expected) {
            super(label, input1, expected);
            this.input2 = input2;
        }
    }

    protected static <T, R> void assumeCase(final FixtureByLabel<T, R> fixture) {
        assumeTrue(Arrays.stream(Thread.currentThread().getStackTrace())
                .anyMatch(i -> fixture.label.equals(i.getMethodName())));
    }

    @SafeVarargs
    protected static <T> T[] toArray(final T... t) {
        return t;
    }

    @SafeVarargs
    protected static <T> List<T> toList(final T... t) {
        return Arrays.asList(t);
    }
}
