package rest.controller;

import rest.dto.CustomerDTO;
import rest.service.custom.ManageCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/v1/customers")
@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private ManageCustomersService customersService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAllCustomers() {
        List<CustomerDTO> customers = customersService.getCustomers();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", customers.size() + "");
        return new ResponseEntity<List<CustomerDTO>>(customers, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id:C\\d{3}}")
    public ResponseEntity<CustomerDTO> findCustomer(@PathVariable("id") String customerId) {
        CustomerDTO customer = customersService.findCustomer(customerId);
        HttpStatus status = (customer !=null)? HttpStatus.OK: HttpStatus.NOT_FOUND;
        return new ResponseEntity<CustomerDTO>(customer, status);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody CustomerDTO customer) {
        customersService.createCustomer(customer);
        return customer.getId();
    }

    @DeleteMapping("/{id:C\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") String customerId) {
        customersService.deleteCustomer(customerId);
    }

    @PutMapping(value = "/{id:C\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@PathVariable("id") String customerId,
                                         @RequestBody CustomerDTO customer) {
        if (customerId.equals(customer.getId())) {
            customersService.updateCustomer(customer);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
