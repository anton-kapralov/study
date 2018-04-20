package kae.hello.springcore;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    protected final File file;

    public FileEventLogger(String filename) {
        this.file = new File(filename);
    }

    @SuppressWarnings("unused")
    private void init() throws IOException {
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("It's not possible to create " + file.getAbsolutePath());
            }
        }

        if (!file.canWrite()) {
            throw new IOException("It's not possible to write to " + file.getAbsolutePath());
        }
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + System.lineSeparator(), "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
