public class _29_StringMethods {
    public static void main(String[] args) {
        String str = "  Hello World! Java Programming  ";
        String str2 = "Hello";
        
        System.out.println("String methods demo:\n");
        
        System.out.println("length: " + str.length());
        System.out.println("char at 6: " + str.charAt(6));
        System.out.println("sub 0-5: " + str.substring(0,5));
        System.out.println("from 6: " + str.substring(6));
        System.out.println("upper: " + str.toUpperCase());
        System.out.println("lower: " + str.toLowerCase());
        System.out.println("trim: '" + str.trim() + "'");
        System.out.println("equals hello: " + str2.equals("Hello"));
        System.out.println("ignorecase world: " + str.equalsIgnoreCase("hello world"));
        System.out.println("starts H: " + str.startsWith("H"));
        System.out.println("ends !: " + str.endsWith("!"));
        System.out.println("has Java: " + str.contains("Java"));
        System.out.println("first o: " + str.indexOf('o'));
        System.out.println("last o: " + str.lastIndexOf('o'));
        System.out.println("l to L: " + str.replace('l','L'));
        
        String[] w = str.trim().split(" ");
        System.out.println("words count: " + w.length);
        for(String word : w) if(!word.isEmpty()) System.out.println("  " + word);
        
        System.out.println("compare: " + str.compareTo("Hello World"));
        System.out.println("empty: " + "".isEmpty());
        System.out.println("blank: " + "   ".isBlank());
        System.out.println("concat: " + str.trim() + " rocks!");
    }
}