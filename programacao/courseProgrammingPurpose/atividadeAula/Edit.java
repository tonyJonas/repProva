import java.util.HashMap;

public class Edit {

    static long calls;
    static HashMap<Long, Long> fibMap = new HashMap<>();
    static HashMap<Long, Long> fibMapCalls = new HashMap<>();

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);

        long teste = loadArrayFib(n, b);

        // long fibValue = fib(n, b);
        // fibValue = conversionToBase(fibValue, b);
        // System.out.println("numero do fibo: " + fibValue + " and calls: " + calls);
        
        System.out.printf("%d %d %d\n" + teste, n, b, calls);
    }

    public static long loadArrayFib(long n, long b) {
        
        for(long i=2; i<=n; i++) {
            long totalCalls = fibMapCalls.get(i-2)+fibMapCalls.get(i-1);
            fibMapCalls.put(i, totalCalls);
            System.out.println("FIBMAPCALLS: " + fibMapCalls.get(i));
        }
        return fibMapCalls.get(n);
    }

    public static long fib(long n, long b) {
        System.out.println("FIB dnv: n:" + n + " calls: " + calls);
        calls++;
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (fibMap.containsKey(n)) {
            // System.out.println("LISTA PREENCHIDA, valor de n: " + n);
            return fibMap.get(n);
        } else {
            // System.out.println("ADD LISTA, valor de n: " + n + " e valor de calls: " + calls);
            long fibValue = (fib(n-1, b) + fib(n-2, b));
            fibMap.put(n, calls);
            return fibValue;
        }
        // for(int i=2; i<=n; i++) {
        //     fib[i] = (fib[i-2]+fib[i-1])%b;
        // }
    }

    public static long conversionToBase(long n, long b) {
        if (n < b) return n;
        System.out.println(n/b + " + " + (n%b));
        return conversionToBase(n/b, b) + (n%b);
    }
}
