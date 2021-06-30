package com.hcl.service;

import static org.junit.jupiter.api.Assertions.*;

import com.hcl.model.Item;
import com.hcl.repository.ItemRepository;
import com.hcl.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;


@SpringBootTest
public class ItemServiceTest {

    @MockBean
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @Test
    public void insertItemTest(){
        Item item = new Item(1L, 9.99, "test1", "", "cat", "test", 100L);
        itemService.insertItem(item);
        verify(itemRepository, times(1)).save(item);
    }

    @Test
    public void getAllItemTest(){
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, 9.99, "test1", "", "cat", "test", 100L));
        list.add(new Item(2L, 9.99, "test2", "", "cat", "test", 100L));
        list.add(new Item(3L, 9.99, "test3", "", "cat", "test", 100L));
        when(itemRepository.findAll()).thenReturn(list);
        List<Item> items = itemService.getAllItems();
        assertTrue(items.stream().anyMatch(item -> item.getName().equals("test1")));
        assertTrue(items.stream().anyMatch(item -> item.getName().equals("test2")));
        assertTrue(items.stream().anyMatch(item -> item.getName().equals("test3")));
        assertEquals(items.size(), 3);
    }

    @Test
    public void getItemByIdTest(){
        long id = 1L;
        when(itemRepository.findById(id)).thenReturn(java.util.Optional.of(
                new Item(1L, 9.99, "test1", "", "cat", "test", 100L)));
        assertEquals(itemService.getItemById(1L).getName(), "test1");
    }

    @Test
    public void updateItemTest(){
        Item item = new Item(1L, 9.99, "test1", "", "cat", "test", 100L);
        item.setName("testing");
        itemService.updateItem(item);
        verify(itemRepository, times(1)).save(item);
    }

    @Test
    public void deleteItemTest(){
        itemService.deleteItemById(1L);
        verify(itemRepository, times(1)).deleteById(1L);
    }
}
