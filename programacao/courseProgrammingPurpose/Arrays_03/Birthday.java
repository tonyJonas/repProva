public class Birthday {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] counts = new int[n + 2];
        int total = 0;

        for (int t = 0; t < trials; t++) {
            boolean[] hasBirthday = new boolean[n];
            int people = 0;

            while (true) {
                people++;
                int birthday = (int) (Math.random() * n);

                if (hasBirthday[birthday]) {
                    counts[people]++;
                    break;
                }

                hasBirthday[birthday] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            total += counts[i];
            System.out.printf("%d\t%d\t%.5f\n", i, counts[i], total / (double) trials);
            if (total / (double) trials >= 0.5) {
                break;
            }
        }
    }
}
