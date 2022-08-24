package com.justice.shopmanagement.out_of_stock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.justice.shopmanagement.R;
import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.model.GoodsOutOfStock;
import com.justice.shopmanagement.viewmodel.GoodsOutOfStockViewModel;

import java.util.List;

public class OutOfStockActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  OutOfStockRecyclerAdapter adapter;
    public GoodsOutOfStockViewModel goodsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_of_stock);
        initWidgets();
        setUpRecyclerView();

    }

    private void setUpRecyclerView() {


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    adapter = new OutOfStockRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);

        goodsViewModel = ViewModelProviders.of(this).get(GoodsOutOfStockViewModel.class);
        goodsViewModel.getAllGoods().observe(this, new Observer<List<GoodsOutOfStock>>() {
            @Override
            public void onChanged(@Nullable List<GoodsOutOfStock> notes) {
                AllData.outOfStockList = notes;

                adapter.setList(notes);
            }
        });


    }
    private void initWidgets(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_out_of_stock,menu);
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
        switch (item.getItemId()) {

            case android.R.id.home:
                super.onBackPressed();
                break;
            case R.id.goodsMenu:
              //  startActivity(new Intent(this, GoodsActivity.class));
                 break;
            case R.id.homeMenu:
             //   startActivity(new Intent(this, FirstPageActivity.class));
                finish();
                break;

        }
        return true;
    }
}
