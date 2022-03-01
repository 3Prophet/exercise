## Summary

Program with CLI to compute intersection of two lists A and B.

## Description

Command computes intersection between two lists A and B populated with random numbers. 
It prints size of this intersection and time (ns) it took to compute the intersection.
To compute the intersection of two lists A and B, the elements of one list are put into 
a HashSet while the other list is iterated over to test for each element whether it’s contained in the HashSet.

As an input it accepts the following parameters:
- size of list A
- size of list B
- parameter designating which of the two above lists has to be hashed (possible values: A, B).

## Test

`mvn clean test`

## Build

`mvn clean package`

## Run
If you are in the project root run the following command to see help:

`java -jar ./target/exercise-0.0.1-SNAPSHOT.jar`

## Answer to the question

Iteration over list has complexity O(n), search in HashSet O(1), 
placement of elements from list into HashSet - O(n). Hence,
theoretically the entire algo has complexity O(n) independent of what 
is to be hashed first. But technically hashing smaller set is faster.
Hence when smaller list is to be hashed the algo will run faster.