package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.ItemDTO;
import rest.service.custom.ManageItemsService;

import java.util.List;

@RequestMapping(value = "/api/v1/items")
@CrossOrigin
@RestController
public class ItemController {

    @Autowired
    private ManageItemsService itemsService;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> findAllItems() {
        List<ItemDTO> items = itemsService.getItems();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", items.size() + "");
        return new ResponseEntity<List<ItemDTO>>(items, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{code:I\\d{3}}")
    public ResponseEntity<ItemDTO> findItem(@PathVariable("code") String code) {
        ItemDTO item = itemsService.findItem(code);
        HttpStatus status = (item !=null)? HttpStatus.OK: HttpStatus.NOT_FOUND;
        return new ResponseEntity<ItemDTO>(item, status);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody ItemDTO itemDTO) {
        itemsService.createItem(itemDTO);
        return itemDTO.getCode();
    }

    @DeleteMapping("/{code:I\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("code") String code) {
        itemsService.deleteItem(code);
    }

    @PutMapping(value = "/{code:I\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@PathVariable("code") String code,
                                         @RequestBody ItemDTO itemDTO) {
        if (code.equals(itemDTO.getCode())) {
            itemsService.updateItem(itemDTO);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
