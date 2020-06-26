package com.justice.shopmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.viewmodel.GoodsViewModel;

public class EditGoodsActivity extends AppCompatActivity {
    private EditText nameEdtTxt, priceEdtTxt;
    private Button submitBtn;
    private int position;
    private Goods goods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_goods);
        goods = AllData.goods;
        setTitle("Edit Goods");
        initWidgets();
        initValues();
        setOnClickListeners();
    }

    private void initValues() {
        nameEdtTxt.setText(goods.getName());
        priceEdtTxt.setText(goods.getPrice());
    }

    private void setOnClickListeners() {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEdtTxt.getText().toString().isEmpty() || priceEdtTxt.getText().toString().isEmpty()) {
                    Toast.makeText(EditGoodsActivity.this, "Please Fill All Fields..!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                goods.setName(nameEdtTxt.getText().toString());
                goods.setPrice(priceEdtTxt.getText().toString());
                GoodsViewModel goodsViewModel = ViewModelProviders.of(EditGoodsActivity.this).get(GoodsViewModel.class);
                goodsViewModel.update(goods);
                Toast.makeText(EditGoodsActivity.this, "Edit Success", Toast.LENGTH_SHORT).show();
                EditGoodsActivity.super.onBackPressed();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;

            default:
                break;
        }
        return true;
    }

    private void initWidgets() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nameEdtTxt = findViewById(R.id.nameEdtTxt);
        priceEdtTxt = findViewById(R.id.priceEdtTxt);
        submitBtn = findViewById(R.id.submitBtn);
    }
}
