package jp.techacademy.nanami.yeates.calcapp;

import android.content.Intent;
import android.icu.math.BigDecimal;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        Button btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);

        Button btnMult = (Button) findViewById(R.id.btnMult);
        btnMult.setOnClickListener(this);

        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        EditText etNum1 = (EditText) findViewById(R.id.editText1);
        EditText etNum2 = (EditText) findViewById(R.id.editText2);

        //入力内容を取得
        String str1 = etNum1.getText().toString();
        String str2 = etNum2.getText().toString();

        //数値に変換

        BigDecimal input1 = new BigDecimal(str1);
        BigDecimal input2 = new BigDecimal(str2);
        BigDecimal result = new BigDecimal(0);


        switch (v.getId()) {
            case R.id.btnAdd:
                result = input1.add(input2);
                break;
            case R.id.btnSub:
                result = input1.subtract(input2);
                break;
            case R.id.btnMult:
                result = input1.multiply(input2);
                break;
            case R.id.btnDiv:
                result = input1.divide(input2);
                break;
            default:
                break;
        }


        String str = result.toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE", str);
            startActivity(intent);
    }

}




