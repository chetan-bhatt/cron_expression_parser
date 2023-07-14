package org.example.deliveroo.parser;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Parse cron job interval parameter * /number.
 * Example - for minutes * /15 will return 0,15,30,45.
 * <p>
 * If parameter not in range then it will return 0. Example * /75
 */
class IntervalCronParser implements CronParser {

    @Override
    public Set<String> parse(String input, int min, int max) {
        int interval = parseIntFromString(input);
        if(interval < min && interval >= max){
            throw new IllegalArgumentException();
        }
        Set<String> result = new LinkedHashSet<>();
        for(int i = min; i < max; i += interval){
            result.add(String.valueOf(i));
        }
        return result;
    }

    private static int parseIntFromString(String arg) {
        return Integer.parseInt(arg.replaceAll("\\D+",""));
    }
}
