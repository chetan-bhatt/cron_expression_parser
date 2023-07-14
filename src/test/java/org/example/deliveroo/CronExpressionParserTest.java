package org.example.deliveroo;

import org.example.deliveroo.parser.CronExpressionParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CronExpressionParserTest {
    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("*", new String[]{"1", "2", "3", "4", "5", "6", "7"}),
                Arguments.of("*/3", new String[]{"1", "4", "7"}),
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("5-7", new String[]{"5", "6", "7"}),
                Arguments.of("6", new String[]{"6"})
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, String[] args) {
        Set<String> expected = Arrays.stream(args).collect(Collectors.toSet());
        Set<String> actual = CronExpressionParser.parseCron(input, 1, 8).stream().collect(Collectors.toSet());
        assertEquals(expected, actual);
    }
}
