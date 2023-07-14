package org.example.deliveroo.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertArrayEquals;

class CommaSeparatedCronParserTest {

    private CommaSeparatedCronParser parser;

    @BeforeEach
    void setUp() {
        parser = new CommaSeparatedCronParser();
    }


}