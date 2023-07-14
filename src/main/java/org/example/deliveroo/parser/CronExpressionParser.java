package org.example.deliveroo.parser;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Set;


/**
 *
 * This class represents the parser.
 */

@Slf4j
public class CronExpressionParser {

    /**
     * This method parses the input string and returns the result in Set.
     * Depending upon the input, a corresponding parser is invoked.
     *
     * @param input
     * @param min
     * @param max
     * @return
     */
    public static Set<String> parseCron(String input, int min, int max) {
        log.info("parsing input {}", input);
        Optional<CronParser> parser = CronExpressionParserFactory.getParser(input);
        if(parser.isPresent()){
            return parser.get().parse(input, min, max);
        }
        throw new IllegalArgumentException("Not able to parse input : " + input);
    }
}
