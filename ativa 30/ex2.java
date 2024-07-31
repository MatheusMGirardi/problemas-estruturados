import java.util.HashMap;
import java.util.Map;

public class ex2 {

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 1, 2, 1, 4, 5, 1, 2, 3, 2};

        calcularModa(numeros);
    }

    public static void calcularModa(int[] array){
        HashMap<Integer, Integer> dict = new HashMap<>();

        int elementoMaisFrequente = -1;
        int maxAparicoes = 0;
        
        for (int numero : array) {
            dict.put(numero, dict.getOrDefault(numero, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entrada : dict.entrySet()) {
            if (entrada.getValue() > maxAparicoes) {
                maxAparicoes = entrada.getValue();
                elementoMaisFrequente = entrada.getKey();
            }
        }
        for (Map.Entry<Integer, Integer> entrada : dict.entrySet()) {
            if (entrada.getValue() > maxAparicoes) {
                System.out.println("Não há moda.");
            } else {
                 System.out.println("Elemento com o maior número de aparições: " + elementoMaisFrequente + ", Contagem: " + maxAparicoes);
            }
        }
       
    
    }

}