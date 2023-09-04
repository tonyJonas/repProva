public class Retangulo {

  private Ponto p1;
  private Ponto p2;
  
  public Retangulo(Ponto ponto1, Ponto ponto2) {
    p1 = ponto1;
    p2 = ponto2;
  }
  
  public Retangulo(double x1, double y1, double x2, double y2) {
    p1 = new Ponto(x1, y1);
    p2 = new Ponto(x2, y2);
  }
  
  public double obterAltura() {
    return Math.abs(p2.obterY() - p1.obterY());
  }
  
  public double obterLargura() {
    return Math.abs(p2.obterX() - p1.obterX());
  }
  
  public double area() {
    return obterAltura() * obterLargura();
  }
    
  public double perimetro() {
      return 2 * (obterAltura() + obterLargura());
  }

  public static void main(String[] args) {
      Ponto pt1 = new Ponto(1, 2);
      Ponto pt2 = new Ponto(4, 9);
      Retangulo r = new Retangulo(pt1, pt2);
      System.out.println(r.obterAltura());
      System.out.println(r.obterLargura());
      System.out.println(r.area());
      System.out.println(r.perimetro());
    }
  
}