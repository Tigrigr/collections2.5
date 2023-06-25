package homework.collections.collections25.controller;

import homework.collections.collections25.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    private final Service service;

    public controller(Service service) {
        this.service = service;
    }

    @GetMapping("/employee")
    public String wellcome() {
        return "Здесь можно поработать с сотрудниками";
    }
}
