import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNumber = 0;

        while (true) {
            long n = sc.nextLong();
            int b = sc.nextInt();

            if (n == 0 & b == 0) break; // fim do programa

            // Calcular numero de chamadas
            int lastValue = countFibCalls(n, b);

            System.out.printf("Case %d: %d %d %d%n", ++caseNumber, n, b, lastValue);
        }
    }

    public static int countFibCalls(long n, int b) {
        // Listas do numero de fibonacci e das chamadas
        int[] fibMod = new int[6*b + 1];
        int[] calls = new int[6*b + 1];

        // Casos iniciais
        fibMod[0] = 0;
        fibMod[1] = 1;
        calls[0] = 1;
        calls[1] = 1;

        int m = 0;

        // loop de acordo com o periodo de pisano
        for (int i = 2; i <= 6*b; i++) {
            fibMod[i] = (fibMod[i-1] + fibMod[i-2]) % b;
            calls[i] = (calls[i-1] + calls[i-2] + 1) % b;

            if (fibMod[i] == 1 && fibMod[i-1] == 0) {
                m = i - 1;
                break;
            }
        }
        return calls[(int)(n % m)];
    }
}
