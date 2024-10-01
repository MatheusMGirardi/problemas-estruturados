public class CalculadoraIntersecao {

    public static lista_encadeada intersecao(lista_encadeada X, lista_encadeada Y) {
        lista_encadeada resultado = new lista_encadeada();

        Node atualX = X.head;
        while (atualX != null) {
            Node atualY = Y.head;
            while (atualY != null) {
                if (atualX.data == atualY.data) {
                    resultado.insere_ordenado(atualX.data);
                    break; // Já encontramos o elemento, não precisamos continuar procurando
                }
                atualY = atualY.next;
            }
            atualX = atualX.next;
        }

        return resultado;
    }
}
