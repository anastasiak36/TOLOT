import java.util.Scanner;
public class QuizGenerator {
    // have two lists, one for terms, one for definitions
    // randomly choose what to ask the user(definitions) and then remove if correct
    //keep track of score (how much wrong and how much right)
    public static String[] removeElement(String[] list, int index) {
        String[] newList = new String[(list.length - 1)];
        int indexCount = 0;
        for (int i = 0; i < list.length; i++) {
            if (i != index) {
                newList[indexCount] = list[i];
                indexCount++;
            }    
        }
        return newList;
    }
    public static int doQuiz(String[] terms, String[] definitions) {
        int score = 0;
        Scanner input = new Scanner(System.in);
        while (terms.length > 0) {
            int i = (int) (Math.random() * terms.length);
            System.out.println("Enter the correct term for: " + definitions[i]);
            String userAnswer = input.nextLine();
            if (userAnswer.equals(terms[i])) {
                //remove from terms and definitons and add 1 to score
                terms = removeElement(terms, i);
                definitions = removeElement(definitions, i);
                System.out.println("That is correct! :)");
                score++;
            }
            else {
                System.out.println("That is wrong :(, you will get to try again later!");
            }
            System.out.println();
        }
        return score;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How much terms are there?");
        int num = Integer.parseInt(input.nextLine());
        String[] terms = new String[num];
        String[] definitions = new String[num];
        
        System.out.println("Enter the term and definition, separated by comma and space each on separate line");
        String line = input.nextLine();
        int count = 0;
        while (!line.equals("done")) {
            String[] temp = line.split(", ");
            terms[count] = temp[0];
            definitions[count] = temp[1];
            line = input.nextLine();
            count++;
            
        }
        String again = "again";
        while (!again.equals("exit")) {
            doQuiz(terms, definitions);
            System.out.println("Congrats! You did it! To try again type again, otherwise type exit.");
            again = input.nextLine();
        }
       

    }
}
