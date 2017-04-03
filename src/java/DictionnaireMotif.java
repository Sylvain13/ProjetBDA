import java.util.HashMap;

/**
 * Created by o15007109 on 31/03/17.
 */
import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;
import java.util.Map;

public class DictionnaireMotif {
    //associer chaque motif frequent à un int en fonction de sa frequence
    private HashMap<Integer,String> dico = new HashMap<Integer,String>();
    private static int intDico =0;
    //boucle jusque eof

    public HashMap<Integer,String> getMap() {
        return dico;
    }

    private static DictionnaireMotif instance = new DictionnaireMotif();

    private DictionnaireMotif(){}

    public static DictionnaireMotif getInstance(){
        return instance;
    }

    public void updateDico(String value){
        if (!dico.containsValue(value)) {
            dico.put(intDico++, value);
        }
    }

    public Integer returnValue(String word){
        for(Map.Entry<Integer, String> entry : dico.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            if (value.equals(word)) {
                return key;
            }
        }
       return null;
    }

    public void chargeFic()throws IOException{
        FileWriter fos = new FileWriter(new File("dico.txt"), true);
        for(Map.Entry<Integer, String> entry : dico.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            fos.write("key : "+ key + "; value : " + value + "\n");
        }
    }
}


//
//    static int intDico = 0;
//
//    public static void main(String[] args) {
//        //csvToTrans("test.csv", "test.trans");
//        //transToCsv("test.trans", "testRetourTrans.csv");
//        //outToCsv("test.out", "testRetourOut.csv");
//    }


