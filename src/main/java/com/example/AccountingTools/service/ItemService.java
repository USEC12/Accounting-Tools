package com.example.AccountingTools.service;

import com.example.AccountingTools.model.Item;
import com.example.AccountingTools.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id " + id));

        item.setName(itemDetails.getName());
        item.setUnit(itemDetails.getUnit());
        item.setArticle(itemDetails.getArticle());
        item.setDescription(itemDetails.getDescription());
        item.setDefaultSellingPrice(itemDetails.getDefaultSellingPrice());
        item.setInitialStockQuantity(itemDetails.getInitialStockQuantity());

        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id " + id));
        itemRepository.delete(item);
    }
}