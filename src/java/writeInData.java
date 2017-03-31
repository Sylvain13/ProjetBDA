/**
 * Created by Sylvai on 31/03/2017.
 */
import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class writeInData {

    public static void writeInfo(Date dateT, String userName, String text) throws IOException {


        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(dateT);

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
