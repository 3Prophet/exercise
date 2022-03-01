package com.optravis.logvidmi.excercise.handler;

import com.optravis.logvidmi.excercise.command.ComputeIntersectionOfTwoListsCmd;
import com.optravis.logvidmi.excercise.command.ListName;
import com.optravis.logvidmi.excercise.command.TimeMonitoredResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class CommandHandlerTimeMonitorTest {

    @DisplayName("Hashing longer list results in higher elapse time for calculating the intersection.")
    @Test
    public void hashingLongerListResultsInHigherElapseTimeForCalculatingTheIntersection() {
        CommandHandlerTimeMonitor commandHandlerTimeMonitor = new CommandHandlerTimeMonitor(new ComputeIntersectionHandler());

        final Long sizeA = 10L;

        final Long sizeB = 1000L;

        TimeMonitoredResponse timeMonitoredResponse1 =
                (TimeMonitoredResponse) commandHandlerTimeMonitor.handle(new ComputeIntersectionOfTwoListsCmd(sizeA, sizeB, ListName.B));

        TimeMonitoredResponse timeMonitoredResponse2 =
                (TimeMonitoredResponse) commandHandlerTimeMonitor.handle(new ComputeIntersectionOfTwoListsCmd(sizeA, sizeB, ListName.A));

        assertThat(timeMonitoredResponse2.elapsedTime() < timeMonitoredResponse1.elapsedTime(), is(true));

    }
}
