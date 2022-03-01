package com.optravis.logvidmi.excercise.command;

/**
 * Decorator around response that stores time it took to process the command.
 */
public class TimeMonitoredResponse implements Response {

    /**
     * Command response.
     */
    private final Response response;

    /**
     * Time it took to process the command.
     */
    private final long elapsedTime;

    public TimeMonitoredResponse(Response response, long elapsedTime) {
        this.response = response;
        this.elapsedTime = elapsedTime;
    }

    public long elapsedTime() {
       return elapsedTime;
    }

    public Response response() {
        return response;
    }
}
