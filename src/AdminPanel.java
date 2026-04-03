public class AdminPanel {
    public static void main(String[] args) {
        UserService userService = new UserService();
        RentalService rentalService = new RentalService();

        RegisteredUsers user1 = userService.addNewUsers("张三", "zhangsan@test.com", "VIP");
        RegisteredUsers user2 = userService.addNewUsers("李四", "lisi@test.com", "Regular");

        rentalService.simulateApplicationInput(user1);
        rentalService.simulateApplicationInput(user2);

        rentalService.removeTrip(user1); 
        rentalService.removeTrip(user2); 
    }
}
