package kae.hello.springcore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private final int cacheSize;
    private final List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>(cacheSize);
    }

    @SuppressWarnings("unused")
    private void destroy() {
        if (!cache.isEmpty()) {
            logCachedEvents();
        }
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            logCachedEvents();
            cache.clear();
        }
    }

    private void logCachedEvents() {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for (Event event : cache) {
                fileWriter.write(event.toString());
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
