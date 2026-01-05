public class _04_MathPowerUse {
    public static void main(String args[]) {
        int x = 5, n = 3, pow = 1;

        while(n-- > 0) pow *= x;
        
        System.out.println(pow);
    }
}