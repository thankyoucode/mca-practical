public class _02_PrimeAndFibonacci {
    public int start = 1, end=10;

    public static void Fibonacci(int start, int end) {
        int a=0, b=1, temp;

        while(a <= end) {
            if (start <= a) {

                System.out.println(a);
            }
            temp = a + b;
            a = b;
            b = temp;
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for(int i = 2; i < num; i++) if (num % i == 0) return false;
        return true;
    }

    public static void primes(int start, int end) {
        while(start <= end) {
            if (isPrime(start)) System.out.println(start);
            start++;
        }
    }

    public static void main(String args[]) {
        System.out.println("Fibonacci numbers ");
        Fibonacci(1, 10);

        System.out.println("Primes numbers ");
        primes(1, 10);
    }
}