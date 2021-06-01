import java.util.Scanner;
public class RandomGenerator {
    public static String[] getList(String choices) {
        String[] list = choices.split(", ");
        return list;
    }
    public static String pickRandomChoice(String[] list) {
        int i = (int) (Math.random() * list.length);
        return list[i];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the choices separated by commas with spaces, and the random generator will pick a random one for you!");
        String choices = input.nextLine();
        String[] list = getList(choices);
        System.out.println("Your random choice is: " + pickRandomChoice(list));
    }
}
