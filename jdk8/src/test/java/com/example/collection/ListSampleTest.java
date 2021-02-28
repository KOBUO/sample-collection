package com.example.collection;

import com.example.testing.AbstractTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Enclosed.class)
public class ListSampleTest extends AbstractTest {

    @RunWith(Theories.class)
    public static class CreateTest {

        @DataPoints
        public static FixtureByLabel<String[], List<String>>[] fixtures = toArray(
                new FixtureByLabel<>("test", toArray("a"), toList("a"))
        );

        @Theory
        public void test(final FixtureByLabel<String[], List<String>> fixture) {
            assumeCase(fixture);
            assertThat(fixture.getExpected(), is(ListSample.create(fixture.getInput1())));
        }
    }
}