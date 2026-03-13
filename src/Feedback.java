public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void analyseFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5) {
        if (isConcatenation) {
            this.completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        } else {
            this.completeFeedback = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5).toString();
        }
        this.longFeedback = checkFeedbackLength(this.completeFeedback);
        createReviewID(this.firstName, this.lastName, this.completeFeedback);
    }

    private String feedbackUsingConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5) {
        String concatenatedFeedback = sent1 + " " + sent2 + " " + sent3 + " " + sent4 + " " + sent5;
        return concatenatedFeedback;
    }

    private StringBuilder feedbackUsingStringBuilder(String sent1, String sent2, String sent3, String sent4, String sent5) {
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(" ").append(sent2).append(" ").append(sent3).append(" ").append(sent4).append(" ").append(sent5);
        return sb;
    }

    private boolean checkFeedbackLength(String feedback) {
        return feedback.length() > 500;
    }

    private void createReviewID(String firstName, String lastName, String completeFeedback) {
        String namePart = (firstName + lastName).substring(2, 6).toUpperCase();
        String feedbackPart = completeFeedback.substring(10, 15).toLowerCase();
        int lengthPart = completeFeedback.length();
        long timePart = System.currentTimeMillis();
        this.reviewID = (namePart + feedbackPart + lengthPart + "_" + timePart).replace(" ", "");
    }

    @Override
    public String toString() {
        return "用户反馈详情：\n" +
                "姓名: " + firstName + " " + lastName + "\n" +
                "邮箱: " + email + "\n" +
                "完整反馈: " + completeFeedback + "\n" +
                "反馈是否过长(>500字符): " + longFeedback + "\n" +
                "反馈ID: " + reviewID;
    }

    public static void main(String[] args) {
        String s1 = "I was very satisfied with the service.";
        String s2 = "The e-Bike is quite comfortable to ride.";
        String s3 = "The battery life of the e-Bike is impressive.";
        String s4 = "The customer support was helpful and responsive.";
        String s5 = "I would recommend this e-Bike to my friends and family.";
        Feedback userFeedback = new Feedback("Alice", "Smith", "alice.smith@example.com");
        buserFeedback.analyseFeedback(false, s1, s2, s3, s4, s5);
        System.out.println(userFeedback);
    }
}
