package kae.hello.springcore;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Event {

    private final String uuid;

    private String message;

    private final Date date;

    private final DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        uuid = UUID.randomUUID().toString();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uuid=" + uuid +
                ", message='" + message + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }

    public static boolean isDay() {
        final Calendar calendar = Calendar.getInstance();
        final int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        return hourOfDay >= 8 && hourOfDay <= 17;
    }

}
