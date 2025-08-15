package Projects.PetCare;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment implements Serializable {
    private String appointmentType;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String notes;

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Appointment(String appointmentType, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.appointmentType = appointmentType;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.notes = "";
    }

    @Override
    public String toString() {
        return "Appointment: " + appointmentType + " | " + date + " | " + startTime + " - " + endTime + " | " + notes;
    }
}
