public class Ponto {
    // completar com os atributos necessários
    
    public Ponto(double valorX, double valorY) {
      // completar
    }
    
    public double obterX() {
      // completar
      return 0;
    }
    
    public double obterY() {
      // completar
      return 0;
    }
    
    public void transpor(double dx, double dy) {
      // completar
    }
    
    public double distancia(Ponto p) {
      // completar
      return 0;
    }
    
    public void normalizar() {
        // completar
    }
    
    public String toString() {
      // completar
      return "";
    }
    
    public static void main(String[] args) {
      Ponto p1 = new Ponto(1, 2);
      Ponto p2 = new Ponto(10, 10);
      p1.transpor(1, 3);
      System.out.println(p1.distancia(p2));  // imprime 9.433981132056603
      p2.normalizar();
      System.out.println(p1);  // imprime (2.0, 5.0)
      System.out.println(p2);  // imprime (0.7071067811865475, 0.7071067811865475)
    }
}