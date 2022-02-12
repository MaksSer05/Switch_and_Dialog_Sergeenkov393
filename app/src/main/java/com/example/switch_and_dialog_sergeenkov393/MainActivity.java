package com.example.switch_and_dialog_sergeenkov393;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox[] checkBoxes;
    EditText[] priceProduct, countProduct;
    Float[]  price;

    //  Sergeenkov Maksim393 Switch and Dialog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkBoxes = new CheckBox[4];
        priceProduct = new EditText[4];
        countProduct = new EditText[4];
        price = new Float[4];



        checkBoxes[0] = findViewById(R.id.checkBox_0);
        checkBoxes[1] = findViewById(R.id.checkBox_1);
        checkBoxes[2] = findViewById(R.id.checkBox_2);
        checkBoxes[3] = findViewById(R.id.checkBox_3);

        priceProduct[0] = findViewById(R.id.editTextNumber_0);
        priceProduct[1] = findViewById(R.id.editTextNumber_1);
        priceProduct[2] = findViewById(R.id.editTextNumber_2);
        priceProduct[3] = findViewById(R.id.editTextNumber_3);

        countProduct[0] = findViewById(R.id.editTextNumber_00);
        countProduct[1] = findViewById(R.id.editTextNumber_01);
        countProduct[2] = findViewById(R.id.editTextNumber_02);
        countProduct[3] = findViewById(R.id.editTextNumber_03);

    }


    public void onCalc(View v)
    //  Sergeenkov Maksim393 Switch and Dialog
    {
        float    q;
        double sum = 0;
        String str = "";
        for (int i = 0; i < checkBoxes.length; i++)
        {
            if (checkBoxes[i].isChecked())
            {
                if (countProduct[i].getText().toString().equals("0") || priceProduct[i].getText().toString().equals("0") || countProduct[i].getText().toString().isEmpty() || priceProduct[i].getText().toString().isEmpty())
                {
                    // sumProduct.setText("Zero value not");
                    Toast toast = Toast.makeText(getApplicationContext(), "Поле пустое, заполните пожалуйста!", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }
                price[i] = Float.parseFloat(priceProduct[i].getText().toString());
                q = Float.parseFloat(countProduct[i].getText().toString());
                sum += q * price[i];
                str += checkBoxes[i].getText() + ": " + countProduct[i].getText() + " x " + priceProduct[i].getText() + " = " + q * price[i] + " p " +"\n";
            }
        }
        sum = Math.round(sum);
        str += "Total coast: " + sum;

        Toast toast = Toast.makeText(getApplicationContext(), str , Toast.LENGTH_LONG);
        toast.show();
    }
}