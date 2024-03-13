import java.util.Scanner;
public class InputFromKeyboard {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        System.out.println("How tall are you (m)?");
        double height = scanner.nextDouble();
        System.out.println("Mrs/Ms. " + name + ", " + age + " years old. " + "Your height is " + height + ".");
        scanner.close();
    }
}
