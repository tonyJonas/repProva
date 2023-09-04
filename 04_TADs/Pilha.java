public class Pilha {
    private No topo;
    private int n;
    
    private class No {
        private String item;
        private No prox;
    }
    
    public Pilha() {
        topo = null;
        n = 0;
    }
    
    public boolean estaVazia() {
        return topo == null;
    }
    
    public int tamanho() {
        return n;
    }
    
    public void empilhar(String valor) {
        No novo = new No();
        novo.item = valor;
        novo.prox = topo;
        topo = novo;
        n++;
    }
    
    public String desempilhar() {
        if (!estaVazia()) {
            String valor = topo.item;
            topo = topo.prox;
            n--;
            return valor;
        } else
          return null;
    }
    
    public String topo() {
        if (!estaVazia()) {
            return topo.item;
        } else
          return null;
    }
    
    public static void main(String[] args) {
      Pilha x = new Pilha();
      x.empilhar("a");
      x.empilhar("b");
      System.out.println(x.desempilhar());
      x.empilhar("c");
      x.empilhar("d");
      System.out.println(x.topo());
      System.out.println(x.tamanho());
      System.out.println(x.estaVazia());
      
    }
}