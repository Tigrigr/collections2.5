package homework.collections.collections25.service;

import homework.collections.collections25.exceptions.EmployeeAlreadyAddedException;
import homework.collections.collections25.exceptions.EmployeeNotFoundException;
import homework.collections.collections25.exceptions.EmployeeStorageIsFullException;
import homework.collections.collections25.nature.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    //константа для ограничения количества сотрудников
    final int maxEmployees = 3;

    //Лист с сотрудниками
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov")
            ));

    //Метод добавления сотрудника в лист
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        //проверяем, если не слишком ли много сотрудников, если да - кидаем эксепшн
        if (employees.size() == maxEmployees) {
            throw new EmployeeStorageIsFullException("Слишком много сотрудников.");
        }
        //проходим циклом по листу, проверяем, есть ли такой сотрудник, если да - кидаем эксепшн
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть.");
            }
        }
        //создаем новый объект с задаными полями
        Employee employee = new Employee(firstName, lastName);
        //добавляем созданного сотрудника в лист
        employees.add(employee);
        //возвращаем созданного сотрудника
        return employee;
    }

    //Метод для удаления сотрудника
    @Override
    public Employee delEmployee(String firstName, String lastName) {
        //Создаем обьект класса Employee, чтобы записать в него нужного сотрудника, если найдем. Пока кидаем туда null
        Employee delEmployee = null;
        //Проходим циклом по листу, ищем указанного сотрудника
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                //Если нашли, записываем сотрудника в обьект на удаление, прерываем цикл
                delEmployee = employee;
                break;
            }
        }
        //Проверяем, если в объекте на удаление кто-то есть - удаляем его из листа с сотрудниками
        if (delEmployee != null) {
            employees.remove(delEmployee);
        } else {
            //если никого нет, выкидываем эксепшн
            throw new EmployeeNotFoundException("Нет такого сотрудника.");
        }
        //Возвращаем из метода удаленного сотрудника
        return delEmployee;
    }

    //Метод для поиска сотрудника
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        //Проходим циклом по листу, ищем указанного сотрудника, если нашли - взвращаем из метода
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        //если не нашли - выкидываем эксепшн
        throw new EmployeeNotFoundException("Нет такого сотрудника.");
    }

}
