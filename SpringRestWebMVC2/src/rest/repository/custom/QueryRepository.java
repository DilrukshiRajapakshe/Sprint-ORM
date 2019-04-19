package rest.repository.custom;

import rest.entity.CustomEntity;
import rest.repository.SuperRepository;

import java.util.List;
import java.util.Optional;

public interface QueryRepository extends SuperRepository {

    Optional<List<CustomEntity>> findOrderDetailsWithItemDescriptions(String orderId) throws Exception;

    Optional<List<CustomEntity>> findAllOrdersWithCustomerNameAndTotal() throws Exception;

}
