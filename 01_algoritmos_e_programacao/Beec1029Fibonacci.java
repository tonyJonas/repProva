import java.io.IOException;
import java.util.Scanner;

public class Beec1029Fibonacci {

    static int calls = -1;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int instancias = sc.nextInt();

        int i, n, result;
        for (i = 0; i < instancias; i++) {
            calls = -1;
            n = sc.nextInt();
            result = fib(n);
            System.out.printf("fib(%d) = %d calls = %d\n", n, calls, result);
        }

    }

    public static int fib(int n) {
        calls++;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
