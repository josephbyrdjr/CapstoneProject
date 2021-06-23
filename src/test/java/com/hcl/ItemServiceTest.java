package com.hcl;

import static org.junit.jupiter.api.Assertions.*;

import com.hcl.model.Item;
import com.hcl.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ItemServiceTest {



    @Autowired
    ItemService itemService;



    @Test
    public void testAutowired(){
        assertNotNull(itemService);
    }

    @Test
    public void testItemCrud(){
        itemService.insertItem(new Item(9.99,"testItem1","", "test", "test Item"));
        long id = itemService.getItemByName("testItem1").getId();
        assertTrue(itemService.getAllItems().stream().anyMatch(i -> i.getName().equals("testItem1")));
        Item item = itemService.getItemById(id);
        item.setName("testItem2");
        itemService.updateItem(item);
        assertTrue(itemService.getAllItems().stream().anyMatch(i -> i.getName().equals("testItem2")));
        itemService.deleteItemById(id);
        assertTrue(itemService.getAllItems().stream().noneMatch(i -> i.getName().equals("testItem2")));
    }


}
