package week9;

import java.util.*;

abstract class Ticket {
    static final double FEE = 20.0;
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double price();

    double amount() {
        return (price() + FEE) * count;
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double price() {
        return 150;
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double price() {
        return 250;
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double price() {
        return 400;
    }
}

public class w9q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket t;

            if (seat.equals("REGULAR"))
                t = new Regular(count);
            else if (seat.equals("PREMIUM"))
                t = new Premium(count);
            else
                t = new Recliner(count);

            double amount = t.amount();
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
