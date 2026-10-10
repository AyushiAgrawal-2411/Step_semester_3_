
package week9;

import java.util.*;

abstract class Student {
    static final double TUITION = 40000;
    static final double TRANSPORT = 12000;

    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double fee();

    boolean usesBus() {
        return false;
    }

    double totalFee() {
        return fee() + (usesBus() ? TRANSPORT : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double fee() {
        return TUITION;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double fee() {
        return TUITION + 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double fee() {
        return TUITION / 2;
    }

    boolean usesBus() {
        return true;
    }
}

public class w9q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double fee = s.totalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
