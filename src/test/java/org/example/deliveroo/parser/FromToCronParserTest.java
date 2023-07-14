package org.example.deliveroo.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;

class FromToCronParserTest {

    private FromToCronParser parser;

    @BeforeEach
    void setUp() {
        parser = new FromToCronParser();
    }

    @Test
    void parseInterval() {
        Set<String> values = parser.parse("2-5", 0, 8).stream().collect(Collectors.toSet());
        assertEquals(Set.of("2", "3", "4", "5"), values);
    }

    @Test
    void parse_fromHigherThenMax_throwException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> parser.parse("100-500", 1, 8))
                .withMessage("Value '100' should be int interval [1,7]");
    }

    @Test
    void parse_fromLowerThenMin_throwException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> parser.parse("0-5", 1, 8))
                .withMessage("Value '0' should be int interval [1,7]");
    }

    @Test
    void parse_toHigherThenMax_throwException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> parser.parse("1-100", 1, 8))
                .withMessage("Value '100' should be int interval [1,7]");
    }

    @Test
    void parse_fromHigherThenTo_throwException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> parser.parse("5-1", 1, 8))
                .withMessage("Input validation failed. Value 5 should be more then 1");
    }
}