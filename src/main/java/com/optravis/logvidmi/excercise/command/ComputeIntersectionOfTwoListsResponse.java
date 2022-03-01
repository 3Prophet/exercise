package com.optravis.logvidmi.excercise.command;

/**
 * Response that contains size of two list intersection.
 */
public class ComputeIntersectionOfTwoListsResponse implements Response {

    private final int sizeOfResultSet;

    public ComputeIntersectionOfTwoListsResponse(int sizeOfResultSet) {
        this.sizeOfResultSet = sizeOfResultSet;
    }

    public int getSizeOfResultSet() {
        return sizeOfResultSet;
    }
}
