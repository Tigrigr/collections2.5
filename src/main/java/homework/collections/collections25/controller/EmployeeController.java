package homework.collections.collections25.controller;

import homework.collections.collections25.exceptions.EmployeeNotFoundException;
import homework.collections.collections25.service.EmployeeServiceImp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImp employeeServiceImp;

    public EmployeeController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @GetMapping
    public String wellcome() {
        return "Здесь можно поработать с сотрудниками";
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws EmployeeNotFoundException {
        return employeeServiceImp.findEmployee(firstName, lastName).toString();
    }

    @GetMapping("/remove")
    public String delEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws EmployeeNotFoundException {
        return employeeServiceImp.delEmployee(firstName, lastName).toString();
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws EmployeeNotFoundException {
        return employeeServiceImp.addEmployee(firstName, lastName).toString();
    }
}
