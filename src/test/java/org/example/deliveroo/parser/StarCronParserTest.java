package org.example.deliveroo.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

class StarCronParserTest {

    private StarCronParser parser;

    @BeforeEach
    void setUp() {
        parser = new StarCronParser();
    }

    @Test
    void parseFromTo() {
        Set<String> actual = parser.parse("*", 0, 8).stream().collect(Collectors.toSet());
        assertEquals(Set.of("0", "1", "2", "3", "4", "5", "6", "7"), actual);
    }
}