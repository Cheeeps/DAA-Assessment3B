import java.util.Scanner;

class Participant {
    String name;
    int easyScore;
    int averageScore;
    int difficultScore;

    public Participant(String name) {
        this.name = name;
        this.easyScore = 0;
        this.averageScore = 0;
        this.difficultScore = 0;
    }

    public int getTotalScore() {
        return (easyScore * 2) + (averageScore * 5) + (difficultScore * 8);
    }
}

public class QuizBee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Participant[] participants = new Participant[2];

        System.out.println("Enter participants' names and their scores for each round:");
        for (int i = 0; i < participants.length; i++) {
            System.out.print("Participant " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            participants[i] = new Participant(name);

            System.out.print("Easy round score: ");
            participants[i].easyScore = scanner.nextInt();
            System.out.print("Average round score: ");
            participants[i].averageScore = scanner.nextInt();
            System.out.print("Difficult round score: ");
            participants[i].difficultScore = scanner.nextInt();

            scanner.nextLine(); // consume newline
        }

        // Selection sort to sort participants by total score
        for (int i = 0; i < participants.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < participants.length; j++) {
                if (participants[j].getTotalScore() > participants[maxIndex].getTotalScore()) {
                    maxIndex = j;
                }
            }
            // Swap participants
            Participant temp = participants[maxIndex];
            participants[maxIndex] = participants[i];
            participants[i] = temp;
        }

        System.out.println("\nTop 3 students:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + participants[i].name + " - Total Score: " + participants[i].getTotalScore());
        }
    }
}
