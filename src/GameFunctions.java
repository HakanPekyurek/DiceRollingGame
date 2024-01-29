import java.util.Random;
import java.util.Scanner;

public class GameFunctions {
    int roundCount = 0;
    int total1 = 0, total2 = 0, total3 = 0;
    int dice1 = 0, dice2 = 0, dice3 = 0;
    int formattingDice1 = 0, formattingDice2 = 0, formattingDice3 = 0;
    String rightAlignFormat;

    public void createScoreBoard() {
        getRoundCount();

        createBoardSkeleton();

        for (int i = 1; i <= roundCount; i++) {
            createRandomNumber();
            controlDiceNumbers();

            System.out.format(rightAlignFormat, i, dice1, dice2, dice3, total1, total2, total3);
            System.out.format("+---------+---------+---------+---------+----------+----------+----------+%n");
        }
    }

    public void getRoundCount() {
        while (roundCount <= 0 || roundCount > 99) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number of rounds: ");
            roundCount = scanner.nextInt();
        }
    }

    public void createBoardSkeleton() {
        rightAlignFormat = "| %4s    | %4s    | %4s    | %4s    |  %4s    |  %4s    |  %4s    |%n";

        System.out.format("+---------+---------+---------+---------+----------+----------+----------+%n");
        System.out.format("|  ROUND  |  DICE1  |  DICE2  |  DICE3  |  TOTAL1  |  TOTAL2  |  TOTAL3  |%n");
        System.out.format("+---------+---------+---------+---------+----------+----------+----------+%n");
    }

    public void createRandomNumber() {
        Random random = new Random();
        dice1 = random.nextInt(1, 7);
        dice2 = random.nextInt(1, 7);
        dice3 = random.nextInt(1, 7);
    }

    public void controlDiceNumbers() {
        if (dice1 == dice2 && dice1 != dice3 && dice1 > dice3) {
            formattingDice1 = dice1 * 2;
            formattingDice2 = dice2 * 2;

            total1 = total1 + formattingDice1;
            total2 = total2 + formattingDice2;
            total3 = total3 + dice3;
        } else if (dice1 == dice3 && dice1 != dice2 && dice1 > dice2) {
            formattingDice1 = dice1 * 2;
            formattingDice3 = dice3 * 2;

            total1 = total1 + formattingDice1;
            total2 = total2 + dice2;
            total3 = total3 + formattingDice3;
        } else if (dice2 == dice3 && dice2 != dice1 && dice2 > dice1) {
            formattingDice2 = dice2 * 2;
            formattingDice3 = dice3 * 2;

            total1 = total1 + dice1;
            total2 = total2 + formattingDice2;
            total3 = total3 + formattingDice3;
        }else {
            total1 = total1 + dice1;
            total2 = total2 + dice2;
            total3 = total3 + dice3;
        }
    }
}
