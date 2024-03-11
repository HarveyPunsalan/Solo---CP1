import java.time.LocalTime;
import java.util.Scanner;

public class SalaryCalculation {
    // Requirements #1: number of hours an employee has worked in a week.
    public static double weeklyHours(Scanner time) {
        double totalHoursWorked = 0;

        // Loop for each day of the week
        for (int day = 0; day < 5; day++) {
            System.out.print("Enter login time for day " + (day + 1) + " (HH:mm): ");

            String loginTimeStr = time.next();                                 // Read input as String
            String[] loginTimeParts = loginTimeStr.split(":");          // Split the input
            int loginHour = Integer.parseInt(loginTimeParts[0]);
            int loginMinute = Integer.parseInt(loginTimeParts[1]);
            LocalTime loginTime = LocalTime.of(loginHour, loginMinute);

            // Define work hours for the day
            LocalTime startOfWork = LocalTime.of(8, 11); // Start of workday including grace period
            LocalTime endOfWorkday = LocalTime.of(17, 0);  // End of workday

            // Adjust login time if it is before the start of the workday
            if (loginTime.isBefore(startOfWork)) {
                loginTime = startOfWork;
            }

            // Calculate the total hours worked considering late arrivals
            double minutesWorked = loginTime.until(endOfWorkday, java.time.temporal.ChronoUnit.MINUTES);
            double hoursWorked = minutesWorked / 60.0;

            // Deduct late arrival time if login time is after the grace period
            if (loginTime.isAfter(startOfWork)) {
                double lateMinutes = startOfWork.until(loginTime, java.time.temporal.ChronoUnit.MINUTES);
                double lateHours = lateMinutes / 60.0;
                hoursWorked -= lateHours;
            }

            // Ensure hours worked are not negative
            if (hoursWorked < 0) {
                hoursWorked = 0;
            }

            // Add daily hours worked to total
            totalHoursWorked += hoursWorked;
        }

        return totalHoursWorked;
    }

    // Requirements #2: Gross weekly salary of an employee based on hours worked.
    public static double grossWeeklySalary(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate;                  // Assuming no overtime pay for simplicity
    }

    // Requirements #3: Net weekly salary of an employee after applying generic deductions
    // Net Pay = Take-home pay after all earnings have been added and all taxes and other deductions have been subtracted.
}


