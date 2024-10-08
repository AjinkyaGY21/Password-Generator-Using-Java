import java.util.Scanner;

public class Main{
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        Generator generator = new Generator(input);
        generator.mainLoop();
        input.close();
    }
}
