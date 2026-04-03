public class RegularUser extends RegisteredUsers {


    public RegularUser(String fullName, String emailAddress) {
        super(fullName, emailAddress);
    }

    @Override
    public double calculateFare(double baseFare) {
        return super.calculateFare(baseFare);
    }

    @Override
    public void displayUserType() {
        System.out.println("Regular User");
    }
}
