package com.hcl;

import static org.junit.jupiter.api.Assertions.*;

import com.hcl.model.Item;
import com.hcl.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;


@SpringBootTest
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @BeforeEach
    public void init(){
        itemService.insertItem(new Item(1, 9.99, "test1", "", "cat", "test item"));
        itemService.insertItem(new Item(2, 9.99, "test2", "", "cat", "test item"));
        itemService.insertItem(new Item(3, 9.99, "test3", "", "cat", "test item"));
    }

    @Test
    public void getAllItemTest(){
        List<Item> items = itemService.getAllItems();
        assertTrue(items.stream().anyMatch(item -> item.getName().equals("test1")));
        assertTrue(items.stream().anyMatch(item -> item.getName().equals("test2")));
        assertTrue(items.stream().anyMatch(item -> item.getName().equals("test3")));
        assertEquals(items.size(), 3);
    }

    @Test
    public void getItemByIdTest(){
        assertEquals(itemService.getItemById(1L).getName(), "test1");
    }

    @Test
    public void updateItemTest(){
        Item item = itemService.getItemById(1L);
        item.setName("testing");
        itemService.updateItem(item);
        assertEquals(itemService.getItemById(1L).getName(),"testing");
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deleteItemTest(){
        itemService.deleteItemById(1L);
        assertEquals(itemService.getAllItems().size(), 2);
        assertFalse(itemService.getAllItems().stream().anyMatch(item -> item.getName().equals("test1")));
    }
}
