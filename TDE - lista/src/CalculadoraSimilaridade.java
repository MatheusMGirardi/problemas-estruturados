public class CalculadoraSimilaridade {

    public static double similaridadeCosseno(lista_encadeada X, lista_encadeada Y) {
        if (X.getSize() != Y.getSize()) {
            throw new IllegalArgumentException("As listas devem ter o mesmo tamanho.");
        }

        Node atualX = X.head;
        Node atualY = Y.head;

        double dotProduct = 0;
        double magnitudeX = 0;
        double magnitudeY = 0;

        while (atualX != null && atualY != null) {
            dotProduct += atualX.data * atualY.data;
            magnitudeX += Math.pow(atualX.data, 2);
            magnitudeY += Math.pow(atualY.data, 2);

            atualX = atualX.next;
            atualY = atualY.next;
        }

        return dotProduct / (Math.sqrt(magnitudeX) * Math.sqrt(magnitudeY));
    }
}
