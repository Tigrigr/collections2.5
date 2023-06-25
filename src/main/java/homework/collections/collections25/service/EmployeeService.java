package homework.collections.collections25.service;

import homework.collections.collections25.nature.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee delEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}
