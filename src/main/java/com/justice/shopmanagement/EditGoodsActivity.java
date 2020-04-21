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

public class EditGoodsActivity extends AppCompatActivity {
    private EditText nameEdtTxt, priceEdtTxt;
    private Button submitBtn;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_goods);
        position = getIntent().getIntExtra("position", 0);
        initWidgets();
        initValues();
        setOnClickListeners();
    }

    private void initValues() {
        nameEdtTxt.setText(AllData.goodsList.get(position).getName());
        priceEdtTxt.setText(AllData.goodsList.get(position).getPrice());
    }

    private void setOnClickListeners() {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEdtTxt.getText().toString().isEmpty() || priceEdtTxt.getText().toString().isEmpty()) {
                    Toast.makeText(EditGoodsActivity.this, "Please Fill All Fields..!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                AllData.goodsList.get(position).setName(nameEdtTxt.getText().toString());
                AllData.goodsList.get(position).setPrice(priceEdtTxt.getText().toString());
                Toast.makeText(EditGoodsActivity.this, "Edit Success", Toast.LENGTH_SHORT).show();
                AllData.writeAllDataToFiles();
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
