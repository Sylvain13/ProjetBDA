import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by o15007109 on 03/04/17.
 */
public class Motif {
    private Collection<Integer> list = new HashSet<Integer>();
    private DictionnaireMotif dictionnaire = DictionnaireMotif.getInstance();
    private HashMap<Integer,String> map = dictionnaire.getMap();

    //    Pour chaque itemset (motif) fréquent Y, trouver tous les sous-ensembles X non vides de Y
//    Pour chacun de ces sous-ensemble X, produire la règle X → (Y − X) si Conf(X → (Y − X), D) ≥ MinConf

//    Écrire le programme prenant en entrée le fichier "out" (le résultat d'Apriori) et donnant en sortie un fichier contenant toutes les règles d'association
//    ayant une confiance supérieure au seuil donné par l'utilisateur (MinConf).

//    Sélectionner 10 règles d'association qui semblent pertinentes et essayer de les expliquer (2 phrases max)
//    par rapport au contexte dans lequel les données ont été récupérée.
}
