class _16_PrimitiveToObj {
    public static void main(String[] args) {

        int a = 10;
        double b = 20.5;
        char c = 'A';
        boolean d = true;

        // Manual Boxing
        Integer aObj1 = Integer.valueOf(a);
        Double bObj1 = Double.valueOf(b);
        Character cObj1 = Character.valueOf(c);
        Boolean dObj1 = Boolean.valueOf(d);

        // Auto Boxing
        Integer aObj2 = a;
        Double bObj2 = b;
        Character cObj2 = c;
        Boolean dObj2 = d;

        // Manual Unboxing
        int x = aObj1.intValue();
        double y = bObj1.doubleValue();

        // Auto Unboxing
        int p = aObj2;
        double q = bObj2;

        System.out.println(aObj1 + " " + bObj1 + " " + cObj1 + " " + dObj1);
        System.out.println(aObj2 + " " + bObj2 + " " + cObj2 + " " + dObj2);
        System.out.println(x + " " + y + " " + p + " " + q);
    }
}