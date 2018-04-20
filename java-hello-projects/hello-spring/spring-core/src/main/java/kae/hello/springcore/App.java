package kae.hello.springcore;

import java.util.Map;

public class App {

    private final Client client;

    private final Map<EventType, EventLogger> loggers;

    public App(Client client, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.loggers = loggers;

        System.out.println(client.getGreeting());
    }

    public void setDefaultLogger(EventLogger defaultLogger) {
        loggers.put(null, defaultLogger);
    }

    public void logEvent(EventType type, Event event) {
        event.setMessage(event.getMessage().replaceAll("\\{" + client.getId() + "\\}", client.getFullName()));
        loggers.get(type).logEvent(event);
    }

}
