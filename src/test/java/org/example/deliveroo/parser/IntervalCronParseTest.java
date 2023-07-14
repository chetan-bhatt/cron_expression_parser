package org.example.deliveroo.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

class IntervalCronParseTest {

    private IntervalCronParser parser;

    @BeforeEach
    void setUp() {
        parser = new IntervalCronParser();
    }

    @Test
    void parseInterval() {
        Set<String> actual = parser.parse("*/15", 0, 60).stream().collect(Collectors.toSet());
        assertEquals(Set.of("0", "15", "30", "45"), actual);
    }

    @Test
    void parseInterval_higherThenMax_returnZero() {
        Set<String> actual = parser.parse("*/75", 0, 60).stream().collect(Collectors.toSet());
        assertEquals(Set.of("0"), actual);
    }

}