import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static Map<String,Integer> contaParole = new HashMap<>();

    public static void main(String[] args){
        String input = JOptionPane.showInputDialog(null, "Inserisci la frase");
        if(input == null) return;
        String[] fraseInIngresso = splitFraseInParole(input);
        for (int i=0; i<fraseInIngresso.length; i++){
            add(contaParole,fraseInIngresso[i]);
        }
        stampaMappa();
    }

    public static String[] splitFraseInParole(String input) {
        String[] arrayParole = input.split(" ");
        return arrayParole;
    }

    //conta degli elementi
    public static void add(Map<String,Integer> mappa, String parola){
        Integer nParole = mappa.get(parola);
        if(nParole==null){
            mappa.put(parola,1);
        } else{
            mappa.put(parola,nParole+1);
        }
    }

    //stampa risultati
    public static void stampaMappa(){
        for (String parola : contaParole.keySet()) {
            System.out.println(" - <" + parola + "> ======> e' presente: " + contaParole.get(parola) + " volte.");
        }
    }

}
