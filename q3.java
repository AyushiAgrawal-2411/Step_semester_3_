class PrintNumbers {
    void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        PrintNumbers obj = new PrintNumbers();
        obj.printNumbersUpToN(5);
    }
}
