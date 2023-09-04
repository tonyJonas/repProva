public class ArvBinBusca {

    private class NoArv {
        private int chave;
        private NoArv esq;
        private NoArv dir;

        public NoArv(int chave) {
            this.chave = chave;
            esq = null;
            dir = null;
        }
    }

    private NoArv raiz;

    public ArvBinBusca() {
        raiz = null;
    }

    public void inserir(int novaChave) {
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

    public void remover(int chave) {
        raiz = remover(raiz, chave);
    }

    private NoArv min(NoArv raizSubArv) {
        if (raizSubArv.esq == null)
            return raizSubArv;
        else
            return min(raizSubArv.esq);
    }

    private NoArv removerMin(NoArv raizSubArv) {
        if (raizSubArv.esq == null)
            return raizSubArv.dir;
        raizSubArv.esq = removerMin(raizSubArv.esq);
        return raizSubArv;
    }


    private NoArv remover(NoArv raizSubArv, int chave) {
        if (raizSubArv == null)
            return null;
        if (chave < raiz.chave)
            raizSubArv.esq = remover(raizSubArv.esq, chave);
        else if (chave > raiz.chave)
            raizSubArv.dir = remover(raizSubArv.dir, chave);
        else {
            if (raizSubArv.dir == null)
                return raizSubArv.esq;
            if (raizSubArv.esq == null)
                return raizSubArv.dir;
            NoArv t = raizSubArv;
            raizSubArv = min(raizSubArv.dir);
            raizSubArv.dir = removerMin(t.dir);
            raizSubArv.esq = t.esq;
        }
        return raizSubArv;
    }

    public static void main(String[] args) {
        ArvBinBusca arv = new ArvBinBusca();
        arv.inserir(100);
        arv.inserir(75);
        arv.inserir(125);
        arv.inserir(65);
        arv.inserir(85);
        arv.inserir(115);
        arv.inserir(150);
        arv.remover(100);
    }

}

