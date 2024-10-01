public class ArvoreAVL {
    public int altura(NoAVL N) { //obter altura de um no
        if (N == null)
            return 0;
        return N.altura;
    }

    // Rotação à direita
    NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerdo;
        NoAVL T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

        return x;
    }

    // Rotação à esquerda
    NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direito;
        NoAVL T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;

        return y;
    }

    int getFatorBalanceamento(NoAVL N) {
        if (N == null)
            return 0;
        return altura(N.esquerdo) - altura(N.direito);
    }

    NoAVL insereElemento(NoAVL no, int valor) {
        if (no == null)
            return (new NoAVL(valor));

        if (valor < no.valor)
            no.esquerdo = insereElemento(no.esquerdo, valor);
        else if (valor > no.valor)
            no.direito = insereElemento(no.direito, valor);
        else
            return no;  // Valores duplicados não são permitidos

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));

        int balanceamento = getFatorBalanceamento(no);

        // Caso de Rotação Simples à Direita
        if (balanceamento > 1 && valor < no.esquerdo.valor)
            return rotacaoDireita(no);

        // Caso de Rotação Simples à Esquerda
        if (balanceamento < -1 && valor > no.direito.valor)
            return rotacaoEsquerda(no);

        // Rotação Dupla Esquerda-Direita
        if (balanceamento > 1 && valor > no.esquerdo.valor) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }

        // Rotação Dupla Direita-Esquerda
        if (balanceamento < -1 && valor < no.direito.valor) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // Função para remover um nó
    NoAVL removeElemento(NoAVL raiz, int valor) {
        if (raiz == null)
            return raiz;

        if (valor < raiz.valor)
            raiz.esquerdo = removeElemento(raiz.esquerdo, valor);
        else if (valor > raiz.valor)
            raiz.direito = removeElemento(raiz.direito, valor);
        else {
            if ((raiz.esquerdo == null) || (raiz.direito == null)) {
                NoAVL temp = null;
                if (temp == raiz.esquerdo)
                    temp = raiz.direito;
                else
                    temp = raiz.esquerdo;

                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else
                    raiz = temp;
            } else {
                NoAVL temp = getMinValorNo(raiz.direito);
                raiz.valor = temp.valor;
                raiz.direito = removeElemento(raiz.direito, temp.valor);
            }
        }

        if (raiz == null)
            return raiz;

        raiz.altura = Math.max(altura(raiz.esquerdo), altura(raiz.direito)) + 1;

        int balanceamento = getFatorBalanceamento(raiz);

        // Rotação à Direita
        if (balanceamento > 1 && getFatorBalanceamento(raiz.esquerdo) >= 0)
            return rotacaoDireita(raiz);

        // Rotação à Esquerda
        if (balanceamento < -1 && getFatorBalanceamento(raiz.direito) <= 0)
            return rotacaoEsquerda(raiz);

        // Rotação Esquerda-Direita
        if (balanceamento > 1 && getFatorBalanceamento(raiz.esquerdo) < 0) {
            raiz.esquerdo = rotacaoEsquerda(raiz.esquerdo);
            return rotacaoDireita(raiz);
        }

        // Rotação Direita-Esquerda
        if (balanceamento < -1 && getFatorBalanceamento(raiz.direito) > 0) {
            raiz.direito = rotacaoDireita(raiz.direito);
            return rotacaoEsquerda(raiz);
        }

        return raiz;
    }

    // Função auxiliar para encontrar o nó de menor valor
    public NoAVL getMinValorNo(NoAVL no) {
        NoAVL atual = no;
        while (atual.esquerdo != null)
            atual = atual.esquerdo;
        return atual;
    }

    // Verifica se um elemento existe na árvore
    public boolean existeElemento(NoAVL no, int valor) {
        if (no == null)
            return false;
        if (valor < no.valor)
            return existeElemento(no.esquerdo, valor);
        else if (valor > no.valor)
            return existeElemento(no.direito, valor);
        else
            return true;
    }

    // Impressão em preordem
    public void imprimePreOrdem(NoAVL no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            imprimePreOrdem(no.esquerdo);
            imprimePreOrdem(no.direito);
        }
    }

    // Impressão em ordem
    public void imprimeInOrdem(NoAVL no) {
        if (no != null) {
            imprimeInOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            imprimeInOrdem(no.direito);
        }
    }

    // Impressão em posordem
    public void imprimePosOrdem(NoAVL no) {
        if (no != null) {
            imprimePosOrdem(no.esquerdo);
            imprimePosOrdem(no.direito);
            System.out.print(no.valor + " ");
        }
    }
}
