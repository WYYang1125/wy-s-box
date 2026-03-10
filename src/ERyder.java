
class ERyder {
    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;

    private int bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    private int totalUsageInMinutes;
    private double totalFare;

    public ERyder(int bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = "Unknown";
        this.LINKED_PHONE_NUMBER = "Unknown";
    }

    public ERyder(int bikeID, int batteryLevel, boolean isAvailable, double kmDriven,
                  String linkedAccount, String linkedPhoneNumber) {
        this.bikeID = bikeID;
        this.setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = linkedAccount;
        this.LINKED_PHONE_NUMBER = linkedPhoneNumber;
    }

    private double calculateFare(int usageInMinutes) {
        return BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
    }

    public void printRideDetails(int usageInMinutes) {
        this.totalUsageInMinutes = usageInMinutes;
        this.totalFare = calculateFare(usageInMinutes);

        System.out.println("===== 骑行详情 =====");
        System.out.println("绑定账号：" + LINKED_ACCOUNT);
        System.out.println("绑定手机号：" + LINKED_PHONE_NUMBER);
        System.out.println("自行车ID：" + bikeID);
        System.out.println("使用时长：" + usageInMinutes + " 分钟");
        System.out.println("总费用：" + totalFare + " 欧元");
        System.out.println("===================\n");
    }

    public void ride() {
        if (this.batteryLevel > 0 && this.isAvailable) {
            System.out.println("自行车可用，可以骑行。");
        } else {
            System.out.println("自行车不可用，无法骑行。");
        }
    }

    public void printBikeDetails() {
        System.out.println("自行车ID: " + this.bikeID);
        System.out.println("电池电量: " + this.batteryLevel + "%");
        System.out.println("是否可用: " + (this.isAvailable ? "是" : "否"));
        System.out.println("总行驶距离: " + this.kmDriven + " 公里");
        System.out.println("------------------------");
    }

    public int getBikeID() { return bikeID; }
    public void setBikeID(int bikeID) { this.bikeID = bikeID; }

    public int getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("错误：电池电量必须在0到100之间。设置失败。");
        }
    }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public double getKmDriven() { return kmDriven; }
    public void setKmDriven(double kmDriven) { this.kmDriven = kmDriven; }
}

public class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder(1001, 80, true, 150.5);
        System.out.println("=== Bike1 ===");
        bike1.printRideDetails(20);

        ERyder bike2 = new ERyder(1002, 95, true, 200.0, "user_john", "123456789");
        System.out.println("=== Bike2 ===");
        bike2.printRideDetails(30);
    }
}
