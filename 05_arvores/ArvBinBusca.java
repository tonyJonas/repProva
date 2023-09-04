public class ArvBinBusca {

    // Início da classe que representa um nó da árvore
    private class NoArv {
        private int chave;
        private NoArv esq;
        private NoArv dir;

        public NoArv(int chave) {
            this.chave = chave;
            esq = null;
            dir = null;
        }
    } // Fim da classe que representa um nó da árvore

    private NoArv raiz;

    public ArvBinBusca() {
        raiz = null;
    }

    public void inserir_iter(int novaChave) {
        NoArv no = new NoArv(novaChave);
        if (raiz == null)
            raiz = no;
        else {
            boolean inseriu = false;
            NoArv temp = raiz; // ponteiro temporário
            while (!inseriu) {
                if (novaChave < temp.chave) {
                    if (temp.esq == null) {
                        temp.esq = no;
                        inseriu = true;
                    } else
                        temp = temp.esq;
                } else if (novaChave > temp.chave) {
                    if (temp.dir == null) {
                        temp.dir = no;
                        inseriu = true;
                    } else
                        temp = temp.dir;
                }
            }
        }
    }

    public void inserir_rec(int novaChave) {
        raiz = inserir_rec(raiz, novaChave);
    }

    private NoArv inserir_rec(NoArv raizSubArv, int novaChave) {
        if (raizSubArv == null)
            return new NoArv(novaChave);
        else if (novaChave < raizSubArv.chave)
            raizSubArv.esq = inserir_rec(raizSubArv.esq, novaChave);
        else if (novaChave > raizSubArv.chave)
            raizSubArv.dir = inserir_rec(raizSubArv.dir, novaChave);
        return raizSubArv;
    }

    public boolean busca_iter(int alvo) {
        NoArv raizSubArv = raiz;
        while (raizSubArv != null) {
            if (alvo == raizSubArv.chave)
                return true;
            else if (alvo < raizSubArv.chave)
                raizSubArv = raizSubArv.esq;
            else
                raizSubArv = raizSubArv.dir;
        }
        return false;
    }

    public boolean busca_rec(int alvo) {
        return busca_rec(raiz, alvo);
    }

    private boolean busca_rec(NoArv raizSubArv, int alvo) {
        if (raizSubArv == null)
            return false;
        else if (alvo == raizSubArv.chave)
            return true;
        else if (alvo < raizSubArv.chave)
            return busca_rec(raizSubArv.esq, alvo);
        else
            return busca_rec(raizSubArv.dir, alvo);
    }

    public static void main(String[] args) {
        ArvBinBusca arv = new ArvBinBusca();
        arv.inserir_rec(5);
        arv.inserir_rec(8);
        arv.inserir_rec(2);
        arv.inserir_rec(1);
        arv.inserir_rec(6);
        System.out.println(arv.busca_rec(5));
        System.out.println(arv.busca_rec(1));
        System.out.println(arv.busca_rec(8));
        System.out.println(arv.busca_rec(3));
        System.out.println(arv.busca_rec(9));
    }

}
