public class ERyder {
    // 成员变量
    private int bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    // 默认构造函数
    public ERyder() {
        // 默认值可以设为0或false
        this.bikeID = 0;
        this.batteryLevel = 0;
        this.isAvailable = false;
        this.kmDriven = 0.0;
    }

    // 带所有参数的构造函数
    public ERyder(int bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        // 使用setter方法来确保电池电量在有效范围内
        this.setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }

    // ride() 方法
    public void ride() {
        if (this.batteryLevel > 0 && this.isAvailable) {
            System.out.println("自行车可用，可以骑行。");
        } else {
            System.out.println("自行车不可用，无法骑行。");
        }
    }

    // printBikeDetails() 方法
    public void printBikeDetails() {
        System.out.println("自行车ID: " + this.bikeID);
        System.out.println("电池电量: " + this.batteryLevel + "%");
        System.out.println("是否可用: " + (this.isAvailable ? "是" : "否"));
        System.out.println("总行驶距离: " + this.kmDriven + " 公里");
        System.out.println("------------------------");
    }

    // Getter 和 Setter 方法
    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    // 设置电池电量的setter方法，包含范围检查
    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("错误：电池电量必须在0到100之间。设置失败。");
            // 如果输入无效，可以选择设置为默认值或抛出异常
            // 这里选择保持原值不变
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }
}
