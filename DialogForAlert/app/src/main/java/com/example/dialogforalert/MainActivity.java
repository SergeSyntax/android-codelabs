package com.example.dialogforalert;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
        // Set the dialog title and message.
        myAlertBuilder.setTitle(R.string.alert_title);
        myAlertBuilder.setMessage(R.string.alert_message);
        // Add the dialog buttons.
        myAlertBuilder.setPositiveButton(R.string.ok_button, (DialogInterface dialog, int which) -> {
            // User clicked OK button.
            Toast.makeText(getApplicationContext(), getString(R.string.pressed_ok_message),
                    Toast.LENGTH_SHORT).show();
        });
        myAlertBuilder.setNegativeButton(R.string.cancel_button, (DialogInterface dialog, int which) -> {
            // User cancelled the dialog.
            Toast.makeText(getApplicationContext(), getString(R.string.pressed_cancel_message),
                    Toast.LENGTH_SHORT).show();
        });
        // Create and show the AlertDialog.
        myAlertBuilder.show();
    }
}