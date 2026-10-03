package week6;

class EmployeeM5 {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeM5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class w6q5 {
    public static void main(String[] args) {

        EmployeeM5 e1 = new EmployeeM5("Rahul", 40000);
        EmployeeM5 e2 = new EmployeeM5("Priya", 50000);
        EmployeeM5 e3 = new EmployeeM5("Aman", 45000);

        EmployeeM5.printCompanyInfo();
    }
}