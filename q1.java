class VotingEligibility {
    void checkVotingEligibility(int age) {
        if (age >= 18) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        VotingEligibility obj = new VotingEligibility();
        obj.checkVotingEligibility(20);
    }
}