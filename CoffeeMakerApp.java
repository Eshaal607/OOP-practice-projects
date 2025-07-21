
import java.util.concurrent.locks.ReentrantLock;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

abstract class Appliance {
    private String brand;
    private boolean isOn;

    public Appliance(String brand) {
        this.brand = brand;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(brand + " appliance is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(brand + " appliance is now OFF.");
    }

    public boolean isOn() {
        return isOn;
    }

    public String getBrand() {
        return brand;
    }

    public abstract void operate();
}

class HeatingElement {
    public void heat() {
        System.out.println("Heating element is heating...");
    }
}

class WaterTank {
    private int waterLevel; // in milliliters

    public WaterTank(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void addWater(int amount) {
        waterLevel += amount;
        System.out.println(amount + "ml water added. Current level: " + waterLevel + "ml.");
    }

    public void useWater(int amount) {
        if (waterLevel >= amount) {
            waterLevel -= amount;
            System.out.println(amount + "ml water used. Remaining level: " + waterLevel + "ml.");
        } else {
            System.out.println("Not enough water!");
        }
    }
}

class CoffeeMaker extends Appliance {
    private HeatingElement heatingElement;
    private WaterTank waterTank;
    private String brewStrength;
    private final ReentrantLock operationLock = new ReentrantLock();

    public CoffeeMaker(String brand, WaterTank waterTank) {
        super(brand);
        this.heatingElement = new HeatingElement();
        this.waterTank = waterTank;
        this.brewStrength = "Regular";
    }

    public String getBrewStrength() {
        return brewStrength;
    }

    public void setBrewStrength(String brewStrength) {
        this.brewStrength = brewStrength;
    }

    @Override
    public void operate() {
        if (!isOn()) {
            System.out.println("Please turn ON the coffee maker first!");
            return;
        }
        if (waterTank.getWaterLevel() < 100) {
            System.out.println("Not enough water to brew coffee!");
            return;
        }

        heatingElement.heat();
        System.out.println("Brewing " + brewStrength + " coffee...");
        waterTank.useWater(100);
        logOperation("Brewed a cup of " + brewStrength + " coffee.");
    }

    public void logOperation(String message) {
        try (FileWriter fw = new FileWriter("operations_log.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message);
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }

    public WaterTank getWaterTank() {
        return waterTank;
    }

    public void performDiagnostics() {
        new Thread(() -> {
            operationLock.lock();
            try {
                checkWaterQuality();
                checkFilter();
                checkHeatingElement();
                logOperation("Diagnostics completed successfully.");
            } finally {
                operationLock.unlock();
            }
        }).start();
    }

    private void checkWaterQuality() {
        System.out.println("Checking water quality...");
        if (waterTank.getWaterLevel() < 50) {
            System.out.println("Warning: Low water quality detected (too little water)!");
        } else {
            System.out.println("Water quality is good.");
        }
    }

    private void checkFilter() {
        System.out.println("Checking coffee filter...");
        System.out.println("Coffee filter is clean.");
    }

    private void checkHeatingElement() {
        System.out.println("Checking heating element...");
        System.out.println("Heating element functioning properly.");
    }
}


public class CoffeeMakerApp {
    public static void main(String[] args) {
        WaterTank tank = new WaterTank(500);
        CoffeeMaker maker = new CoffeeMaker("BrewMaster", tank);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Coffee Maker Menu =====");
            System.out.println("1. Turn ON");
            System.out.println("2. Turn OFF");
            System.out.println("3. Brew Coffee");
            System.out.println("4. Set Brew Strength");
            System.out.println("5. Add Water");
            System.out.println("6. Perform Diagnostics");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    maker.turnOn();
                    maker.logOperation("Coffee maker turned ON.");
                    break;
                case 2:
                    maker.turnOff();
                    maker.logOperation("Coffee maker turned OFF.");
                    break;
                case 3:
                    maker.operate();
                    break;
                case 4:
                    System.out.print("Enter brew strength (Mild/Regular/Strong): ");
                    scanner.nextLine();
                    String strength = scanner.nextLine();
                    maker.setBrewStrength(strength);
                    maker.logOperation("Brew strength set to: " + strength);
                    break;
                case 5:
                    System.out.print("Enter water amount (ml): ");
                    int water = scanner.nextInt();
                    maker.getWaterTank().addWater(water);
                    maker.logOperation("Added " + water + "ml water.");
                    break;
                case 6:
                    maker.performDiagnostics();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
