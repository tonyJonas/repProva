public class ColorHSB {
    private final int hue, saturation, brightness;

    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100)
            throw new IllegalArgumentException("Valores inválidos");

        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    public int distanceSquaredTo(ColorHSB color) {
        if (color == null)
            throw new IllegalArgumentException("Insira um argumento válido");

        int dh = this.hue - color.hue;
        int ds = this.saturation - color.saturation;
        int db = this.brightness - color.brightness;

        return Math.min(dh * dh, (360 - Math.abs(dh)) * (360 - Math.abs(dh))) + ds * ds + db * db;
    }

    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB inputColor = new ColorHSB(h, s, b);

        String colorName = "";
        ColorHSB color = null;
        int minDistance = 360*360*360;

        while (StdIn.hasNextLine()) {
            String name = StdIn.readString();
            int hNew = StdIn.readInt();
            int sNew = StdIn.readInt();
            int bNew = StdIn.readInt();

            ColorHSB colorNew = new ColorHSB(hNew, sNew, bNew);

            if (inputColor.distanceSquaredTo(colorNew) < minDistance) {
                minDistance = inputColor.distanceSquaredTo(colorNew);
                color = colorNew;
                colorName = name;
            }
        }

        StdOut.println(colorName + " " + color);
    }
}
