package org.example.deliveroo;

import org.example.deliveroo.model.CronExpression;
import org.example.deliveroo.parser.CronExpressionParser;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A command line application which parses a cron string and expands each field to show the times at which
 * it will run.
 * The cron string will be passed to your application as a single argument.
 */
public class CronExpressionParserMain {

    private static final String OUTPUT_FORMAT = "%-14s %s";

    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Invalid argument, Please provide a valid cron expression as a single argument");
        }

        String[] params = args[0].split(" ");

        if (params.length != 6) {
            throw new IllegalArgumentException("Invalid number of parameters in input cron expression - must be 6: minutes, hours, days of month, months, days of week and command");
        }
        CronExpression cronExpression = CronExpression.builder()
                .minutes(CronExpressionParser.parseCron(params[0], 0, 60))
                .hours(CronExpressionParser.parseCron(params[1], 0, 24))
                .daysOfMonth(CronExpressionParser.parseCron(params[2], 1, 32))
                .months(CronExpressionParser.parseCron(params[3], 1, 13))
                .daysOfWeek(CronExpressionParser.parseCron(params[4], 1, 8))
                .command(params[5])
                .build();
        print(cronExpression);
    }

    private static void print(CronExpression cronExpression) {
        System.out.println("*********************");
        println("minute", cronExpression.getMinutes());
        println("hour", cronExpression.getHours());
        println("day of month", cronExpression.getDaysOfMonth());
        println("month", cronExpression.getMonths());
        println("day of week", cronExpression.getDaysOfWeek());
        print("command", cronExpression.getCommand());
    }

    private static void println(String name, Set<String> set) {
        print(name, set.stream().map(Object::toString).collect(Collectors.joining(" ")));
        System.out.println();
    }

    private static void print(String name, String value) {
        System.out.format(OUTPUT_FORMAT, name, value);
    }
}
