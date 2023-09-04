import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void emOrdem() {
        emOrdem(raiz);
        System.out.println("");
    }

    private void emOrdem(NoArv raizSubArv) {
        if (raizSubArv != null) {
            emOrdem(raizSubArv.esq);
            System.out.print(raizSubArv.chave + " ");
            emOrdem(raizSubArv.dir);
        }
    }

    public void emOrdem_iter() {
        Stack<NoArv> pilha = new Stack<>();
        NoArv temp = raiz;
        while (temp != null || !pilha.isEmpty()) {
            // percorre o nó mais a esquerda primeiro
            while (temp != null) {
                pilha.push(temp); // empilha
                temp = temp.esq;
            }
            temp = pilha.pop(); // desempilha
            System.out.print(temp.chave + " ");
            temp = temp.dir; // move para a direita
        }
        System.out.println("");
    }

    public void preOrdem() {
        preOrdem(raiz);
        System.out.println("");
    }

    private void preOrdem(NoArv raizSubArv) {
        if (raizSubArv != null) {
            System.out.print(raizSubArv.chave + " ");
            preOrdem(raizSubArv.esq);
            preOrdem(raizSubArv.dir);
        }
    }

    public void preOrdem_iter() {
        Stack<NoArv> pilha = new Stack<>();
        pilha.push(raiz); // empilha
        NoArv temp;
        while (!pilha.isEmpty()) {
            temp = pilha.pop(); // visita a raiz
            System.out.print(temp.chave + " ");
            // empilha primeiro o nó direito e só depois o esquerdo,
            // pois assim o esquerdo será desempilhado primeiro
            if (temp.dir != null)
                pilha.push(temp.dir); // empilha a subArv direita
            if (temp.esq != null)
                pilha.push(temp.esq); // empilha a subArv esquerda
        }
        System.out.println("");
    }

    public void posOrdem() {
        posOrdem(raiz);
        System.out.println("");
    }

    private void posOrdem(NoArv raizSubArv) {
        if (raizSubArv != null) {
            posOrdem(raizSubArv.esq);
            posOrdem(raizSubArv.dir);
            System.out.print(raizSubArv.chave + " ");
        }
    }

    public void posOrdem_iter() {
        Stack<NoArv> pilha = new Stack<>();
        Stack<NoArv> pilhaSaida = new Stack<>();
        pilha.push(raiz);
        NoArv temp;
        while (!pilha.isEmpty()) {
            temp = pilha.pop(); // desempilha o nó corrente para empilhá-lo na segunda pilha
            pilhaSaida.push(temp);
            if (temp.esq != null)
                pilha.push(temp.esq);
            if (temp.dir != null)
                pilha.push(temp.dir);
            // na próxima iteração desempilharemos D-E, nesta ordem, mas
            // logo em seguida empilharemos D-E na pilha saída, ou seja,
            // a ordem da pilha de saída ficará sempre: E-D-R
        }
        while (!pilhaSaida.isEmpty()) {
            temp = pilhaSaida.pop();
            System.out.print(temp.chave + " ");
        }
        System.out.println("");
    }

    public void percursoLargura() {
        // Breadth-First Traversal (Level Traversal)
        Queue<NoArv> fila = new LinkedList<>(); // a classe Queue é abstrata
        fila.offer(raiz); // enfileira
        NoArv temp;
        while (!fila.isEmpty()) {
            temp = fila.poll(); // desenfileira
            System.out.print(temp.chave + " ");
            if (temp.esq != null)
                fila.offer(temp.esq);
            if (temp.dir != null)
                fila.add(temp.dir);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ArvBinBusca arv = new ArvBinBusca();
        arv.inserir_iter(100);
        arv.inserir_iter(75);
        arv.inserir_iter(125);
        arv.inserir_iter(65);
        arv.inserir_iter(85);
        arv.inserir_iter(115);
        arv.inserir_iter(150);
        arv.preOrdem();
        arv.emOrdem();
        arv.posOrdem();
        arv.percursoLargura();
    }

}
