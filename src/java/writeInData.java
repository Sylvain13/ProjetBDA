/**
 * Created by Sylvai on 31/03/2017.
 */
import java.io.*;
import java.io.IOException;

public class writeInData {
    private static writeInData instance;

    private writeInData() {
    }

    public static writeInData getInstance() {
        return instance;
    }

    //PHASE 1
    public void convertCSVToTrans(String pathCSV, String pathTrans) {
    }

    public void convertTransToCSV(String pathCSV, String pathTrans) {

    }

    //PHASE 0
    public void writeInfo (String date, String name, String text) throws IOException {
        FileWriter fos = new FileWriter(new File("../../data.csv"), true);
        fos.write('\"' + date + "\";\"" + name + "\";\"" + text + "\";");
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
