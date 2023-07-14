package org.example.deliveroo.parser;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Parse cron job interval parameter *.
 * Example for minutes * will return all numbers from 0 - 59.
 */
class StarCronParser implements CronParser{
    @Override
    public Set<String> parse(String input, int min, int max) {
        Set<String> result = new LinkedHashSet<>();
        for (int i = min; i < max; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }
}
