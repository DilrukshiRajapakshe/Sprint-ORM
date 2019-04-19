package rest.repository.custom;

import rest.entity.Order;
import rest.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {

    int count() throws Exception;

}
