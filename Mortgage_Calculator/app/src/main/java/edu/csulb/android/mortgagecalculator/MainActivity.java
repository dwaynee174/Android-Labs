package edu.csulb.android.mortgagecalculator;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    // Declare variables
    EditText txtAmountBorrowed;
    TextView seekBarProgress;
    SeekBar seekBar;
    RadioGroup grpYear;
    RadioButton radioButton15;
    RadioButton radioButton20;
    RadioButton radioButton30;
    CheckBox chkYes;
    Button btnCal;
    TextView txtMonthlyPayment;
    TextView View;

    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        // Reading Values from Layout
        txtAmountBorrowed = (EditText) findViewById(R.id.editTextAmount);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBarProgress = (TextView) findViewById(R.id.textViewSeekbarProgress);
        grpYear = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton15 = (RadioButton) findViewById(R.id.radioButton15years);
        radioButton20 = (RadioButton) findViewById(R.id.radioButton20years);
        radioButton30 = (RadioButton) findViewById(R.id.radioButton30years);
        chkYes = (CheckBox) findViewById(R.id.checkBoxTaxes);
        btnCal = (Button) findViewById(R.id.buttonCalculate);
        txtMonthlyPayment = (TextView) findViewById(R.id.textViewDisplayPayment);

        // Initializing values for seekbar
        seekBar.setProgress(100);
        final float max = (float) 20.0;
        seekBarProgress.setText(10.0 + " / " + max);
        final float[] progress_value = new float[1];
        progress_value[0] = (float) 10.0;

        // Implementing OnSeekBarChangeListener for our seekbar
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value[0] = get_converted_value(progress);

                        seekBarProgress.setText(get_converted_value(progress) + " / " + max);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        seekBarProgress.setText(progress_value[0] + " / " + max);

                    }
                });

        // OnClickListener for Calculate Button
        btnCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Declaring variables
                int loan_term;
                float tax;

                // Validating the Amount borrowed
                if (txtAmountBorrowed.getText().length() == 0) {
                    Toast.makeText(context, "Please enter a valid Amount", duration).show();
                    return;
                }
                float Principal = Float.parseFloat(txtAmountBorrowed.getText().toString());

                // Values for loan term checkbox
                if (radioButton15.isChecked()) {
                    loan_term = 15;
                }
                else if (radioButton20.isChecked()) {
                    loan_term = 20;
                }
                else if (radioButton30.isChecked()) {
                    loan_term = 30;
                }
                else {
                    // Check if atleast one radiobutton for loan term is selected
                    Toast.makeText(context, "Please select loan Term", duration).show();
                    return;
                }
                // Calculate tax & insurance
                if (chkYes.isChecked()) {
                    tax = (float) ((Principal * 0.1) / 100);
                }
                else {
                    tax = 0;
                }
                // monthly interest calculation
                float monthly_interest = (float) (progress_value[0] / 1200.0);
                int months = loan_term * 12;

                // If No monthly interest
                if (monthly_interest == 0) {
                    txtMonthlyPayment.setText(String.valueOf(CalculatePaymentUtil.paymentWithoutInterest(Principal, months, tax)));
                }
                else {
                    // Monthly interest other than zero
                    txtMonthlyPayment.setText(String.valueOf(CalculatePaymentUtil.paymentWithInterest(Principal, months, tax, monthly_interest)));
                }
            }
        });
    }

// method to convert Float progress for seekbar
    public float get_converted_value(int progress) {
        float floatVal = (float) 0.0;
        floatVal = .1f * progress;
        return floatVal;
    }
}





