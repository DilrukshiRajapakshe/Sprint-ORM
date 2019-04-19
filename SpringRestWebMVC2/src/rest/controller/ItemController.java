package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ClientResponse;
import rest.dto.ItemDTO;
import rest.dto.CustomerDTO;
import rest.service.custom.ManageCustomersService;
import rest.service.custom.ManageItemsService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    private ManageItemsService itemsService;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> findAllItems(){
        List<ItemDTO> items = itemsService.getItems();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",items.size() + "");

        return new ResponseEntity<List<ItemDTO>>(items,httpHeaders,HttpStatus.OK);
    }

    @GetMapping("/{code:I\\d{3}}")
    public ItemDTO findCustomer(@PathVariable("code") String code){
        ItemDTO item = itemsService.findItem(code);
        return item;
    }

    @DeleteMapping("/{code:I\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("code") String code){
        itemsService.deleteItem(code);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody ItemDTO itemDTO){
        itemsService.createItem(itemDTO);
        return itemDTO.getCode();
    }

    @PutMapping(value = "/{code:I\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@PathVariable("code") String code,@RequestBody ItemDTO itemDTO){
        if (code.equals(itemDTO.getCode())){
            itemsService.updateItem(itemDTO);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
