/**
 * Created by Sylvai on 31/03/2017.
 */
import java.io.File;
import java.io.FileOutputStream;

public class writeInData {
    public static void writeInfo(String date,String userName, String title, String link){
        fos = new FileOutputStream(new File("../../data.csv"));
    }
}
