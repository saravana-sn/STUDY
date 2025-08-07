package Projects.mood_tracker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoodTracker {
    public static boolean isMoodValid(Mood mood, List<Mood> moodsList) throws InvalidMoodException {
        for(Mood tempMood: moodsList)
        {
            if (tempMood.equals(mood)) {
                throw new InvalidMoodException();
            }
        }
        return true;
    }
    public static boolean deleteMood(Mood mood, List<Mood> moodsList) {
        for(Mood tempMood: moodsList){
            if (tempMood.equals(mood)) {
                moodsList.remove(tempMood);
                return true;
            }
        }
        return false;
    }
    public static boolean deleteMood(LocalDate date, List<Mood> moodsList) {
        boolean removed = false;
        for(Mood tempMood: moodsList){
            if (tempMood.getDate().equals(date)) {
                moodsList.remove(tempMood);
                removed = true;
            }
        }
        return removed;
    }

    public static boolean editMood(Mood moodToEdit, List<Mood> moodsList) {
        for(Mood tempMood: moodsList){
            if (tempMood.equals(moodToEdit)) {
                tempMood.setNotes(moodToEdit.getNotes());
            }
            return true;
        }
        return false;
    }

    public static void searchMood(Mood moodToSearch, List<Mood> moodsList) {
        boolean found = false;
        for(Mood tempMood: moodsList){
            if (tempMood.equals(moodToSearch)) {
                System.out.println(tempMood);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No such mood found");
        }

    }

    public static void searchMood(LocalDate date, List<Mood> moodsList) {
        boolean found = false;
        for(Mood tempMood: moodsList){
            if (tempMood.getDate().equals(date)) {
                System.out.println(tempMood);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No mood found for given date "+date);
        }
    }

    public static void main(String[] args) {
        List<Mood> moods = new ArrayList<Mood>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Press 'a' to add mood\n" +
                    "'d' to delete mood(s)\n" +
                    "'e' to edit mood\n" +
                    "'s' to search for moods\n" +
                    "'M' to get all moods\n" +
                    "'w' to write the moods to a file\n" +
                    "Type 'Exit' to exit");
            String menuOption = sc.nextLine();
            switch(menuOption) {
                case "a":
                    Mood moodToAdd = null;
                    System.out.println("Enter mood name");
                    String moodName = sc.nextLine();
                    System.out.println("Are you tracking mood of today? (y/n)");
                    String isForCurrentDate = sc.nextLine();
                    if(isForCurrentDate.equalsIgnoreCase("n")) {
                        try{
                            System.out.println("Enter date (dd/MM/yyyy): ");
                            String moodDateStr = sc.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, formatter);
                            System.out.println("Enter time (HH:mm:ss): ");
                            String moodTimeStr = sc.nextLine();
                            LocalTime moodTime = LocalTime.parse(moodTimeStr, formatter);
                            System.out.println("Add some notes: ");
                            String moodNotes = sc.nextLine();
                            if(moodNotes.strip().equalsIgnoreCase("")) {
                                moodToAdd = new Mood(moodName, moodDate, moodTime);
                            }else {
                                moodToAdd = new Mood(moodName, moodDate, moodTime, moodNotes);
                            }
                        }catch (DateTimeParseException e){
                            System.out.println("Invalid date format");
                            continue;
                        }
                    }else{
                        System.out.println("Add some notes: ");
                        String moodNotes = sc.nextLine();
                        if(moodNotes.strip().equalsIgnoreCase("")) {
                            moodToAdd = new Mood(moodName);
                        }else {
                            moodToAdd = new Mood(moodName, moodNotes);
                        }
                    }
                    try{
                        boolean isValid = isMoodValid(moodToAdd, moods);
                        if(isValid) {
                            moods.add(moodToAdd);
                            System.out.println("Mood added successfully");
                        }
                        continue;
                    }catch (InvalidMoodException e) {
                        System.out.println("Invalid mood. Already a mood Exists for this DateTime!");
                    }
                    continue;
                case "d":
                    System.out.println("Enter '1' to delete all moods by date\n"+
                                        "Enter '2' to delete a specific mood");
                    String deleteType = sc.nextLine();
                    if(deleteType.equalsIgnoreCase("1")) {
                        try{
                            System.out.println("Enter date (dd/MM/yyyy): ");
                            String moodDateStr = sc.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, formatter);
                            if(deleteMood(moodDate, moods)) {
                                System.out.println("Mood deleted successfully");
                            }else {
                                System.out.println("No such mood");
                            }
                        }catch (DateTimeParseException e){
                            System.out.println("Invalid date format");
                            continue;
                        }
                    } else if (deleteType.equalsIgnoreCase("2")) {
                        try{
                            System.out.println("Enter mood name: ");
                            String moodNameStr = sc.nextLine();
                            System.out.println("Enter mood date (dd/MM/yyyy): ");
                            String moodDateStr = sc.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, formatter);
                            System.out.println("Enter mood time (HH:mm:ss): ");
                            String moodTimeStr = sc.nextLine();
                            LocalTime moodTime = LocalTime.parse(moodTimeStr, formatter);
                            Mood delMood = new Mood(moodNameStr, moodDate, moodTime);
                            boolean isDeleted = deleteMood(delMood, moods);
                            if(isDeleted) {
                                System.out.println("Mood deleted successfully");
                            }else {
                                System.out.println("No such mood");
                            }
                        }catch (DateTimeParseException e){
                            System.out.println("Invalid date or time format");
                            continue;
                        }
                    }
                    continue;
                case "e":
                    Mood moodToEdit = null;
                    try{
                        System.out.println("Enter mood name: ");
                        String moodNameStr = sc.nextLine();
                        System.out.println("Enter mood date (dd/MM/yyyy): ");
                        String moodDateStr = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate moodDate = LocalDate.parse(moodDateStr, formatter);
                        System.out.println("Enter mood time (HH:mm:ss): ");
                        String moodTimeStr = sc.nextLine();
                        LocalTime moodTime = LocalTime.parse(moodTimeStr, formatter);
                        System.out.println("Add some new notes: ");
                        String moodNotes = sc.nextLine();
                        if(moodNotes.strip().equalsIgnoreCase("")) {
                            System.out.println("Empty notes. skipping...");
                            continue;
                        }else{
                            moodToEdit = new Mood(moodNameStr, moodDate, moodTime, moodNotes.strip());
                            boolean isMoodEdited = editMood(moodToEdit, moods);
                            if(isMoodEdited) {
                                System.out.println("Mood edited successfully");
                            }else {
                                System.out.println("No such mood");
                            }
                        }
                    }catch (DateTimeParseException e){
                        System.out.println("Invalid date or time format");
                        continue;
                    }
                    continue;
                case "s":
                    System.out.println("Enter '1' to search all moods by date\n"+
                                        "Enter '2' to search a specific mood");
                    String searchType = sc.nextLine();
                    if(searchType.equalsIgnoreCase("1")) {
                        try{
                            System.out.println("Enter date (dd/MM/yyyy): ");
                            String moodDateStr = sc.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, formatter);
                            searchMood(moodDate, moods);
                        }catch (DateTimeParseException e){
                            System.out.println("Invalid date format");
                            continue;
                        }
                    } else if (searchType.equalsIgnoreCase("2")) {
                        try{
                            System.out.println("Enter mood name: ");
                            String moodNameStr = sc.nextLine();
                            System.out.println("Enter mood date (dd/MM/yyyy): ");
                            String moodDateStr = sc.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, formatter);
                            System.out.println("Enter mood time (HH:mm:ss): ");
                            String moodTimeStr = sc.nextLine();
                            LocalTime moodTime = LocalTime.parse(moodTimeStr, formatter);
                            searchMood(new Mood(moodNameStr, moodDate, moodTime), moods);
                        }catch (DateTimeParseException e){
                            System.out.println("Invalid date or time format");
                            continue;
                        }
                    }
                    continue;
                case "M":
                    for(Mood moodObj: moods) {
                        System.out.println(moodObj);
                    }
                    continue;
                case "w":
                    try (PrintWriter writer = new PrintWriter(new FileWriter("Moods.txt"))) {
                        for (Mood mood : moods) {
                            writer.println(mood+"\n\n");
                        }
                        System.out.println("The entries are written to a file");
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }
                    continue;
                case "Exit": 	System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    break;
                default: 	System.out.println("Not a valid input!");
                    continue;
            }
            break;
        }
    }
}
