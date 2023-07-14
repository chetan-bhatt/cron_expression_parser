package org.example.deliveroo.parser;

import org.junit.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CronExpressionParserFactoryTest {

    @Test
    public void testStarParser(){
        Optional<CronParser> parser = CronExpressionParserFactory.getParser(      "*");
        assertTrue(parser.isPresent());
        assertEquals(StarCronParser.class.getName(), parser.get().getClass().getName());
    }

    @Test
    public void testFromToParser(){
        Optional<CronParser> parser = CronExpressionParserFactory.getParser(      "1-5");
        assertTrue(parser.isPresent());
        assertEquals(FromToCronParser.class.getName(), parser.get().getClass().getName());
    }

    @Test
    public void testIntervalParser(){
        Optional<CronParser> parser = CronExpressionParserFactory.getParser(      "*/5");
        assertTrue(parser.isPresent());
        assertEquals(IntervalCronParser.class.getName(), parser.get().getClass().getName());
    }

    @Test
    public void testCommaSeparatedParser(){
        Optional<CronParser> parser = CronExpressionParserFactory.getParser(      "2,5");
        assertTrue(parser.isPresent());
        assertEquals(CommaSeparatedCronParser.class.getName(), parser.get().getClass().getName());
    }

    @Test
    public void testNullParser(){
        Optional<CronParser> parser = CronExpressionParserFactory.getParser(      "2:5");
        assertTrue(parser.isEmpty());
    }
}
