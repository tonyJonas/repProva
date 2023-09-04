// package taskLoopsAndConditionals;

public class RandomWalker {
    public static void main(String args[]) {
        int steps = 0;

        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        System.out.println("(" + x + ", " + y + ")");

        while (Math.abs(x) + Math.abs(y) != r) {
            double random = Math.random();
            if (random > 0.75) {
                x++;
            } else if (random > 0.5) {
                x--;
            } else if (random > 0.25) {
                y++;
            } else if (random >= 0) {
                y--;
            }
            steps++;
            System.out.println("(" + x + ", " + y + ")");
        }



        System.out.println("steps = " + steps);
    }
}
