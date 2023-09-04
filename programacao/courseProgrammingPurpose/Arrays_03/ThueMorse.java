// package Arrays_03;

public class ThueMorse {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int length = 2;
        while (length <= 2 * n) {
            length *= 2;
        }

        int[] sequence = new int[length];
        sequence[0] = 0;

        for (int i = 1; i < length; i++) {
            sequence[i] = 1 - sequence[i & (i - 1)];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i] == sequence[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }

}
