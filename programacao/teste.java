public class Avaliacao {
    public int func_recursiva(int[] a, int b) {
        if (b<a.length) {
            return a[b] + func_recursiva(a, b+1);
        } else {
            return 0;
        }
    }

    public int func_interativa(int[] a, int b) {
        // Implemente este método
    }
    
}
