public class Ponto {
    private double x;
    private double y;
    
    public Ponto(double valorX, double valorY) {
      x = valorX;
      y = valorY;
    }
    
    public double obterX() {
      return x; 
    }
    
    public double obterY() {
      return y; 
    }
    
    public void transpor(double dx, double dy) {
      x += dx;
      y += dy;
    }
    
    public double distancia(Ponto p) {
      double dx = x - p.obterX();
      double dy = y - p.obterY();
      return Math.sqrt(dx * dx + dy * dy);
    }
    
    public void normalizar() {
        double d = distancia(new Ponto(0, 0));
        x /= d;
        y /= d;
    }
    
    public String toString() {
      return "(" + x + ", " + y + ")";
    }
    
    public static void main(String[] args) {
      Ponto p1 = new Ponto(1, 2);
      Ponto p2 = new Ponto(10, 10);
      p1.transpor(1, 3);
      System.out.println(p1.distancia(p2));
      p2.normalizar();
      System.out.println(p1);
      System.out.println(p2);
    }
}