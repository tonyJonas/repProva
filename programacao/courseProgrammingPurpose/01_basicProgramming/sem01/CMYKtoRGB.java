public class CMYKtoRGB {
    public static void main(String[] args) {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        double white;
        double red;
        double green;
        double blue;

        white = 1 - black;
        red = 255 * white * (1 - cyan);
        green = 255 * white * (1 - magenta);
        blue = 255 * white * (1 - yellow);

        System.out.printf("red = %s %n green = %s %n blue = %s", Math.round(red), Math.round(green), Math.round(blue));

    }
}
