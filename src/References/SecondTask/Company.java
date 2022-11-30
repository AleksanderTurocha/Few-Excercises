package References.SecondTask;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Company {
    public static void main(String[] args) {
        List<Employee> employees = createEmployees();
        //10% podwyżki dla pracowników zatrudnionych na pełen etat
        addBonusToFullTimeEmployees(employees);
        //liczba pracowników etatowych
        double fullTimeEmployeesNumber = countEmployeesByEmployment(employees, Employment.FULL_TIME);

        System.out.println("Liczba pracowników zatrudnionych na pełen etat: " + fullTimeEmployeesNumber);
        System.out.println("Oto oni:");
        employees.stream().filter(Employment.FULL_TIME::checkEmployeerEmployment)
                .forEach(System.out::println);

        employeeWithLongestName(employees)
                .ifPresent(Company::showLongestEmployee);
    }

    private static void showLongestEmployee(String emp) {
        System.out.println("Pracownik o najdłuższym imieniu i nazwisku to " + emp);
    }

    private static Optional<String> employeeWithLongestName(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getFullName)
                .max(Comparator.comparingInt(String::length));
    }

    private static long countEmployeesByEmployment(List<Employee> employees, Employment employment) {
        return employees.stream()
                .filter(employment::checkEmployeerEmployment)
                .count();
    }

    private static void addBonusToFullTimeEmployees(List<Employee> employees) {
        employees.stream()
                .filter(Employment.FULL_TIME::checkEmployeerEmployment)
                .forEach(Company::increaseEmployeeSalaryBy10Percent);
    }

    private static void increaseEmployeeSalaryBy10Percent(Employee employee) {
        employee.setSalary(employee.getSalary() * 1.1);
    }

    private static List<Employee> createEmployees() {
        return List.of(
                new Employee("Jan", "Kowalski", 4000, Employment.FULL_TIME),
                new Employee("Marta", "Baczewska", 3900, Employment.FULL_TIME),
                new Employee("Karol", "Piotrowicz", 5800, Employment.CONTRACT),
                new Employee("Anna", "Lubicz", 6000, Employment.PART_TIME),
                new Employee("Wojciech", "Kozłowski", 3500, Employment.PART_TIME),
                new Employee("Paweł", "Kowalski", 8000, Employment.FULL_TIME),
                new Employee("Adam", "Marchwicki", 300, Employment.CONTRACT)
        );
    }
}
