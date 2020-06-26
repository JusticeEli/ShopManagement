package com.justice.shopmanagement.charges;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.justice.shopmanagement.FirstPageActivity;
import com.justice.shopmanagement.R;
import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.goods.GoodsActivityRecyclerAdapter;
import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.goods.GoodsActivity;
import com.justice.shopmanagement.model.GoodsBuy;
import com.justice.shopmanagement.viewmodel.GoodBuyViewModel;
import com.justice.shopmanagement.viewmodel.GoodsViewModel;

import java.util.List;

public class ChargesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private TextView totalAmountTxtView;
    private RecyclerView recyclerView;
    private ChargesActivityRecyclerAdapter adapter;

    //////////////////DRAWER LAYOUT////////////////////////
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    public GoodBuyViewModel goodsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charges);
        initWidgets();
        setUpRecyclerView();

        if (!AllData.buyList.isEmpty()) {
            calculateTotalAmount();
        }
        initNavigationDrawer();
    }

    private void setUpRecyclerView() {


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new ChargesActivityRecyclerAdapter(this, this);
        recyclerView.setAdapter(adapter);

        goodsViewModel = ViewModelProviders.of(this).get(GoodBuyViewModel.class);
        goodsViewModel.getAllGoods().observe(this, new Observer<List<GoodsBuy>>() {
            @Override
            public void onChanged(@Nullable List<GoodsBuy> notes) {
                AllData.buyList = notes;
                adapter.setList(notes);
                calculateTotalAmount();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_charges, menu);
        MenuItem menuItem = menu.findItem(R.id.searchItem);
        androidx.appcompat.widget.SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(listener);
        return super.onCreateOptionsMenu(menu);
    }

    SearchView.OnQueryTextListener listener = new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            adapter.getFilter().filter(newText);

            return false;
        }
    };

    public void calculateTotalAmount() {
        int total = 0;
        for (GoodsBuy goods : AllData.buyList) {

            total += Integer.parseInt(goods.getPrice());
        }

        totalAmountTxtView.setText("$ " + total);
    }

    private void initWidgets() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        totalAmountTxtView = findViewById(R.id.totalAmountTxtView);
        recyclerView = findViewById(R.id.recyclerView);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {

            case android.R.id.home:
                super.onBackPressed();
                break;
            case R.id.clearMenu:
                goodsViewModel.deleteAllGoods();
                totalAmountTxtView.setText("$ 00");


                break;

        }
        return true;
    }

    ////////////////////////NAVIGATION DRAWER/////////////////////////////////////////////
    private void initNavigationDrawer() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.homeMenu:
                Intent intent = new Intent(this, FirstPageActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.goodsMenu:
                Intent intent1 = new Intent(this, GoodsActivity.class);
                startActivity(intent1);
                break;

            case R.id.exitMenu:
                AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("Are you Sure!!").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
        }
        DrawerLayout drawerLayout = findViewById(R.id.drawer);

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}

