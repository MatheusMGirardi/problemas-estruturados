class NoAVLPalavra {
    PalavraFrequencia dado;
    int altura;
    NoAVLPalavra esquerdo, direito;

    public NoAVLPalavra(PalavraFrequencia dado) {
        this.dado = dado;
        this.altura = 1;
    }
}