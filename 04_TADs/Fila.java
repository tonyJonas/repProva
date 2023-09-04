public class Fila<Tipo> {
    private No inicio;
    private No fim;
    private int tamanho;
    
    private class No {
        private Tipo item;
        private No prox;
    }
    
    public Fila() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }
    
    public boolean estaVazia() {
        return inicio == null;
    }
    
    public int tamanho() {
        return tamanho;
    }
    
    public void enfileirar(Tipo valor) {
        No novo = new No();
        novo.item = valor;
        if (estaVazia()) {
            inicio = novo;
        } else {
            fim.prox = novo;
        }
        fim = novo;
        tamanho++;
    }
    
    public Tipo desenfileirar() {
        if (!estaVazia()) {        
          Tipo valor = inicio.item;
          inicio = inicio.prox;
          tamanho--;
          if (estaVazia())
            fim = null;
          return valor;
        }
        return null;
    }
    
    public Tipo primeiro() {
        if (!estaVazia())
          return inicio.item;
        return null;
    }
    
    public static void main(String[] valor) {
      Fila<String> fila = new Fila<String>();
      fila.enfileirar("a");
      fila.enfileirar("b");
      System.out.println(fila.desenfileirar());
      fila.enfileirar("c");
      fila.enfileirar("d");
      System.out.println(fila.desenfileirar());
      System.out.println(fila.desenfileirar());
      System.out.println(fila.primeiro());
      System.out.println(fila.tamanho());      
      System.out.println(fila.desenfileirar());
      System.out.println(fila.desenfileirar());
      System.out.println(fila.estaVazia());
    }
}