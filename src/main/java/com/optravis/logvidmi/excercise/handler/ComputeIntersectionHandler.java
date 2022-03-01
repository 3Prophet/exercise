package com.optravis.logvidmi.excercise.handler;

import com.optravis.logvidmi.excercise.command.Command;
import com.optravis.logvidmi.excercise.command.ComputeIntersectionOfTwoListsCmd;
import com.optravis.logvidmi.excercise.command.ComputeIntersectionOfTwoListsResponse;
import com.optravis.logvidmi.excercise.command.Response;
import com.optravis.logvidmi.excercise.dom.service.IntersectionCalculator;
import com.optravis.logvidmi.excercise.dom.service.ListGenerator;

import java.util.Set;

/**
 * Command handler to compute intersection of two lists.
 */
public class ComputeIntersectionHandler implements CommandHandler {

    @Override
    public Response handle(Command cmd) {

        ComputeIntersectionOfTwoListsCmd command = (ComputeIntersectionOfTwoListsCmd) cmd;

        IntersectionCalculator intersectionCalculator = new IntersectionCalculator(new ListGenerator());

        Set<Integer> intersection = intersectionCalculator.calculateIntersection(command);

        return new ComputeIntersectionOfTwoListsResponse(intersection.size());
    }
}
