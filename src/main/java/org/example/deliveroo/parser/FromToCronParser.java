package org.example.deliveroo.parser;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.example.deliveroo.parser.CronParser.validate;

/**
 * Parse cron parameter separated by "-" i.e the parameter is in the form of range.
 * For example 2-5 will return 2,3,4,5.
 * <p>
 * If parameter not in range [min,max) throws IllegalArgumentException.
 */
class FromToCronParser implements CronParser{
    @Override
    public Set<String> parse(String input, int min, int max) {
        String[] split = input.split("-");
        if(split.length != 2){
            throw new IllegalArgumentException("Invalid input:" + input);
        }
        validate(split[0], min, max);
        validate(split[1], min, max);
        int from = Integer.valueOf(split[0]);
        int to = Integer.valueOf(split[1]);
        validateFromTo(from, to);
        Set<String> result = new LinkedHashSet<>();
        for (int i = from; i <= to; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

    private static void validateFromTo(int from, int to) {
        if (from < 0 || to < 0) {
            throw new IllegalArgumentException("Values [" + from + "," + to + "] should be positive");
        }
        if (from > to) {
            throw new IllegalArgumentException("Input validation failed. Value " + from + " should be more then " + to);
        }
    }
}
