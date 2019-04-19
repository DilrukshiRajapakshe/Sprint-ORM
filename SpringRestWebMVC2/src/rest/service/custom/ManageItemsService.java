package rest.service.custom;

import rest.service.SuperService;
import rest.dto.ItemDTO;
import rest.service.SuperService;

import java.util.List;

public interface ManageItemsService extends SuperService {

    List<ItemDTO> getItems();

    void createItem(ItemDTO dto);

    void updateItem(ItemDTO dto);

    void deleteItem(String code);

    ItemDTO findItem(String code);


}
