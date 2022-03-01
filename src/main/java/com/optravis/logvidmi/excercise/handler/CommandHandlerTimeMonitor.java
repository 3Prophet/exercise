package com.optravis.logvidmi.excercise.handler;

import com.optravis.logvidmi.excercise.command.Command;
import com.optravis.logvidmi.excercise.command.Response;
import com.optravis.logvidmi.excercise.command.TimeMonitoredResponse;

/**
 * Decorator around command handler that measures time it took to run the
 * command handler at places this time into response.
 */
public class CommandHandlerTimeMonitor implements CommandHandler {

    private final CommandHandler commandHandler;

    public CommandHandlerTimeMonitor(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public Response handle(Command cmd) {

        long start = System.nanoTime();

        Response response = commandHandler.handle(cmd);

        long finish = System.nanoTime();

        long timeElapsed = finish - start;

        return new TimeMonitoredResponse(response, timeElapsed);
    }
}
