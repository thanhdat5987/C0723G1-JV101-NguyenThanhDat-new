package ss_8.bai_tap.tenis;

import java.util.Scanner;

public class TennisGame {
    private static final String DASH = " - ";
    private static final String WORD_ALL = " All";
    private static final String SCORE0 = "Love";
    private static final String SCORE1 = "Fifteen";
    private static final String SCORE2 = "Thirty";
    private static final String SCORE3 = "Forty";
    private static String screenDisplay = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter score of player1: ");
        int scoreOfPlayer1 = scanner.nextInt();
        System.out.print("Enter score of player2: ");
        int scoreOfPlayer2 = scanner.nextInt();
        if (scoreOfPlayer1 == scoreOfPlayer2) {
            readEqualScore(scoreOfPlayer1);
        } else if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4) {
            displayResult(scoreOfPlayer1, scoreOfPlayer2);
        } else {
            readScoreLessThan4(scoreOfPlayer1, scoreOfPlayer2);
        }
        System.out.println(screenDisplay);
    }

    public static String readScore(int score) {
        String wordScore = "";
        switch (score) {
            case 0:
                wordScore = SCORE0;
                break;
            case 1:
                wordScore = SCORE1;
                break;
            case 2:
                wordScore = SCORE2;
                break;
            case 3:
                wordScore = SCORE3;
                break;
        }
        return wordScore;
    }

    public static void readEqualScore(int scoreOfPlayer1) {
        switch (scoreOfPlayer1) {
            case 0:
                screenDisplay = SCORE0 + WORD_ALL;
                break;
            case 1:
                screenDisplay = SCORE1 + WORD_ALL;
                break;
            case 2:
                screenDisplay = SCORE2 + WORD_ALL;
                break;
            case 3:
                screenDisplay = SCORE3 + WORD_ALL;
                break;
            default:
                screenDisplay = "Deuce";
                break;
        }
    }

    public static void displayResult(int scoreOfPlayer1, int scoreOfPlayer2) {
        int minusResult = scoreOfPlayer1 - scoreOfPlayer2;
        if (minusResult == 1) {
            screenDisplay = "Advantage player1";
        } else if (minusResult == -1) {
            screenDisplay = "Advantage player2";
        } else if (minusResult >= 2) {
            screenDisplay = "Win for player1";
        } else {
            screenDisplay = "Win for player2";
        }
    }

    public static void readScoreLessThan4(int scoreOfPlayer1, int scoreOfPlayer2) {
        int minusResult = scoreOfPlayer1 - scoreOfPlayer2;
        if (minusResult == 0) {
            readEqualScore(scoreOfPlayer1);
        } else {
            screenDisplay = readScore(scoreOfPlayer1) + DASH + readScore(scoreOfPlayer2);
        }
    }
}