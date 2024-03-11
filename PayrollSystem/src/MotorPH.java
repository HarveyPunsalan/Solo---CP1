import java.util.Scanner;

public class MotorPH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeData dataStorage = new EmployeeData();
        EmployeeDetails[] employees = dataStorage.getEmployees();

        System.out.println("==============================================");
        System.out.println("********** MotorPH Payroll System **********");
        System.out.println();
        System.out.print("Search Employee: ");
        int choice = scanner.nextInt();

        // Search for the employee with the given number
        EmployeeDetails selectedEmployee = null;
        for (EmployeeDetails employee : employees) {
            if (employee.getEmpNum().equals(String.valueOf(choice))) {
                selectedEmployee = employee;
                break;
            }
        }

        if (selectedEmployee != null) {
            displayEmployeeData(selectedEmployee);

            // Calculate hourly rate and hours worked
            double hourlyRate = selectedEmployee.getHourlyRate();
            double hoursWorked = SalaryCalculation.weeklyHours(scanner);

            // Calculate total weekly hours worked
            System.out.println("Total weekly hours: " + hoursWorked);
            // Calculate weekly salary
            double weeklySalary = SalaryCalculation.grossWeeklySalary(hoursWorked, hourlyRate);
            System.out.println("Gross weekly salary: ₱" + weeklySalary);


        } else {
            System.out.println("Employee not found.");
        }

        scanner.close();
    }

    private static void displayEmployeeData(EmployeeDetails employee) {
        System.out.println("==========================================");
        System.out.println("Employee Number     : " + employee.getEmpNum());
        System.out.println("Name                : " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Birthdate           : " + employee.getBirthdate());
        System.out.println("Address             : " + employee.getAddress());
        System.out.println("Phone Number        : " + employee.getPhoneNum());
        System.out.println("SSS Number          : " + employee.getSssNum());
        System.out.println("PhilHealth Number   : " + employee.getPhilHealthNum());
        System.out.println("TIN Number          : " + employee.getTinNum());
        System.out.println("PagIbig Number      : " + employee.getPagIbigNum());
        System.out.println("Status              : " + employee.getStatus());
        System.out.println("Position            : " + employee.getPosition());
        System.out.println("Supervisor          : " + employee.getSupervisor());
        System.out.println("Basic Salary        : " + employee.getBasicSalary());
        System.out.println("Rice Subsidy        : " + employee.getRiceSubsidy());
        System.out.println("Phone Allowance     : " + employee.getPhoneAllowance());
        System.out.println("Clothing Allowance  : " + employee.getClothingAllowance());
        System.out.println("Semi-Monthly Rate   : " + employee.getSemiMonthlyRate());
        System.out.println("Hourly Rate         : " + employee.getHourlyRate());
        System.out.println();
    }
}

