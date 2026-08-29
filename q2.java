class NumberClassifier {
    void classifyNumber(int number) {
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }
    public static void main(String[] args) {
        NumberClassifier obj = new NumberClassifier();
        obj.classifyNumber(15);
    }
}
