package org.example.deliveroo.parser;

import java.util.HashSet;
import java.util.Set;

import static org.example.deliveroo.parser.CronParser.validate;

/**
 * Parse cron parameter separated by comma. Example 2,3.
 */
class CommaSeparatedCronParser implements CronParser {

    /**
     * @param input string to parse
     * @param min   value, for example for weeks it 1
     * @param max   value, not included for example for weeks it is 8
     * @return
     * @throws IllegalArgumentException in case the min, max values invalidates.
     */
    @Override
    public Set<String> parse(String input, int min, int max) {
        Set<String> result = new HashSet<>();
        String[] values = input.split(",");
        for (String value : values) {
            validate(value, min, max);
            result.add(value);
        }
        return result;
    }
}
