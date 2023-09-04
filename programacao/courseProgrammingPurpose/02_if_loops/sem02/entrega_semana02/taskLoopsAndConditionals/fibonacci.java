import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int instancias = sc.nextInt();
        int calls;
        int result;

        // int i, n;
        // for (i = 0; i < instancias; i++) {
        //     n = sc.nextInt();
        // }
        result = fibo(5);
        
        System.out.printf("fib(%s) = %s calls = %s", instancias, result, calls)

        sc.close();
    }
    
    public int fibo (int instancias) {
        
        calls ++;
        if(instancias == 1) {
            return 1;
        }
        
        return fibo(instancias-1) + fibo(instancias-2);
        
    }
}