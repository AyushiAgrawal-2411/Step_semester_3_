package week8;

import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    protected LocalDate startDate;

    Plan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();
}

class Basic extends Plan {
    Basic(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class Standard extends Plan {
    Standard(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class Premium extends Plan {
    Premium(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class w8q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new Basic(startDate);
            } else if (type.equals("STANDARD")) {
                plan = new Standard(startDate);
            } else {
                plan = new Premium(startDate);
            }

            LocalDate renewalDate = plan.getRenewalDate();

            System.out.println(name + ": " + renewalDate);
        }
    }
}