import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar o tamanho do conjunto de dados
        System.out.println("Digite o tamanho do conjunto de dados: ");
        int dataSize = scanner.nextInt();

        // Gerar chaves aleatórias e medir o tempo de inserção na ABB e TH
        Random rand = new Random();
        BinarySearchTree bst = new BinarySearchTree();
        int hashTableSize = Math.min(dataSize, 1000000);
        HashTable ht = new HashTable(hashTableSize);

        long startTime, endTime;

        // Arrays para armazenar chaves inseridas
        int[] bstKeys = new int[dataSize];
        int[] htKeys = new int[dataSize];

        // Tempo de inserção na ABB
        startTime = System.nanoTime();
        for (int i = 0; i < dataSize; i++) {
            int key = rand.nextInt(Integer.MAX_VALUE);
            bst.insert(key);
            bstKeys[i] = key; // Armazenar chave inserida
        }
        endTime = System.nanoTime();
        long bstInsertTime = endTime - startTime;

        // Tempo de inserção na Tabela Hash
        startTime = System.nanoTime();
        for (int i = 0; i < dataSize; i++) {
            int key = rand.nextInt(Integer.MAX_VALUE);
            ht.insert(key);
            htKeys[i] = key; // Armazenar chave inserida
        }
        endTime = System.nanoTime();
        long htInsertTime = endTime - startTime;

        // Tempo de busca na ABB
        startTime = System.nanoTime();
        for (int key : bstKeys) {
            bst.search(key); // Usar chaves inseridas para busca
        }
        endTime = System.nanoTime();
        long bstSearchTime = endTime - startTime;

        // Tempo de busca na Tabela Hash
        startTime = System.nanoTime();
        for (int key : htKeys) {
            ht.search(key); // Usar chaves inseridas para busca
        }
        endTime = System.nanoTime();
        long htSearchTime = endTime - startTime;

        double bstInsertTimeInSeconds = bstInsertTime / 1_000_000_000.0;
        double htInsertTimeInSeconds = htInsertTime / 1_000_000_000.0;
        double bstSearchTimeInSeconds = bstSearchTime / 1_000_000_000.0;
        double htSearchTimeInSeconds = htSearchTime / 1_000_000_000.0;
        double bstTotalTimeInSeconds = (bstInsertTime + bstSearchTime) / 1_000_000_000.0;
        double htTotalTimeInSeconds = (htInsertTime + htSearchTime) / 1_000_000_000.0;

        System.out.println("Tempo de inserção:");
        System.out.println("ABB: " + bstInsertTimeInSeconds + " segundos");
        System.out.println("Tabela Hash: " + htInsertTimeInSeconds + " segundos");

        System.out.println("\nTempo de busca:");
        System.out.println("ABB: " + bstSearchTimeInSeconds + " segundos");
        System.out.println("Tabela Hash: " + htSearchTimeInSeconds + " segundos");

        System.out.println("\nTempo total:");
        System.out.println("ABB: " + bstTotalTimeInSeconds + " segundos");
        System.out.println("Tabela Hash: " + htTotalTimeInSeconds + " segundos");

        scanner.close();
    }
}