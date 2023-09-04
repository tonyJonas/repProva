package atividadeAula;

public class Cachorro {
    /* Atributos privados */
    // complete com os atributos necessários
    private String nome;
    private double peso;
    private int posicaoX = 0;
    private int posicaoY = 0;
    
    
    /* Construtor */
    public Cachorro (String nome, double peso) {
      // completar
      this.nome = nome;
      this.peso = peso;

    }
    
    /* Métodos públicos comuns a todo objeto Cachorro */
    public void andar(int dx, int dy){
      // completar
      posicaoX += dx;
      posicaoY += dy;
      System.out.println("O cachorro " + nome + " andou para a posição (" + posicaoX + ", " + posicaoY + ")");
    }
    
    public void comer() {
      // completar
      peso += 1.5;
      System.out.println("O cachorro " + nome + " comeu e agora está com " + peso + "kg");
    }
    
    public void latir() {
      System.out.println("Au au au au!!!!!");
    }

    public String toString() {
      // completar
      return "";
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