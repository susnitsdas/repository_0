package com.example.fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements List_frag.ItemSelected {

    TextView tvDescription;
    ArrayList<String> description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);

        description = new ArrayList<String>();
        description.add("This is description for item 1");
        description.add("This is description for item 2");
        description.add("This is description for item 3");

        if(findViewById(R.id.layout_portrait != null))
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

        if (findViewById(R.id.layout_land != null))
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {

        tvDescription.setText(description.get(index));

        if(findViewById(R.id.layout_portrait != null))
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }

    }
}
