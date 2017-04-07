/**
 * Created by Sylvai on 31/03/2017.
 */
import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class writeInData {
    private static writeInData instance = new writeInData();

    private writeInData() {
    }

    public static writeInData getInstance() {
        return instance;
    }
    static int intDico =0;

    //PHASE 1
    public void convertCSVToTrans(String fileIn, String fileOut) {
        //String fileDico = "data.csv";
        try {
            DictionnaireMotif dicoDirect = DictionnaireMotif.getInstance();

            BufferedReader brIn = new BufferedReader( new FileReader(fileIn));
            PrintWriter writer = new PrintWriter(new FileWriter(fileOut));

            int lineNumber = 0;

            while((fileIn = brIn.readLine()) != null) {
                lineNumber++;
                String[] result = fileIn.split(";");
                for (int i = 0; result.length > i; i++) {
                    dicoDirect.updateDico(result[i]);
                    writer.print(dicoDirect.returnValue(result[i])); //renvoie null
                    writer.print(" ");
                }
                writer.println();
            }

            //FileOutputStream fos = new FileOutputStream(fileDico);
            //ObjectOutputStream writerDico = new ObjectOutputStream(fos);

            dicoDirect.chargeFic();

            //writerDico.close();
            brIn.close();
            writer.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertTransToCSV(String fileIn, String fileOut) {
        String fileDico = "dico.txt";
        try {
            Map<String, Integer> dico;

            FileInputStream fis = new FileInputStream(fileDico);
            ObjectInputStream writerDico = new ObjectInputStream(fis);

            dico = (Map<String, Integer>) writerDico.readObject();

            writerDico.close();

            BufferedReader brIn = new BufferedReader( new FileReader(fileIn));
            PrintWriter writer = new PrintWriter(new FileWriter(fileOut));

            int lineNumber = 0;

            while((fileIn = brIn.readLine()) != null) {
                lineNumber++;
                final String[] result = fileIn.split(" ");
                for (String res : result) {
                    Integer value = Integer.valueOf(res);
                    dico.entrySet()
                            .stream()
                            .filter(e -> e.getValue().equals(value))
                            .map(e -> e.getKey())
                            .forEach(writer::print);
                    writer.print(";");
                }
                writer.println();
            }

            brIn.close();
            writer.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void outToCsv(String fileIn, String fileOut) {
        String fileDico = "dico.txt";
        try {
            Map<String, Integer> dico;

            FileInputStream fis = new FileInputStream(fileDico);
            ObjectInputStream writerDico = new ObjectInputStream(fis);

            dico = (Map<String, Integer>) writerDico.readObject();

            writerDico.close();

            BufferedReader brIn = new BufferedReader( new FileReader(fileIn));
            PrintWriter writer = new PrintWriter(new FileWriter(fileOut));

            int lineNumber = 0;

            while((fileIn = brIn.readLine()) != null) {
                lineNumber++;
                String[] result = fileIn.split(" ");
                for (String res : result) {
                    Integer value = Integer.valueOf(res);
                    dico.entrySet()
                            .stream()
                            .filter(e -> e.getValue().equals(value))
                            .map(Map.Entry::getKey)
                            .forEach(writer::print);
                    writer.print(";");
                }
                writer.print(dico.get(result[result.length - 1]));
                writer.print(";");

                writer.println();
            }

            brIn.close();
            writer.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    //PHASE 0
    public void writeInfo(Date dateT, String userName, String[] text) throws IOException {


        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(dateT);

        FileWriter fos = new FileWriter(new File("data.csv"), true);
        fos.write('\"'  + date + "\";\"" + userName + "\";\"" );
        for (int i = 0; i < text.length; i++) {
            fos.write("\"" + text[i] + "\";");
        }
        fos.write("\n");
        fos.flush();
        fos.close();
    }

    public void readInfo() throws IOException {
        String line = null;
        FileReader fileReader = new FileReader("data.csv");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public void outToReglesAssoc() {
        //for chaque itemset Y trouver les X non vide de Y tq confiance >= MinConf
        //for all X, faire X -> (Y-X) si Conf(X->(Y-X),D) >= MinConf
        //Confiance = freq / freq
    }
}
