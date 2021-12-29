// Student first name: Doan Tra Giang
// Student last name: Nguyen
// Subject code: CP3406 - Mobile Computing
// Assignment 1 - Part 1 (Utility App)

// App Purpose: This app is for converting length from one unit to another.

package au.edu.jcu.cp3406.lengthconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  TextView fromUnit;
  TextView toUnit;
  TextView displayedResult;
  EditText userInput;
  double convertResult;

  @SuppressLint("SetTextI18n")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // get unit requested by user
    fromUnit = findViewById(R.id.fromUnit);
    toUnit = findViewById(R.id.toUnit);
    // get amount given by user
    userInput = findViewById(R.id.amount);
    // get display view
    displayedResult = findViewById(R.id.result);

    if (savedInstanceState == null) {
      //set default value
      fromUnit.setText("Meter");
      toUnit.setText("Centimeter");
    } else {
      // get text from savedInstanceState
      String savedFromUnitText = savedInstanceState.getString("fromUnit");
      String savedToUnitText = savedInstanceState.getString("toUnit");
      String savedUserInputText = savedInstanceState.getString("userInput");
      String savedDisplayedResultText = savedInstanceState.getString("displayedResult");

      // set the text
      fromUnit.setText(savedFromUnitText);
      toUnit.setText(savedToUnitText);
      userInput.setText(savedUserInputText);
      displayedResult.setText(savedDisplayedResultText);
    }
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    //set text before the activity stop if screen changes
    outState.putString("fromUnit", fromUnit.getText().toString());
    outState.putString("toUnit", toUnit.getText().toString());
    outState.putString("userInput", userInput.getText().toString());
    outState.putString("displayedResult", displayedResult.getText().toString());
  }

  public void settingBtnClicked(View view) {
    Intent intent = new Intent(this, SettingActivity.class);
    startActivityForResult(intent, SettingActivity.SETTING_REQUEST);
  }

  @SuppressLint("SetTextI18n")
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    //get new strings from intent after SettingScreen
    if (requestCode == SettingActivity.SETTING_REQUEST) {
      if (resultCode == RESULT_OK) {
        String newFromUnit = data.getStringExtra("newFromUnit");
        String newToUnit = data.getStringExtra("newToUnit");

        //set new strings
        fromUnit.setText(newFromUnit);
        toUnit.setText(newToUnit);

        //reset result
        displayedResult.setText("result");
      }
    }
  }

  public void convertBtnClicked(View view) {
    String initialUnit = fromUnit.getText().toString();  // change to String for calculation()
    String resultUnit = toUnit.getText().toString();
    String amountText = userInput.getText().toString();

    try {
      double amount = Double.parseDouble(amountText);  // change amount to double for calculation()
      convertResult = Convert.calculation(initialUnit, resultUnit, amount);  // calculate
      String result = Double.toString(convertResult);
      displayedResult.setText(result);  // display result

    } catch (NumberFormatException e) {
      // run this block if user enter wrong format
      Toast toast = Toast.makeText(this, "Please enter a suitable amount!", Toast.LENGTH_SHORT);
      toast.show();
    }

  }
}

