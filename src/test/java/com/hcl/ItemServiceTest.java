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

//    @Test
//    public void testAddAndRemoveItem(){
//        itemService.insertItem(new Item(100001,));
//    }
}
