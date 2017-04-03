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

    private static DictionnaireMotif instance = new DictionnaireMotif();

    private DictionnaireMotif(){}

    public static DictionnaireMotif getInstance(){
        return instance;
    }

    public void updateDico(String words){
        if (! dico.containsKey(words))
               dico.put(intDico++,words);
    }

    public String returnValue(String word){
       return dico.get(word);
    }

    public void chargeFic(){
        for(Map.Entry<Integer, String> entry : dico.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            System.out.println("key : " + key + " value : " + value);
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


