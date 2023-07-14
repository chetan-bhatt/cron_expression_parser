package org.example.deliveroo.parser;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

/**
 * This class returns the instance of parser depending upon the input passed.
 */
@Slf4j
public class CronExpressionParserFactory {

    private static final Map<String, CronParser> patternToParserMap = Map.of(
            "^\\*$", new StarCronParser(),
            "^\\d+(,\\d+)*$", new CommaSeparatedCronParser(),
            "^\\d+-\\d+$", new FromToCronParser(),
            "^\\*/\\d+$", new IntervalCronParser()
    );

    public static Optional<CronParser> getParser(String input){
        for(Map.Entry<String, CronParser> entry : patternToParserMap.entrySet()){
            if(input.matches(entry.getKey())){
                log.info("input = {}, parser = {}", input, entry.getValue().getClass().getName());
                return Optional.of(entry.getValue());
            }
        }
        return Optional.ofNullable(null);
    }
}