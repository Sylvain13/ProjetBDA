/**
 * Created by Sylvai on 31/03/2017.
 */
import java.io.*;

public class writeInData {

    public static void writeInfo(String date, String userName, String text) throws IOException {
        FileWriter fos = new FileWriter(new File("../../data.csv"), true);
        fos.write('\"'  + date + "\";\"" + userName + "\";\"" + text + "\";");
        fos.flush();
        fos.close();
    }
}
