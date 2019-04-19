package rest.repository.custom.impl;

import rest.entity.Customer;
import rest.repository.CrudRepositoryImpl;
import rest.repository.custom.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl extends CrudRepositoryImpl<Customer, String> implements CustomerRepository {

}
