package References.SecondTask;

enum Employment {
    FULL_TIME, PART_TIME, CONTRACT;

    boolean checkEmployeerEmployment(Employee employee) {
        return this == employee.getEmployment();
    }
}
