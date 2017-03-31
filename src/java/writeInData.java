/**
 * Created by Sylvai on 31/03/2017.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class writeInData {

    public static void writeInfo(String date, String userName, String text) throws FileNotFoundException {
       FileOutputStream fos = new FileOutputStream(new File("../../data.csv"));
        final PrintStream printStream = new PrintStream(fos);
        printStream.print('\"'  + date + "\";\"" + userName + "\";\"" + text + "\";");
        printStream.close();
    }
}
