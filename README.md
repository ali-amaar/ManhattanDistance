# ManhattanDistance

## Compile
  open the command line in the directory containing the java file
  javac ClosestEvent.java

## Execute
  open the command line in the directory containing the class file
  java ClosestEvent

## Functionality
   Seed data of 10 events is created. These events are scattered across a Map
   where -11 < x < 11 and -11 < y < 11.
   Each event contains one or more prices.
   The closest 5 events are found.
   Multiple events in one location is supported.
   
## Assumptions
  Input is in form int,int (errors are dealt with)
  Program will only be executed once.

## Larger scale
  This method would not be ideal for a real life application. A better approach
  would be using a multimap where each key (location) may be associated with
  multiple values.
