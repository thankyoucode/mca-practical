public class _10_Args {
  public static void main(String args[]) {
    int num_args = args.length;

    System.out.println("Number of arguments: " + num_args);

    for(int i = 0; i < num_args; i++) {
      System.out.println((i+1) + " " + args[i]);
    }
  }
}