package com.optravis.logvidmi.excercise.ui.controller;

import com.optravis.logvidmi.excercise.command.ComputeIntersectionOfTwoListsCmd;
import com.optravis.logvidmi.excercise.command.ComputeIntersectionOfTwoListsResponse;
import com.optravis.logvidmi.excercise.command.ListName;
import com.optravis.logvidmi.excercise.command.TimeMonitoredResponse;
import com.optravis.logvidmi.excercise.handler.CommandHandlerTimeMonitor;
import com.optravis.logvidmi.excercise.handler.ComputeIntersectionHandler;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

/**
 * Controller that processes user request to find intersection
 * of two lists and prints the result.
 */
@Component
@CommandLine.Command(name = "java -jar exercise-0.0.1-SNAPSHOT.jar",
        description = {"Computes intersection of two lists A and B."})
public class ComputeIntersectionController implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Size of list A")
    private long sizeOfListA;

    @CommandLine.Parameters(index = "1", description = "Size of list B")
    private long sizeOfListB;

    @CommandLine.Parameters(index = "2", description = "Name of list to be hashed. Possible values: A,B")
    private ListName nameOfListToHash;

    @Override
    public void run() {

        String illegalSize = "\n\nIllegal size for list %s. List size can not be negative.\n\n";

        if (sizeOfListA < 0) {
            System.out.println(String.format(illegalSize, "A"));
            return;
        }

        if (sizeOfListB < 0) {
            System.out.println(String.format(illegalSize, "B"));
            return;
        }

        CommandHandlerTimeMonitor commandHandlerTimeMonitor = new CommandHandlerTimeMonitor(new ComputeIntersectionHandler());

        TimeMonitoredResponse timeMonitoredResponse = (TimeMonitoredResponse) commandHandlerTimeMonitor
                .handle(new ComputeIntersectionOfTwoListsCmd(sizeOfListA, sizeOfListB, nameOfListToHash));

        ComputeIntersectionOfTwoListsResponse response = (ComputeIntersectionOfTwoListsResponse) timeMonitoredResponse.response();

        System.out.println(String.format("\n\nIntersection size: %s", response.getSizeOfResultSet()));

        System.out.println(String.format("Calculation time(ns): %s\n\n", timeMonitoredResponse.elapsedTime()));
    }
}
