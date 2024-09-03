public class Main {
    public static void main(String[] args) {
        lista_encadeada lista1 = new lista_encadeada();
        lista_encadeada lista2 = new lista_encadeada();

        lista1.insere_ultimo(1);
        lista1.insere_ultimo(2);
        lista1.insere_ultimo(3);

        lista2.insere_ultimo(2);
        lista2.insere_ultimo(3);
        lista2.insere_ultimo(4);

        // Similaridade do cosseno
        double similaridade = CalculadoraSimilaridade.similaridadeCosseno(lista1, lista2);
        System.out.println("Similaridade do Cosseno: " + similaridade);

        // Interseção
        lista_encadeada intersecao = CalculadoraIntersecao.intersecao(lista1, lista2);
        System.out.print("Interseção: ");
        intersecao.mostra_lista(intersecao);
    }
}
