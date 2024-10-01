class PalavraFrequencia {
    String palavra;
    int frequencia;

    public PalavraFrequencia(String palavra) {
        this.palavra = palavra;
        this.frequencia = 1;
    }

    public void incrementarFrequencia() {
        this.frequencia++;
    }

    public String getPalavra() {
        return palavra;
    }

    public int getFrequencia() {
        return frequencia;
    }
}
