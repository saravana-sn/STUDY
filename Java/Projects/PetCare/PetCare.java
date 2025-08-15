package Projects.PetCare;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PetCare {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, Pet> pets = new HashMap<>();

    static void main() {
        loadPetsFromFile();
        boolean running = true;
        while (running) {
            System.out.println("Press 1 to register a new pet \n"+
                    "2 for scheduling an appointment\n"+
                    "3 for Display Records\n" +
                    "4 to generate reports\n"+
                    "5 to save and exit"
                    );
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    registerPet();
                    break;
                case "2":
                    scheduleAppointment();
                    break;
                case  "3":
                    displayRecords();
                    break;
                case  "4":
                    generateReport();
                    break;
                case  "5":
                    savePetsToFile();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadPetsFromFile(){
        try(ObjectInputStream in = new ObjectInputStream( new FileInputStream("pets.ser"))){
            pets =  (Map<String, Pet>) in.readObject();
        }catch (FileNotFoundException e){
            System.out.println("File pets.ser not found. starting fresh.");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error loading pets.ser");
        }
    }
    private static void savePetsToFile(){
        try{
            ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("pets.ser"));
            out.writeObject(pets);
            System.out.println("Saved at pets.ser successfully! GoodBye!");
        }catch (IOException e){
            System.out.println("Error saving pets.ser: " + e.getMessage());
        }
    }
    private static void registerPet(){
        System.out.println("Enter pet ID: ");
        String id = sc.nextLine().trim();
        if(pets.containsKey(id)){
            System.out.println("Pet ID " + id + " already exists");
            return;
        }
        System.out.println("Enter pet name: ");
        String name = sc.nextLine().trim();
        System.out.println("Enter pet breed: ");
        String breed = sc.nextLine().trim();
        System.out.println("Enter pet age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter pet Owner's name: ");
        String ownerName = sc.nextLine().trim();
        System.out.println("Enter pet Owner's contact: ");
        String ownerContact = sc.nextLine().trim();
        Pet pet = new Pet(id, name, breed, age, ownerName, ownerContact);
        pets.put(id, pet);
        System.out.println("Pet ID " + id + " has been registered successfully on" + pet.getRegDate());
    }
    private static void scheduleAppointment(){
        System.out.println("Enter your pet ID: ");
        String id = sc.nextLine().trim();
        Pet pet = pets.get(id);
        if(pet == null){
            System.out.println("Pet ID " + id + " does not exist");
            return;
        }
        String appointmentType = "";
        LocalDate date = null;
        LocalTime startTime = null;
        LocalTime endTime = null;
        while(true){
            try{
                System.out.println("Enter your Appointment Type: ");
                appointmentType = sc.nextLine().trim();
                if(Arrays.asList("visit","vaccination","grooming").contains(appointmentType.toLowerCase())){
                    break;
                }else throw  new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                System.out.println("Invalid appointment type. Acceptes only: visit/vaccination/grooming " + e.getMessage());
            }
        }
        while(true){
            try{
                System.out.println("Enter your Appointment Date(format:dd/MM/yyyy): ");
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String appointmentDate = sc.nextLine().trim();
                date = LocalDate.parse(appointmentDate, dateFormat);
                if(date.isBefore(LocalDate.now())) throw new IllegalArgumentException();
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Invalid date format or date is before now.");
            }catch (DateTimeParseException e){
                System.out.println("Invalid date format.");
            }
        }
        while(true){
            try{
                System.out.println("Enter your Appointment StartTime(format:HH:mm): ");
                DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
                String appointmentTime = sc.nextLine().trim();
                startTime = LocalTime.parse(appointmentTime, timeFormat);
                LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
                if(startDateTime.isBefore(LocalDateTime.now())) throw new IllegalArgumentException();
                System.out.println("Enter your Appointment EndTime(format:HH:mm): ");
                DateTimeFormatter timeFormat2 = DateTimeFormatter.ofPattern("HH:mm");
                String appointmentEndTime = sc.nextLine().trim();
                endTime = LocalTime.parse(appointmentEndTime, timeFormat2);
                if(endTime.isBefore(startTime)) throw new IllegalArgumentException();
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Invalid time format or time is before now or start time");
            }catch (DateTimeParseException e){
                System.out.println("Cant parse date. please follow the format.");
            }
        }
        System.out.println("Enter optional notes: ");
        String notes = sc.nextLine().trim();
        Appointment appointment = new Appointment(appointmentType, date, startTime, endTime);
        pet.addAppointment(appointment);
        System.out.println("Appointment has been scheduled successfully");
    }

    private static void displayRecords(){
        System.out.println("Registered Pets:");
        for(Pet p : pets.values()){
            System.out.println( p.getId()+ ": " + p.getName() + " | " + p.getBreed() + " | " + p.getAge() + " | " + p.getRegDate() +
                    " | " + p.getOwnerName() + " | " + p.getContact() );
        }

        System.out.println("Enter any pet ID to show its appointments: ");
        String id = sc.nextLine().trim();
        System.out.println("All appointments of " + pets.get(id).getName() + ":");
        pets.get(id).getAllAppointments();

        String pastAppointments = "All Past Appointments: \n";
        System.out.println("All upcoming appointments:");
        for (Pet p : pets.values()){
            System.out.println(p.getId()+ " | "+p.getName());
            pastAppointments += p.getId()+ " | "+p.getName() + "\n";
            if(!p.getAppointments().isEmpty()){
                for(Appointment a : p.getAppointments()){
                    LocalDateTime appointmentDateTime = LocalDateTime.of(a.getDate(),a.getStartTime());
                    if(appointmentDateTime.isAfter(LocalDateTime.now())){
                        System.out.println(a);
                    }else if(appointmentDateTime.isBefore(LocalDateTime.now())){
                        pastAppointments += a + "\n";
                    }
                }
            }
        }
        System.out.println(pastAppointments);
    }

    private static void generateReport(){
        String overDuePets = "Pets overdue for a vet visit:\n";
        System.out.println("Pets with upcoming appointments in the next week: ");
        for(Pet p : pets.values()){
            if (!p.getAppointments().isEmpty()){
                for (Appointment a : p.getAppointments()){
                    if(a.getDate().isAfter(LocalDate.now())  && a.getDate().isBefore(LocalDate.now().plusWeeks(1))){
                        System.out.println(p.getName());
                    }
                }
            }
            if(p.getLastVisitDate().isBefore(LocalDate.now().minusMonths(6))){
                overDuePets += p.getName() + "\n";
            }
        }
        System.out.println(overDuePets);
    }

}
