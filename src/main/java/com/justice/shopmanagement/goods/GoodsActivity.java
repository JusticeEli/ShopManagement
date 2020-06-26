package com.justice.shopmanagement.goods;

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
import android.os.Process;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.justice.shopmanagement.AddGoodsActivity;
import com.justice.shopmanagement.FirstPageActivity;
import com.justice.shopmanagement.R;
import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.charges.ChargesActivity;
import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.out_of_stock.OutOfStockActivity;
import com.justice.shopmanagement.viewmodel.GoodsViewModel;

import java.util.ArrayList;
import java.util.List;

public class GoodsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private GoodsActivityRecyclerAdapter adapter;
    private EditText searchEdtTxt;
    private RecyclerView recyclerView;

    //////////////////DRAWER LAYOUT////////////////////////
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    //////////////////////////
    public static final int ADD_Goods_REQUEST = 1;
    public static final int EDIT_Goods_REQUEST = 2;

    public GoodsViewModel goodsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        setTitle("Goods");

        initWidgets();
        /////////////////////////////
        setOnClickListeners();
        initNavigationDrawer();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    adapter = new GoodsActivityRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);

        goodsViewModel = ViewModelProviders.of(this).get(GoodsViewModel.class);
        goodsViewModel.getAllGoods().observe(this, new Observer<List<Goods>>() {
            @Override
            public void onChanged(@Nullable List<Goods> notes) {
                adapter.submitList(notes);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                goodsViewModel.delete(adapter.getNoteAt(viewHolder.getAdapterPosition()));
                Toast.makeText(GoodsActivity.this, "Good deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_goods, menu);

        MenuItem menuItem = menu.findItem(R.id.searchItem);
        androidx.appcompat.widget.SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(listener);
        return super.onCreateOptionsMenu(menu);
    }

    SearchView.OnQueryTextListener listener=new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
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
                //Collections.sort(AllData.goodsList);
                //   goodsActivityRecyclerAdapter.setList(AllData.goodsList);


                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void setOnClickListeners() {
        FloatingActionButton buttonAddNote = findViewById(R.id.fob);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodsActivity.this, AddGoodsActivity.class);
                startActivityForResult(intent, ADD_Goods_REQUEST);
            }
        });

        /**
         *searchEdtTxt.addTextChangedListener(new TextWatcher() {
         *             @Override
         *             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
         *
         *             }
         *
         *             @Override
         *             public void onTextChanged(CharSequence s, int start, int before, int count) {
         *                 List<Goods> list = new ArrayList<>();
         *                 String name = searchEdtTxt.getText().toString();
         *                 for (Goods item : AllData.goodsList) {
         *                     if (item.getName().contains(name) && !list.contains(item)) {
         *                         list.add(item);
         *
         *                     }
         *
         *                 }
         *                 goodsActivityRecyclerAdapter.setList(list);
         *                 if (searchEdtTxt.getText().toString().isEmpty()) {
         *                     goodsActivityRecyclerAdapter.setList(AllData.goodsList);
         *                 }
         *             }
         *
         *             @Override
         *             public void afterTextChanged(Editable s) {
         *
         *             }
         *         });
         */

    }

    private void initWidgets() {
        searchEdtTxt = findViewById(R.id.searchEdtTxt);
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

    /**
     *   @Override
     *     protected void onDestroy() {
     *         Process.killProcess(Process.myPid());
     *         super.onDestroy();
     *     }
     */

}
