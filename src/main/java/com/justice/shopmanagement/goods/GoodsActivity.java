package com.justice.shopmanagement.goods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.justice.shopmanagement.AddGoodsActivity;
import com.justice.shopmanagement.FirstPageActivity;
import com.justice.shopmanagement.R;
import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.charges.ChargesActivity;
import com.justice.shopmanagement.out_of_stock.OutOfStockActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private GoodsActivityRecyclerAdapter goodsActivityRecyclerAdapter;
    private EditText searchEdtTxt;
    private RecyclerView recyclerView;

    //////////////////DRAWER LAYOUT////////////////////////
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
//////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        initWidgets();
        /////////////////////////////
        setOnClickListeners();
        initNavigationDrawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_goods, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        goodsActivityRecyclerAdapter.setList(AllData.goodsList);
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

            case R.id.chargesMenu:
                Intent intent2 = new Intent(this, ChargesActivity.class);
                startActivity(intent2);
                break;
            case R.id.sortMenu:
                Collections.sort(AllData.goodsList);
                goodsActivityRecyclerAdapter.setList(AllData.goodsList);


                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void setOnClickListeners() {
        AllData.readAllDataFromFiles();
        searchEdtTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<Goods> list = new ArrayList<>();
                String name = searchEdtTxt.getText().toString();
                for (Goods item : AllData.goodsList) {
                    if (item.getName().contains(name) && !list.contains(item)) {
                        list.add(item);

                    }

                }
                goodsActivityRecyclerAdapter.setList(list);
                if (searchEdtTxt.getText().toString().isEmpty()) {
                    goodsActivityRecyclerAdapter.setList(AllData.goodsList);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initWidgets() {
        searchEdtTxt = findViewById(R.id.searchEdtTxt);
        recyclerView = findViewById(R.id.recyclerView);
        goodsActivityRecyclerAdapter = new GoodsActivityRecyclerAdapter(this);
        recyclerView.setAdapter(goodsActivityRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        goodsActivityRecyclerAdapter.setList(AllData.goodsList);
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

            case R.id.chargesMenu:
                startActivity(new Intent(GoodsActivity.this, ChargesActivity.class));
                break;

            case R.id.outOfStockMenu:
                startActivity(new Intent(GoodsActivity.this, OutOfStockActivity.class));
                break;
            case R.id.addGoodsMenu:
                startActivity(new Intent(GoodsActivity.this, AddGoodsActivity.class));

                break;

            case R.id.aboutUsMenu:
                Toast.makeText(this, "Page Not Yet Available!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.homeMenu:
                Intent intent = new Intent(this, FirstPageActivity.class);
                startActivity(intent);
                finish();
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
                        finish();

                    }
                });
                builder.show();
                break;
        }
        DrawerLayout drawerLayout = findViewById(R.id.drawer);

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}
