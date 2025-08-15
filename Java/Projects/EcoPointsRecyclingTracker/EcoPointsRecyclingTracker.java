package Projects.EcoPointsRecyclingTracker;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class EcoPointsRecyclingTracker {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, Household> households = new HashMap<>();

    public static void main() {
        loadHouseholdsFromFile();
        boolean running = true;
        while (running) {
            System.out.println("\n=== Eco-Points Recycling Tracker ===");
            System.out.println("1. Register Household");
            System.out.println("2. Log Recycling Event");
            System.out.println("3. Display Households");
            System.out.println("4. Display Household Recycling Events");
            System.out.println("5. Generate Reports");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    registerHousehold();
                    break;
                case "2":
                    logRecyclingEvent();
                    break;
                case "3":
                    displayHouseholds();
                    break;
                case "4":
                    displayHouseholdEvents();
                    break;
                case "5":
                    generateReports();
                    break;
                case "6":
                    saveHouseholdsToFile();
                    running = false;
                    System.out.println("Data saved. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        }
    }


    private static void registerHousehold() {
        System.out.println("Enter a unique Household ID");
        String id = sc.nextLine().trim();
        if(households.containsKey(id)) {
            System.out.println("Household already exists");
            return;
        }
        System.out.println("Enter you name");
        String name = sc.nextLine().trim();
        System.out.println("Enter your address");
        String address = sc.nextLine().trim();

        Household household = new Household(id, name, address);
        households.put(id, household);
        System.out.println("Household registered successfully on" + household.getJoinDate());
    }
    private static void logRecyclingEvent() {
        System.out.println("Enter your household ID: ");
        String id = sc.nextLine().trim();
        Household household = households.get(id);
        if(household == null) {
            System.out.println("Household with ID " + id + " does not exist");
            return;
        }
        System.out.println("Enter the recycled material type: ");
        String materialType = sc.nextLine().trim();
        double weight = 0.0;
        while (true){
            try{
                System.out.println("Enter the recycled material weight (in kgs): ");
                weight = Double.parseDouble(sc.nextLine().trim());

                if(weight < 0) throw new IllegalArgumentException();
                break;
            }catch(IllegalArgumentException e){
                System.out.println("Invalid input. Must be a positive number");
            }
        }
        RecyclingEvent event = new RecyclingEvent(materialType,weight);
        household.addEvent(event);

        System.out.println("Recycling event logged! Points earned: " + event.getEcoPoints());
    }
    private static void displayHouseholds() {
        if(households.isEmpty()) {
            System.out.println("Households are empty");
            return;
        }
        System.out.println("Households are:");
        for(Household h : households.values()) {
            System.out.println("ID: " + h.getId() +
                    ", Name: " + h.getName() +
                    ", Address: " + h.getAddress() +
                    ", Joined: " + h.getJoinDate());
        }
    }
    private static void displayHouseholdEvents() {
        if(households.isEmpty()) {
            System.out.println("Households are empty");
            return;
        }
        System.out.println("Enter your household ID: ");
        String id = sc.nextLine().trim();
        Household household = households.get(id);
        if(household == null) {
            System.out.println("Household with ID " + id + " does not exist");
        }
        System.out.println("\nRecycling events for household " + household.getName() +": ");

        if(household.getEvents().isEmpty()) {
            System.out.println("No recycling events found");
            return;
        }else {
            for (RecyclingEvent event : household.getEvents()) {
                System.out.println(event);
            }
        }
        System.out.println("Total weight: " + household.getTotalWeight() + "kg");
        System.out.println("Total EcoPoints: " + household.getTotalPoints() + "pts");
    }
    private static void generateReports() {
        if (households.isEmpty()) {
            System.out.println("Households are empty");
            return;
        }
        Household top = null;
        for  (Household household : households.values()) {
            if(top == null || household.getTotalPoints() > top.getTotalPoints()) {
                top = household;
            }
        }
        System.out.println("\nHousehold with Highest Points:");
        System.out.println("ID: " + top.getId() +
                ", Name: " + top.getName() +
                ", Points: " + top.getTotalPoints());

        double totalWeight = 0.0;
        for(Household household : households.values()) {
            totalWeight += household.getTotalWeight();
        }
        System.out.println("Total Community Recycling Weight: " + totalWeight + " kg");
    }
    private static void saveHouseholdsToFile() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("households.ser"));
            out.writeObject(households);
        } catch (IOException e) {
            System.out.println("Error writing households.ser" + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    private static void loadHouseholdsFromFile() {
        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("households.ser"))
        ){
            households = (Map<String, Household>) in.readObject();
        }catch (FileNotFoundException e){
            System.out.println("Households file not found. Starting Fresh");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error reading households.ser" + e.getMessage());
        }

    }
}
