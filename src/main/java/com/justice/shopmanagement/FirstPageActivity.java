package com.justice.shopmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.justice.shopmanagement.charges.ChargesActivity;
import com.justice.shopmanagement.goods.GoodsActivity;
import com.justice.shopmanagement.out_of_stock.OutOfStockActivity;

public class FirstPageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button goodsBtn, chargesBtn, outOfStockBtn,addGoodsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        initWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        goodsBtn.setOnClickListener(this);
        chargesBtn.setOnClickListener(this);
        outOfStockBtn.setOnClickListener(this);
        addGoodsBtn.setOnClickListener(this);
    }

    private void initWidgets() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        goodsBtn = findViewById(R.id.goodsBtn);
        chargesBtn = findViewById(R.id.chargesBtn);
        outOfStockBtn = findViewById(R.id.outOfStockBtn);
        addGoodsBtn = findViewById(R.id.addGoodsBtn);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.goodsBtn:

                Intent intent1 =new Intent(this, GoodsActivity.class);
                startActivity(intent1);

                break;
            case R.id.chargesBtn:
                Intent intent2 =new Intent(this, ChargesActivity.class);
                startActivity(intent2);


                break;
            case R.id.outOfStockBtn:
                Intent intent3 =new Intent(this, OutOfStockActivity.class);
                startActivity(intent3);


                break;
            case R.id.addGoodsBtn:
                Intent intent4 =new Intent(this, AddGoodsActivity.class);
                startActivity(intent4);


                break;
            default:

                break;
        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                super.onBackPressed();
                break;

        }
        return true;
    }
}
