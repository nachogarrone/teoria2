package examples.while_ut1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nachogarrone on 7/9/16.
 */
public class Logger {

    public static void log(String key, String message) {
        Writer writer = null;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:MM:ss");

        System.out.println(simpleDateFormat.format(date) + ": " + key + " : " + message);

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("log.txt"), "utf-8"));
            writer.write(simpleDateFormat.format(date) + ": " + key + " : " + message);
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }
}
