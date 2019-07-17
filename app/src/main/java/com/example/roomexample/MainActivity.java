package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import com.example.roomexample.Entities.Item;
import com.example.roomexample.Interface.ItemDAO;


public class MainActivity extends AppCompatActivity {


  //  ItemDAO itemDAO ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "TestDB")
                .allowMainThreadQueries()
                .build();

        ItemDAO itemDAO = database.getItemDAO();

        Item item = new Item();
        item.setId(1);
        item.setName("Item001");
        item.setDescription("Item 001");
        item.setQuantity(500);

        itemDAO.insert(item);
    }


}
