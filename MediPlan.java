import java.util.ArrayList;
import java.util.Scanner;

// Abstract Class (Abstraction)
abstract class HealthItem {
    private String name;

    public HealthItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}

// Medication Class (Encapsulation, Inheritance, Polymorphism)
class Medication extends HealthItem {
    private String dosage;
    private String schedule; // e.g., Morning, Noon, Evening
    private int duration; // in days
    private int missedDoses;
    private int dosesTaken;

    public Medication(String name, String dosage, String schedule, int duration) {
        super(name);
        this.dosage = dosage;
        this.schedule = schedule;
        this.duration = duration;
        this.missedDoses = 0;
        this.dosesTaken = 0;
    }

    public String getDosage() {
        return dosage;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getDuration() {
        return duration;
    }

    public int getMissedDoses() {
        return missedDoses;
    }

    public int getDosesTaken() {
        return dosesTaken;
    }

    public void incrementMissedDoses() {
        missedDoses++;
    }

    public void incrementDosesTaken() {
        dosesTaken++;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Dosage: " + dosage);
        System.out.println("Schedule: " + schedule);
        System.out.println("Duration: " + duration + " days");
        System.out.println("Missed Doses: " + missedDoses);
        System.out.println("Doses Taken: " + dosesTaken);
    }

    public double calculateProgress() {
        int totalDoses = missedDoses + dosesTaken;
        return totalDoses == 0 ? 0 : (dosesTaken * 100.0 / totalDoses);
    }
}

// Main Class
public class MediPlan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Medication> medications = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- MediPlan: Personalized Health Reminder System ---");
            System.out.println("1. Add Medication");
            System.out.println("2. View All Medications");
            System.out.println("3. Daily Reminder");
            System.out.println("4. Mark Dose Taken/Missed");
            System.out.println("5. View Progress");
            System.out.println("6. Delete Medication");
            System.out.println("7. Get Health Tips");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Medication Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Dosage (e.g., 500mg): ");
                    String dosage = scanner.nextLine();
                    System.out.print("Enter Schedule (e.g., Morning, Noon, Evening): ");
                    String schedule = scanner.nextLine();
                    System.out.print("Enter Duration (in days): ");
                    int duration = scanner.nextInt();
                    medications.add(new Medication(name, dosage, schedule, duration));
                    System.out.println("Medication added successfully!");
                    break;

                case 2:
                    if (medications.isEmpty()) {
                        System.out.println("No medications found.");
                    } else {
                        System.out.println("\n--- All Medications ---");
                        for (Medication med : medications) {
                            med.displayDetails();
                            System.out.println("---------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Daily Reminder ---");
                    if (medications.isEmpty()) {
                        System.out.println("No medications scheduled.");
                    } else {
                        for (Medication med : medications) {
                            System.out.println("Reminder: Take " + med.getDosage() + " of " + med.getName() + " (" + med.getSchedule() + ")");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Medication Name: ");
                    String medName = scanner.nextLine();
                    Medication med = findMedicationByName(medications, medName);
                    if (med != null) {
                        System.out.print("Did you take the dose? (yes/no): ");
                        String response = scanner.nextLine().toLowerCase();
                        if (response.equals("yes")) {
                            med.incrementDosesTaken();
                            System.out.println("Dose marked as taken.");
                        } else if (response.equals("no")) {
                            med.incrementMissedDoses();
                            System.out.println("Dose marked as missed.");
                        } else {
                            System.out.println("Invalid response.");
                        }
                    } else {
                        System.out.println("Medication not found.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Progress Tracker ---");
                    for (Medication m : medications) {
                        System.out.printf("Medication: %s, Progress: %.2f%%\n", m.getName(), m.calculateProgress());
                    }
                    break;

                case 6:
                    System.out.print("Enter Medication Name to Delete: ");
                    String deleteName = scanner.nextLine();
                    Medication toDelete = findMedicationByName(medications, deleteName);
                    if (toDelete != null) {
                        medications.remove(toDelete);
                        System.out.println("Medication deleted successfully!");
                    } else {
                        System.out.println("Medication not found.");
                    }
                    break;

                case 7:
                    String[] healthTips = {
                        "Drink plenty of water to stay hydrated.",
                        "Exercise for at least 30 minutes daily.",
                        "Get 7-8 hours of sleep every night.",
                        "Eat a balanced diet with fruits and vegetables.",
                        "Practice mindfulness or meditation to reduce stress."
                    };
                    int randomIndex = (int) (Math.random() * healthTips.length);
                    System.out.println("Health Tip: " + healthTips[randomIndex]);
                    break;

                case 8:
                    System.out.println("Exiting MediPlan. Stay healthy!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }

    // Helper method to find a medication by name
    private static Medication findMedicationByName(ArrayList<Medication> medications, String name) {
        for (Medication med : medications) {
            if (med.getName().equalsIgnoreCase(name)) {
                return med;
            }
        }
        return null;
    }
}
