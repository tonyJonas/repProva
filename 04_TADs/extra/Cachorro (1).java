public class Cachorro {
    /* Atributos privados */
    // complete com os atributos necessários
    
    /* Construtor */
    public Cachorro (String nome, double peso) {
      // completar
    }
    
    /* Métodos públicos comuns a todo objeto Cachorro */
    public void andar(int dx, int dy){
      // completar
    }
    
    public void comer() {
      // completar
    }
    
    public void latir() {
      // completar
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