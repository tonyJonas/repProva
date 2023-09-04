// package Arrays_03;

public class DiscreteDistribution {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length - 1];
        int[] S = new int[args.length - 1];
        int sum = 0;

        for (int i = 0; i < args.length - 1; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
            sum += a[i];
            S[i] = sum;
        }
        
        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * sum);
            int j = 0;
            while (S[j] <= r) {
                j++;
            }
            System.out.print(j + 1 + " ");
        }
        System.out.println();

    }
}