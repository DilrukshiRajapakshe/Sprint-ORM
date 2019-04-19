package rest.repository.custom.impl;

import rest.entity.Item;
import rest.repository.CrudRepositoryImpl;
import rest.repository.custom.ItemRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl extends CrudRepositoryImpl<Item, String> implements ItemRepository {

}
