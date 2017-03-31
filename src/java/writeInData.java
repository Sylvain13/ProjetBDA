/**
 * Created by Sylvai on 31/03/2017.
 */
import java.io.*;

public class writeInData {

    public static void writeInfo(String date, String userName, String text) throws IOException {
        FileWriter fos = new FileWriter(new File("data.csv"), true);
        fos.write('\"'  + date + "\";\"" + userName + "\";\"" + text + "\";");
        fos.flush();
        fos.close();

        FileReader fr = new FileReader(new File("data.csv"));
        char [] a = new char[50];
        fr.read(a);   // reads the content to the array

        for(char c : a)
            System.out.print(c);   // prints the characters one by one
        fr.close();
    }
}
