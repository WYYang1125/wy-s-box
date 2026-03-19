import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class UserRegistration {
    private static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
    private static final double VIP_DISCOUNT_UNDER_18 = 20.0;
    private static final double VIP_BASE_FEE = 100.0;
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private double feeToCharge;
    private int cvv;
    private String userType;
    private boolean emailValid;
    private boolean minorAndBirthday;
    private boolean minor;
    private boolean ageValid;
    private boolean cardNumberValid;
    private boolean cardStillValid;
    private boolean validCVV;
    public void registration() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the ERyder Registration.");
        System.out.println("Here are your two options:");
        System.out.println("1. Register as a Regular User");
        System.out.println("2. Register as a VIP User");
        System.out.print("Please enter your choice (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine();
        userType = (choice == 1) ? "Regular User" : "VIP User";
        System.out.print("Enter full name: ");
        fullName = sc.nextLine();
        System.out.print("Enter email address: ");
        emailAddress = sc.nextLine();
        emailValid = analyseEmail(emailAddress);
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        dateOfBirth = sc.nextLine();
        LocalDate dob = LocalDate.parse(dateOfBirth);
        ageValid = analyseAge(dob);
        System.out.print("Enter card number: ");
        cardNumber = sc.nextLong();
        cardNumberValid = analyseCardNumber(cardNumber);
        System.out.print("Enter card expiry date (MM/YY): ");
        cardExpiryDate = sc.next();
        cardStillValid = analyseCardExpiryDate(cardExpiryDate);
        System.out.print("Enter CVV: ");
        cvv = sc.nextInt();
        validCVV = analyseCVV(cvv);
        finalCheckpoint();
        sc.close();
    }
    private boolean analyseEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            System.out.println("Email is valid");
            return true;
        } else {
            System.out.println("Invalid email address. Going back to start.");
            registration();
            return false;
        }
    }
    private boolean analyseAge(LocalDate dob) {
        LocalDate now = LocalDate.now();
        int age = Period.between(dob, now).getYears();
        boolean isBirthday = (dob.getMonthValue() == now.getMonthValue() &&
                              dob.getDayOfMonth() == now.getDayOfMonth());

        minorAndBirthday = false;
        minor = false;
        if ("VIP User".equals(userType)) {
            if (age > 12 && age <= 18) {
                if (isBirthday) {
                    System.out.println("Happy Birthday! 25% discount!");
                    minorAndBirthday = true;
                } else {
                    System.out.println("20% discount for under 18!");
                    minor = true;
                }
            }
        }
        if (age <= 12 || age > 120) {
            System.out.println("Too young or too old. Exit.");
            System.exit(0);
        }
        return true;
    }
    private boolean analyseCardNumber(long num) {
        String s = String.valueOf(num);
        if (s.length() < 4) {
            System.out.println("Invalid card. Restart...");
            registration();
            return false;
        }

        int firstTwo = Integer.parseInt(s.substring(0, 2));
        int firstFour = Integer.parseInt(s.substring(0, 4));
        if ((s.length() == 13 || s.length() == 15) && s.startsWith("4")) {
            cardProvider = "VISA";
            return true;
        }
        else if (s.length() == 16 &&
                ((firstTwo >= 51 && firstTwo <= 55) || (firstFour >= 2221 && firstFour <= 2720))) {
            cardProvider = "MasterCard";
            return true;
        }
        else if (s.length() == 15 && (s.startsWith("34") || s.startsWith("37"))) {
            cardProvider = "American Express";
            return true;
        }
        else {
            System.out.println("Only VISA/MasterCard/Amex. Restart...");
            registration();
            return false;
        }
    }
    private boolean analyseCardExpiryDate(String exp) {
        int month = Integer.parseInt(exp.substring(0, 2));
        int year = 2000 + Integer.parseInt(exp.substring(3, 5));
        LocalDate now = LocalDate.now();
        int currYear = now.getYear();
        int currMonth = now.getMonthValue();

        if (year > currYear || (year == currYear && month >= currMonth)) {
            System.out.println("The card is still valid");
            return true;
        } else {
            System.out.println("Card expired. Restart...");
            registration();
            return false;
        }
    }
    private boolean analyseCVV(int cvv) {
        String cvvStr = String.valueOf(cvv);
        boolean ok = false;

        if ("American Express".equals(cardProvider) && cvvStr.length() == 4) ok = true;
        else if (("VISA".equals(cardProvider) || "MasterCard".equals(cardProvider)) && cvvStr.length() == 3) ok = true;

        if (ok) {
            System.out.println("Card CVV is valid.");
            return true;
        } else {
            System.out.println("Invalid CVV. Restart...");
            registration();
            return false;
        }
    }
    private void finalCheckpoint() {
        if (emailValid && ageValid && cardNumberValid && cardStillValid && validCVV) {
            chargeFees();
        } else {
            System.out.println("Registration unsuccessful:");
            if (!emailValid) System.out.println("- Invalid email");
            if (!ageValid) System.out.println("- Invalid age");
            if (!cardNumberValid) System.out.println("- Invalid card number");
            if (!cardStillValid) System.out.println("- Card expired");
            if (!validCVV) System.out.println("- Invalid CVV");
            System.out.println("Restarting...");
            registration();
        }
    }
    private void chargeFees() {
        if (minorAndBirthday) {
            feeToCharge = VIP_BASE_FEE * (100 - VIP_DISCOUNT_UNDER_18_BIRTHDAY) / 100;
        } else if (minor) {
            feeToCharge = VIP_BASE_FEE * (100 - VIP_DISCOUNT_UNDER_18) / 100;
        } else {
            feeToCharge = VIP_BASE_FEE;
        }

        String cardStr = String.valueOf(cardNumber);
        String last4 = cardStr.substring(cardStr.length() - 4);
        System.out.println("Thank you for payment.");
        System.out.printf("Fee %.2f charged to card ending ****%s%n", feeToCharge, last4);
    }
    @Override
    public String toString() {
        String cardStr = String.valueOf(cardNumber);
        String hide = cardStr.substring(0, cardStr.length() - 4).replaceAll(".", "*");
        String last4 = cardStr.substring(cardStr.length() - 4);
        String safeCard = hide + last4;

        return "\nRegistration successful! Here are your details:\n" +
                "User Type: " + userType + "\n" +
                "Full Name: " + fullName + "\n" +
                "Email: " + emailAddress + "\n" +
                "DOB: " + dateOfBirth + "\n" +
                "Card: " + safeCard + "\n" +
                "Provider: " + cardProvider + "\n" +
                "Expiry: " + cardExpiryDate;
    }
}
class Main {
    public static void main(String[] args) {
        UserRegistration reg = new UserRegistration();
        reg.registration();
        System.out.println(reg);
    }
}
