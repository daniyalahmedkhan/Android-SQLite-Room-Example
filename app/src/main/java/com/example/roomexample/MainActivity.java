package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import android.widget.Toast;

import com.example.roomexample.Entities.Item;
import com.example.roomexample.Interface.ItemDAO;

import java.util.List;
import java.util.ListIterator;


public class MainActivity extends AppCompatActivity {


  //  ItemDAO itemDAO ;
  AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         database = Room.databaseBuilder(this, AppDatabase.class, "TestDB")
                .allowMainThreadQueries()
                .build();




    }



    private void InsertItem(){


        ItemDAO itemDAO = database.getItemDAO();

        Item item = new Item();
        item.setId(1);
        item.setName("Item001");
        item.setDescription("Item 001");
        item.setQuantity(500);

        itemDAO.insert(item);

    }

    private void UpdateItem(){


        ItemDAO itemDAO = database.getItemDAO();

        itemDAO.update("UPDATE DESCRIPTION TEXT" , "1");
    }

    private void DeleteItem(){

        ItemDAO itemDAO = database.getItemDAO();

        itemDAO.delete("1");

    }

    private void GetITtem(){

        ItemDAO itemDAO = database.getItemDAO();

       List<Item> list =  itemDAO.getItems();

    }

}
