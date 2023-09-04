public class Cachorro {
    /* Atributos privados */
    private String nome;
    private double peso;
    private int posicaoX;
    private int posicaoY;
    
    /* Construtor */
    public Cachorro (String nome, double peso) {
      this.nome = nome;
      this.peso = peso;
      posicaoX = 0;
      posicaoY = 0;
    }
    
    /* Métodos públicos comuns a todo objeto Cachorro */
    public void andar(int dx, int dy){
      posicaoX += dx;
      posicaoY += dy;
    }
    
    public void comer() {
      peso += (peso*0.01); // aumenta o peso em 1% 
    }
    
    public void latir() {
      System.out.println(nome + ": au au!");
    }

    public String toString() {
      return "Um cachorro chamado " + nome + ", com " + peso + " kg, na posição (" + posicaoX + ", " + posicaoY + ")";
    }
    
    /* Método estático (não faz parte dos objetos instanciados) */
    public static void main(String[] args) {
      Cachorro c1 = new Cachorro("Rex", 3.0);
      Cachorro c2 = new Cachorro("Scooby", 8.0);
      Cachorro c3 = new Cachorro("Milou", 4.0);
      c2.latir();
      c1.comer();
      c3.andar(2, 5);
      c3.andar(1, 4);
      System.out.println(c1);
      System.out.println(c2);
      System.out.println(c3);
	  
    }
}