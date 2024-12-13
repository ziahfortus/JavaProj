MediPlan: Personalized Health Reminder System

Overview

MediPlan is a Java-based console application designed to help users manage their medications effectively. It provides functionalities to track medication schedules, monitor progress, and get daily health reminders. The application demonstrates key Object-Oriented Programming (OOP) principles: Encapsulation, Inheritance, Polymorphism, and Abstraction.

Features

Add Medication: Record details about your medication, including name, dosage, schedule, and duration.

View All Medications: Display a list of all recorded medications with their details.

Daily Reminder: Get reminders for scheduled doses.

Mark Dose Taken/Missed: Update the status of each dose as either taken or missed.

View Progress: Track the percentage of doses successfully taken.

Delete Medication: Remove a medication record.

Get Health Tips: Receive random health tips to promote well-being.

Exit: Safely exit the application.

Installation and Usage

Prerequisites

Java Development Kit (JDK): Ensure you have JDK 8 or higher installed.

Text Editor or IDE: Use any text editor (e.g., Notepad++) or IDE (e.g., IntelliJ IDEA, Eclipse) to edit and run the program.

Steps to Run

Clone or download the program source code.

Open the code in your preferred editor or IDE.

Compile the program:

javac MediPlan.java

Run the program:

java MediPlan

Interacting with the Application

Follow the menu prompts to navigate through the program.

Input your choices and respond to prompts as directed.

Code Highlights

OOP Principles Demonstrated:

Abstraction:

HealthItem is an abstract class that defines the basic structure for health-related items.

Encapsulation:

The Medication class encapsulates the medication's attributes and provides methods to manipulate them.

Inheritance:

Medication inherits from the HealthItem class.

Polymorphism:

The displayDetails method is overridden in the Medication class to provide specific behavior.

Example Usage

Adding Medication:

Input details such as the medication name, dosage, schedule, and duration.

Viewing Progress:

The program calculates the percentage of doses taken:

public double calculateProgress() {
    int totalDoses = missedDoses + dosesTaken;
    return totalDoses == 0 ? 0 : (dosesTaken * 100.0 / totalDoses);
}

Future Enhancements

GUI Integration: Develop a graphical user interface for a more user-friendly experience.

Persistence: Save medication data to a file or database for long-term tracking.

Notification System: Add automated notifications for reminders.

Advanced Analytics: Provide detailed insights into adherence and progress trends.
