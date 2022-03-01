package com.optravis.logvidmi.excercise.handler;

import com.optravis.logvidmi.excercise.command.Command;
import com.optravis.logvidmi.excercise.command.Response;

/**
 * Interface for all the command handlers.
 */
public interface CommandHandler {

    Response handle(Command cmd);
}
