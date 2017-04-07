import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by o15007109 on 03/04/17.
 */
public class Motif {
    private DictionnaireMotif dictionnaire = DictionnaireMotif.getInstance();
    private HashMap<Integer,String> map = dictionnaire.getMap();
    private ArrayList<Integer> collection = new ArrayList<Integer>();
    private HashMap<String, Integer> list = new HashMap<String, Integer>();
    private String motif;
    private String frequence;


    public Motif(String motif, String freq) {
        this.motif = motif;
        this.frequence = freq;
    }

    public void saveInfoOUT() throws IOException {
        String line = null;
        String[] text;
        FileReader fileReader = new FileReader("data.out");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        while((line = bufferedReader.readLine()) != null) {
            text = line.split(" ");
            for(int i =0 ; i < text.length-1 ; i++)
                collection.add(parseInt(text[i]));
        }
        bufferedReader.close();
        readCollection();
    }

    public void readCollection() {
        for(Integer s : collection){
            System.out.println(s);
        }
    }

    public void isEnsembleDe(Motif m2) {
        if (this.collection.containsAll(m2.collection))
            readCollection();
    }

    public void soustraireMotif(Motif m1, Motif m2) {
        //removeAll();
    }

    public String getMotif() {
        return this.motif;
    }

    public String getFreq() {
        return this.frequence;
    }



    //    Pour chaque itemset (motif) fréquent Y, trouver tous les sous-ensembles X non vides de Y
//    Pour chacun de ces sous-ensemble X, produire la règle X → (Y − X) si Conf(X → (Y − X), D) ≥ MinConf

//    Écrire le programme prenant en entrée le fichier "out" (le résultat d'Apriori) et donnant en sortie un fichier contenant toutes les règles d'association
//    ayant une confiance supérieure au seuil donné par l'utilisateur (MinConf).

//    Sélectionner 10 règles d'association qui semblent pertinentes et essayer de les expliquer (2 phrases max)
//    par rapport au contexte dans lequel les données ont été récupérée.
}
