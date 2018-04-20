package kae.hello.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("hello-world")
public class HelloAnnotationBasedBean {

    private final long time = System.currentTimeMillis();

    private final ApplicationContext ctx;

    private final String clientName;

    private final EventLogger eventLogger;

    @Autowired
    public HelloAnnotationBasedBean(
            ApplicationContext ctx,
            @Value("${name}") String clientName,
            @Qualifier("combinedEventLogger") EventLogger eventLogger) {
        this.ctx = ctx;
        this.clientName = clientName;
        this.eventLogger = eventLogger;
    }

    public void sayIt() {
        final Event event = ctx.getBean(Event.class);
        event.setMessage("Hello, " + clientName + "! (" + time + ")");
        eventLogger.logEvent(event);
    }

}
