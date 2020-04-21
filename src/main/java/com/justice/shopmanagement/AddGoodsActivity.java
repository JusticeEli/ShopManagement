package com.justice.shopmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.goods.Goods;

public class AddGoodsActivity extends AppCompatActivity {
    private EditText nameEdtTxt, priceEdtTxt;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goods);
        initWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean success = false;
                if (nameEdtTxt.getText().toString().isEmpty()||priceEdtTxt.getText().toString().isEmpty()){
                    Toast.makeText(AddGoodsActivity.this, "Please Fill All Fields..!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Goods goods = new Goods();
                goods.setName(nameEdtTxt.getText().toString());
                goods.setPrice(priceEdtTxt.getText().toString());


                success = AllData.goodsList.add(goods);
                if (success) {
                    AllData.writeAllDataToFiles();
                    Toast.makeText(AddGoodsActivity.this, "Added", Toast.LENGTH_SHORT).show();
                }
                resetEdtTxt();
            }

            private void resetEdtTxt() {
                nameEdtTxt.setText("");
                priceEdtTxt.setText("");
            }
        });
    }

    private void initWidgets() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nameEdtTxt = findViewById(R.id.nameEdtTxt);
        priceEdtTxt = findViewById(R.id.priceEdtTxt);
        submitBtn = findViewById(R.id.submitBtn);
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
