package com.example.project35splitthebillapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Second extends AppCompatActivity {
    double bill;
    int number;
    double tipCost;
    double perPeopleCost;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // indicating final variable
        final EditText billCost = (EditText)findViewById(R.id.txtBill);
        final EditText numberOfPeople = (EditText)findViewById(R.id.txtNumberOfPeople);

        // create button object and generate action
        Button calculate = (Button)findViewById(R.id.btnCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {

            final TextView tip = ((TextView)findViewById(R.id.txtTip));
            final TextView billPerPeople = ((TextView)findViewById(R.id.txtBillPerPeople));
            @Override
            public void onClick(View view) {

                bill = Double.parseDouble(billCost.getText().toString());
                number = Integer.parseInt(numberOfPeople.getText().toString());
                tipCost = bill * 18 / 100;
                perPeopleCost = (bill + tipCost) / number;
                DecimalFormat currency = new DecimalFormat("S###,###.##");
                tip.setText("Tip is " + currency.format(tipCost));
                billPerPeople.setText("Bill Per People is " + currency.format(perPeopleCost));

            }
        });
    }
}
