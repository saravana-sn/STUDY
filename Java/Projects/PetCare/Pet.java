package Projects.PetCare;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pet implements Serializable {
    private String id;
    private String name;
    private String breed;
    private int age;
    private String ownerName;
    private String contact;
    private LocalDate regDate;
    private List<Appointment> appointments;

    public LocalDate getRegDate() {
        return regDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getContact() {
        return contact;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public LocalDate getLastVisitDate() {
        LocalDate lastDate = regDate;
        for(Appointment appointment : appointments) {
            if(appointment.getDate().isAfter(lastDate)) {
                lastDate = appointment.getDate();
            }
        }
        return lastDate;
    }

    public void getAllAppointments() {
        for(Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public Pet(String id, String name, String breed, int age, String ownerName, String contact) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.ownerName = ownerName;
        this.contact = contact;
        this.regDate = LocalDate.now();
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }
}
