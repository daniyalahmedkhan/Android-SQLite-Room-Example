package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.room.Room;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.roomexample.Entities.Item;
import com.example.roomexample.Interface.ItemDAO;

import java.util.List;
import java.util.ListIterator;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button insert , update , delete , get;

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


    private void init(){

        insert = (Button) findViewById(R.id.insert);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        get = (Button) findViewById(R.id.get);


        insert.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        get.setOnClickListener(this);

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

    private void GetIttem(){

        ItemDAO itemDAO = database.getItemDAO();

       List<Item> list =  itemDAO.getItems();

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.insert:

                InsertItem();
              break;

            case R.id.update:

                UpdateItem();
              break;


            case R.id.delete:

                DeleteItem();
              break;

            case R.id.get:

                GetIttem();
             break;
        }
    }
}
