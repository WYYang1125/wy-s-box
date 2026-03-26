import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


class RegisteredUsers {
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private String cardNumber;
    private String cardExpiryDate;
    private String cardProvider;
    private String cvv;
    private String userType;
    private String[] lastThreeTrips;

   
    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth,
                          String cardNumber, String cardExpiryDate, String cardProvider,
                          String cvv, String userType, String[] lastThreeTrips) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardProvider = cardProvider;
        this.cvv = cvv;
        this.userType = userType;
        this.lastThreeTrips = lastThreeTrips;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String[] getLastThreeTrips() {
        return lastThreeTrips;
    }

    public void setLastThreeTrips(String[] lastThreeTrips) {
        this.lastThreeTrips = lastThreeTrips;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Registered User ===");
        sb.append("\nFull Name: " + fullName);
        sb.append("\nEmail: " + emailAddress);
        sb.append("\nDate of Birth: " + dateOfBirth);
        sb.append("\nCard Number: " + cardNumber);
        sb.append("\nCard Expiry: " + cardExpiryDate);
        sb.append("\nCard Provider: " + cardProvider);
        sb.append("\nCVV: " + cvv);
        sb.append("\nUser Type: " + userType);
        sb.append("\n--- Last Three Trips ---");
        if (lastThreeTrips != null) {
            for (int i = 0; i < lastThreeTrips.length; i++) {
                sb.append("\nTrip " + (i + 1) + ": " + lastThreeTrips[i]);
            }
        }
        sb.append("\n========================\n");
        return sb.toString();
    }
}
class AdminPanel {
    private List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public void userManagementOptions() {
        while (true) {
            System.out.println("\nWelcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");
            System.out.print("Please enter your choice: ");
            if (!sc.hasNextLine()) {
                System.out.println("\nNo input available, program exited.");
                return;
            }
            String input = sc.nextLine().trim();
            
            if (!input.matches("[1-5]")) {
                System.out.println("Invalid choice. Please try again");
                continue;
            }
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    addNewUsers();
                    break;
                case 2:
                    viewRegisteredUsers();
                    break;
                case 3:
                    removeRegisteredUsers();
                    break;
                case 4:
                    updateRegisteredUsers();
                    break;
                case 5:
                    System.out.println("Program exited.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }
    private void addNewUsers() {
        System.out.print("\nHow many users do you want to add: ");
        int count = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < count; i++) {
            System.out.println("\n----- Adding User " + (i + 1) + " -----");

            System.out.print("Full Name: ");
            String fullName = sc.nextLine().trim();

            System.out.print("Email Address: ");
            String email = sc.nextLine().trim();

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dob = sc.nextLine().trim();

            System.out.print("Card Number: ");
            String cardNum = sc.nextLine().trim();

            System.out.print("Card Expiry Date: ");
            String expiry = sc.nextLine().trim();

            System.out.print("Card Provider: ");
            String provider = sc.nextLine().trim();

            System.out.print("CVV: ");
            String cvv = sc.nextLine().trim();

            System.out.print("User Type: ");
            String userType = sc.nextLine().trim();
            String[] lastThree = new String[3];
            for (int t = 0; t < 3; t++) {
                System.out.println("\n--- Trip " + (t + 1) + " ---");
                System.out.print("Trip Date (YYYY-MM-DD): ");
                String date = sc.nextLine().trim();
                System.out.print("Source: ");
                String source = sc.nextLine().trim();
                System.out.print("Destination: ");
                String dest = sc.nextLine().trim();
                System.out.print("Fare (€): ");
                String fare = sc.nextLine().trim();
                System.out.print("Feedback (can be NULL): ");
                String feedback = sc.nextLine().trim();

                StringBuilder sb = new StringBuilder();
                sb.append("Date: " + date);
                sb.append(", Source: " + source);
                sb.append(", Destination: " + dest);
                sb.append(", Fare (€): " + fare);
                sb.append(", Feedback: " + feedback);

                lastThree[t] = sb.toString();
            }

            RegisteredUsers user = new RegisteredUsers(
                    fullName, email, dob, cardNum, expiry, provider, cvv, userType, lastThree
            );
            registeredUsersList.add(user);
            System.out.println("User added successfully!");
        }
    }
    private void viewRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("\nNo registered users to display");
            return;
        }
        System.out.println("\n===== All Registered Users =====");
        for (RegisteredUsers u : registeredUsersList) {
            System.out.println(u);
        }
    }
    private void removeRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("\nNo registered users to remove");
            return;
        }
        System.out.print("\nEnter email to remove: ");
        String email = sc.nextLine().trim();
        boolean found = false;

        Iterator<RegisteredUsers> it = registeredUsersList.iterator();
        while (it.hasNext()) {
            RegisteredUsers u = it.next();
            if (u.getEmailAddress().equals(email)) {
                it.remove();
                found = true;
                System.out.println("User removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    private void updateRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("\nNo registered users to update");
            return;
        }
        System.out.print("\nEnter email to update: ");
        String email = sc.nextLine().trim();
        RegisteredUsers target = null;

        for (RegisteredUsers u : registeredUsersList) {
            if (u.getEmailAddress().equals(email)) {
                target = u;
                break;
            }
        }

        if (target == null) {
            System.out.println("No user found with this email address");
            return;
        }

        System.out.println("\n--- Update User (Press ENTER to keep old value) ---");

        System.out.print("New full name: ");
        String fn = sc.nextLine().trim();
        if (!fn.isEmpty()) target.setFullName(fn);

        System.out.print("New email: ");
        String em = sc.nextLine().trim();
        if (!em.isEmpty()) target.setEmailAddress(em);

        System.out.print("New date of birth: ");
        String dob = sc.nextLine().trim();
        if (!dob.isEmpty()) target.setDateOfBirth(dob);

        System.out.print("New card number (0 = no change): ");
        String cn = sc.nextLine().trim();
        if (!cn.isEmpty() && !cn.equals("0")) target.setCardNumber(cn);

        System.out.print("New card expiry: ");
        String exp = sc.nextLine().trim();
        if (!exp.isEmpty()) target.setCardExpiryDate(exp);

        System.out.print("New card provider: ");
        String cp = sc.nextLine().trim();
        if (!cp.isEmpty()) target.setCardProvider(cp);

        System.out.print("New CVV (0 = no change): ");
        String cvv = sc.nextLine().trim();
        if (!cvv.isEmpty() && !cvv.equals("0")) target.setCvv(cvv);

        System.out.print("New user type: ");
        String ut = sc.nextLine().trim();
        if (!ut.isEmpty()) target.setUserType(ut);

        System.out.println("User updated successfully!");
    }
}
public class Main {
    public static void main(String[] args) {
        AdminPanel admin = new AdminPanel();
        admin.userManagementOptions();
    }
}
