package com.example.roomexample.Interface;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomexample.Entities.Item;

import java.util.List;

    @Dao
    public interface ItemDAO {
    @Insert
    public void insert(Item... items);
    @Update
    public void update(Item... items);
    @Delete
    public void delete(Item item);


    @Query("SELECT * FROM items")
    public List<Item> getItems();

   }
