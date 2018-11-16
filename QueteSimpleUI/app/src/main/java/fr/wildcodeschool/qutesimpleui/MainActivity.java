package fr.wildcodeschool.qutesimpleui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckboxClicked(View view) {
        EditText firstname = findViewById(R.id.editTextFirstname);
        EditText lastname = findViewById(R.id.editTextLastname);
        Button accept= findViewById(R.id.buttonAccept);
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            accept.setEnabled(true);
            firstname.setEnabled(true);
            lastname.setEnabled(true);
        } else {
            accept.setEnabled(false);
            firstname.setEnabled(false);
            lastname.setEnabled(false);
        }

    }

    public void onButtonClicked(View view) {
        EditText firstnameEditText = findViewById(R.id.editTextFirstname);
        EditText lastnameEditText = findViewById(R.id.editTextLastname);
        TextView congratulation = findViewById(R.id.textViewCongratulation);
        String firstname = firstnameEditText.getText().toString();
        String lastname = lastnameEditText.getText().toString();
        if ((firstname == null) || (firstname.isEmpty()) || (lastname == null) || (lastname.isEmpty())) {
            congratulation.setVisibility(View.INVISIBLE);
            Context context = getApplicationContext();
            String text = getString(R.string.errorToast);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            congratulation.setVisibility(View.VISIBLE);
            congratulation.setText(getString(R.string.congratulationTextView) +  firstname + " " + lastname);
        }

    }
}
