package org.bootcamp.Controller;

import org.bootcamp.service.InsuranceCalculationResult;
import org.bootcamp.service.InsuranceCalculatorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class Controller {
    private final InsuranceCalculatorService service;
    public Controller(InsuranceCalculatorService service){
        this.service = service;
    }
    private static final String HELLO_MESSAGE = "<h1> Hello world</h1>";

    @GetMapping("y")
    public String sayHello(){
        return HELLO_MESSAGE;
    }

    @GetMapping(value ="/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InsuranceCalculationResult> calculateAll(){
        return service.calculateAll();
    }
    @GetMapping (value ="/calculate/(id)", produces = MediaType.APPLICATION_JSON_VALUE)
    public InsuranceCalculationResult calculateBy(@PathVariable("id") String id){
        return service.calculateById(id);
    }
    @GetMapping(value ="/calculator/higherThan", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InsuranceCalculationResult> getHigherThan(@RequestParam("max") int max){
        return service.getCostsHigherThan(max);
    }


}
