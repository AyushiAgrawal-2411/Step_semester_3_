import java.util.Arrays;

public class q5 implements Comparable<q5> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public q5(String name, int matchesPlayed,
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

    @Override
    public int compareTo(q5 other) {

        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }

    static String draftAndRank(q5[] players) {

        q5[] draftable = new q5[players.length];

        int count = 0;

        for (q5 player : players) {

            if (isDraftable(player.matchesPlayed) ||
                    isDraftable(player.matchesPlayed, player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        q5[] finalDraftable =
                Arrays.copyOf(draftable, count);

        Arrays.sort(finalDraftable);

        String result = "";

        for (int i = 0; i < finalDraftable.length; i++) {

            result += (i + 1) + ". " +
                    finalDraftable[i].name;

            if (i < finalDraftable.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        q5[] players = {

                new q5("Virat", 15, 48.0, false),

                new q5("Rahul", 7, 55.0, false),

                new q5("Sameer", 3, 60.0, false),

                new q5("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}