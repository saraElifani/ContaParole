import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Map<String,Integer> contaParole = new HashMap<>();

    public static void main(String[] args){
        String input = JOptionPane.showInputDialog(null, "Inserisci la frase");
        if(input == null) return;
        String[] fraseInIngresso = splitFraseInParole(input);
        for (int i=0; i<fraseInIngresso.length; i++){
            add(contaParole,fraseInIngresso[i]);
        }
        System.out.println("\n____________STAMPA MAPPA ORDINATA PER CHIAVE_________________________\n");
        stampaMappa();
        System.out.println("\n____________STAMPA MAPPA ORDINATA PER VALORE_________________________\n");
        stampaRisultatiOrdinatiPerValore();
    }

    public static String[] splitFraseInParole(String input) {
        //per eliminare punteggiatura
        String eliminaPunteggiatura = input.replaceAll("\\W", " ");
        String[] arrayParole = eliminaPunteggiatura.split(" ");
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
        //ordinamento mappa per chiave in ordine alfabetico
        contaParole.keySet().stream().sorted().forEach(key -> {
                    Integer value = contaParole.get(key);
                    System.out.println(" - <" + key + "> ======> e' presente: " + value);
                }
        );
    }

    //stampa risultati per valore decrescente
    public static void stampaRisultatiOrdinatiPerValore(){
        List<Map.Entry<String, Integer>> list = new ArrayList<>(contaParole.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        list.forEach(parola -> System.out.println(parola));
    }
}
