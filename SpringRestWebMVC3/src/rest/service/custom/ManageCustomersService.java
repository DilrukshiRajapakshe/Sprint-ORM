package rest.service.custom;

import rest.dto.CustomerDTO;
import rest.service.SuperService;

import java.util.List;

public interface ManageCustomersService extends SuperService {

    List<CustomerDTO> getCustomers();

    void createCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void deleteCustomer(String customerID);

    CustomerDTO findCustomer(String id);


}
