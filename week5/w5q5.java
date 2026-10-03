package week5;

import java.util.Arrays;

public class w5q5 implements Comparable<w5q5> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public w5q5(String name, int matchesPlayed,
                double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public String getName() {
        return name;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    @Override
    public int compareTo(w5q5 other) {

        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }

    static String draftAndRank(w5q5[] players) {

        w5q5[] draftable = new w5q5[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                    isDraftable(players[i].matchesPlayed,
                            players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        w5q5[] finalPlayers = Arrays.copyOf(draftable, count);

        Arrays.sort(finalPlayers);

        String result = "";

        for (int i = 0; i < finalPlayers.length; i++) {

            result = result + (i + 1) + ". "
                    + finalPlayers[i].name;

            if (i < finalPlayers.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        w5q5[] players = {
                new w5q5("Virat", 15, 48.0, false),
                new w5q5("Rahul", 7, 55.0, false),
                new w5q5("Sameer", 3, 60.0, false),
                new w5q5("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}