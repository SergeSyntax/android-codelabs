package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String message = "Order: " +
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);
        // Create the spinner.
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null)
            spinner.setOnItemSelectedListener(this);
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_Array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choice appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null)
            spinner.setAdapter(adapter);


        EditText editText = findViewById(R.id.phone_text);
        if (editText != null)
            editText.setOnEditorActionListener
                    (new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                            boolean handled = false;
                            if (actionId == EditorInfo.IME_ACTION_SEND) {
                                dialNumber();
                                handled = true;
                            }
                            return handled;
                        }
                        // If view is found, set the listener for editText.
                    });
    }

    private void dialNumber() {
        // Find the editText_main view.
        EditText editText = findViewById(R.id.phone_text);
        String phoneNum = null;
        // If the editText field is not null,
        // concatenate "tel: " with the phone number string.
        if (editText != null) phoneNum = "tel:" +
                editText.getText().toString();
        // Optional: Log the concatenated phone number for dialing.
        Log.d(TAG, "dialNumber: " + phoneNum);
        // Specify the intent.
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // Set the data for the intent as the phone number.
        intent.setData(Uri.parse(phoneNum));
        // If the intent resolves to a package (app),
        // start the activity with the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void onRadioButtonClicked(View view) {
        // is the button checked
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            switch (view.getId()) {
                case R.id.sameday:
                        displayToast(getString(R.string.same_day_messenger_service));
                    break;
                case R.id.nextday:
                        displayToast(getString(R.string.next_day_ground_delivery));
                    break;
                case R.id.pickup:
                        displayToast(getString(R.string.pick_up));
                    break;
                default:
                    // do nothing
                    break;
            }
        }
    }

    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        displayToast(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}