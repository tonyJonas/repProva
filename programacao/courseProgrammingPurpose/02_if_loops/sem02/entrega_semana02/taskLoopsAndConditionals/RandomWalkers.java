// package taskLoopsAndConditionals;

public class RandomWalkers {
    public static void main(String args[]) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int trialsLeft = trials;

        double totalSteps = 0;

        while (trialsLeft > 0) {
            double steps = 0;
            int x = 0;
            int y = 0;
            while (Math.abs(x) + Math.abs(y) != r) {
                double random = Math.random();
                if (random > 0.75) {
                    x++;
                } else if (random > 0.5) {
                    x--;
                } else if (random > 0.25) {
                    y++;
                } else if (random > 0) {
                    y--;
                }
                steps++;
            }
            totalSteps += steps;
            trialsLeft--;
        }
        double averageSteps = totalSteps / trials;
        System.out.println("average number of steps = " + averageSteps);
    }
    
}
