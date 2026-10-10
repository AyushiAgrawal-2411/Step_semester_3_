
package week9;

import java.util.*;

abstract class Appliance {
    abstract double power();

    double units(double hours) {
        return power() * hours / 1000;
    }

    double cost(double units) {
        return units * 8;
    }
}

interface Saver {
    double reduce(double units);
}

class Fridge extends Appliance {
    double power() {
        return 150;
    }
}

class AC extends Appliance implements Saver {
    double power() {
        return 1500;
    }

    public double reduce(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    double power() {
        return 100;
    }
}

class Washer extends Appliance implements Saver {
    double power() {
        return 500;
    }

    public double reduce(double units) {
        return units * 0.75;
    }
}

public class w9q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saverMode = sc.hasNext("SAVER");

            if (saverMode)
                sc.next();

            Appliance a;

            if (type.equals("FRIDGE"))
                a = new Fridge();
            else if (type.equals("AC"))
                a = new AC();
            else if (type.equals("TV"))
                a = new TV();
            else
                a = new Washer();

            if (saverMode && !(a instanceof Saver)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.units(hours);

            if (saverMode)
                units = ((Saver) a).reduce(units);

            double cost = a.cost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n", type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
