package org.example.deliveroo.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class CronExpression {
    private final Set<String> minutes;
    private final Set<String> hours;
    private final Set<String> daysOfMonth;
    private final Set<String> months;
    private final Set<String> daysOfWeek;
    private final String command;
}
