class ArvoreAVLPalavras {
    NoAVLPalavra raiz;

    // inserir ou atualizar uma palavra
    NoAVLPalavra insereElemento(NoAVLPalavra no, String palavra) {
        if (no == null) {
            return new NoAVLPalavra(new PalavraFrequencia(palavra));
        }

        if (palavra.compareTo(no.dado.getPalavra()) < 0) {
            no.esquerdo = insereElemento(no.esquerdo, palavra);
        } else if (palavra.compareTo(no.dado.getPalavra()) > 0) {
            no.direito = insereElemento(no.direito, palavra);
        } else {
            // A palavra já existe
            no.dado.incrementarFrequencia();
            return no;
        }

        // Atualiza altura do nó atual
        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));

        // Balanceia a árvore
        return balancear(no, palavra);
    }


    NoAVLPalavra balancear(NoAVLPalavra no, String palavra) {
        int balanceamento = fatorBalanceamento(no);

        // Caso de rotação simples à direita
        if (balanceamento > 1 && palavra.compareTo(no.esquerdo.dado.getPalavra()) < 0) {
            return rotacaoDireita(no);
        }

        // Caso de rotação simples à esquerda
        if (balanceamento < -1 && palavra.compareTo(no.direito.dado.getPalavra()) > 0) {
            return rotacaoEsquerda(no);
        }

        // Rotação dupla esquerda-direita
        if (balanceamento > 1 && palavra.compareTo(no.esquerdo.dado.getPalavra()) > 0) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }

        // Rotação dupla direita-esquerda
        if (balanceamento < -1 && palavra.compareTo(no.direito.dado.getPalavra()) < 0) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no; // Nó já balanceado
    }


    int altura(NoAVLPalavra no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    // Fator de balanceamento do nó
    int fatorBalanceamento(NoAVLPalavra no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerdo) - altura(no.direito);
    }

    // Funções de rotação (igual da parte I)
    NoAVLPalavra rotacaoDireita(NoAVLPalavra y) {
        NoAVLPalavra x = y.esquerdo;
        NoAVLPalavra T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

        return x;
    }

    NoAVLPalavra rotacaoEsquerda(NoAVLPalavra x) {
        NoAVLPalavra y = x.direito;
        NoAVLPalavra T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;

        return y;
    }

    // Método para buscar a palavra na árvore
    PalavraFrequencia buscaPalavra(NoAVLPalavra no, String palavra) {
        if (no == null) {
            return null;
        }

        if (palavra.equals(no.dado.getPalavra())) {
            return no.dado;
        }

        if (palavra.compareTo(no.dado.getPalavra()) < 0) {
            return buscaPalavra(no.esquerdo, palavra);
        }

        return buscaPalavra(no.direito, palavra);
    }
}
