package com.optravis.logvidmi.excercise.command;

/**
 * Input for computing intersection of two lists.
 */
public class ComputeIntersectionOfTwoListsCmd implements Command {

    /**
     * Size of list A to be generated.
     */
    private final long sizeOfListA;

    /**
     * Size of list B to be generated.
     */
    private final long sizeOfListB;

    /**
     * Name of list to be hashed.
     */
    private final ListName listToHash;

    public ComputeIntersectionOfTwoListsCmd(long sizeOfListA, long sizeOfListB, ListName listToHash) {
        this.sizeOfListA = sizeOfListA;
        this.sizeOfListB = sizeOfListB;
        this.listToHash = listToHash;
    }

    public long getSizeOfListA() {
        return sizeOfListA;
    }

    public long getSizeOfListB() {
        return sizeOfListB;
    }

    public ListName getListToHash() {
        return listToHash;
    }
}
