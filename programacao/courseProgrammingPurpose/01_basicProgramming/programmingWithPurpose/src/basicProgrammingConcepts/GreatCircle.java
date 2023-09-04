public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double r = 6371.0;

        double eq1 = Math.pow(Math.sin((x2 - x1) / 2), 2);
        double eq2 = Math.cos(x1) * Math.cos(x2);
        double eq3 = Math.pow(Math.sin((y2 - y1) / 2), 2);
        double distance2 = 2 * r * Math.asin(Math.sqrt(eq1 + eq2 * eq3));
        System.out.printf("%s kilometers", distance2);

    }
}
