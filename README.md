## Overview
A command line application which parses a cron string and expands each field
to show the times at which it will run.

The output should be formatted as a table with the field name taking the first 14 columns and
the times as a space-separated list following it.
For example, the following input argument:

`*/15 0 1,15 * 1-5 /usr/bin/find`

yields the below result:

```
minute 0 15 30 45
hour 0
day of month 1 15
month 1 2 3 4 5 6 7 8 9 10 11 12
day of week 1 2 3 4 5
command /usr/bin/find
```

## Pre-requisites
This application is written using Java 11.
Maven version (3.9.x) should be installed.

## Build and launch.
1) Clone the project from the repository.
2) Open the command prompt/terminal and navigate to the project folder.
3) Execute the below command to build the project.

   `mvn clean install`

4) After the project is successfully build, the target folder is created inside the project folder. Navigate to the target folder.
5) Execute the below command to launch the project

   `java -jar cron-parser.jar "*/15 0 1,15 * 1-5 /usr/bin/find"`


## Limitations and Improvements
1) The application is a basic demonstration of cron expression parsing. It only supports '*,-*/' special characters for now. 

2) Currently, this exercise considers days in a month to be 31. This could be further improved. 

3) Currently, this application does not consider month's names and day's names. It only considers numeric values for month and day number. This also can be further improved.
