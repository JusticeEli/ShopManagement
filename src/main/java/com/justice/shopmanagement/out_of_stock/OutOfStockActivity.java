package com.justice.shopmanagement.out_of_stock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.justice.shopmanagement.FirstPageActivity;
import com.justice.shopmanagement.R;
import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.goods.GoodsActivity;

public class OutOfStockActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  OutOfStockRecyclerAdapter outOfStockRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_of_stock);
        initWidgets();

    }
    private void initWidgets(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=findViewById(R.id.recyclerView);
        outOfStockRecyclerAdapter=new OutOfStockRecyclerAdapter(this);
        recyclerView.setAdapter(outOfStockRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AllData.readAllDataFromFiles();
        outOfStockRecyclerAdapter.setList(AllData.outOfStockList);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_out_of_stock,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        outOfStockRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                super.onBackPressed();
                break;
            case R.id.goodsMenu:
                startActivity(new Intent(this, GoodsActivity.class));
                 break;
            case R.id.homeMenu:
                startActivity(new Intent(this, FirstPageActivity.class));
                finish();
                break;

        }
        return true;
    }
}
