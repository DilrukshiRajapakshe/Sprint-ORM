package rest.repository.custom;

import rest.entity.OrderDetail;
import rest.entity.OrderDetailPK;
import rest.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailPK> {

    Optional<List<OrderDetail>> find(String orderId) throws Exception;

}
