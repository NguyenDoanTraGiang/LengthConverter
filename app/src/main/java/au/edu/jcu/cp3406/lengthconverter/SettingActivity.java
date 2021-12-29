package au.edu.jcu.cp3406.lengthconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;

public class SettingActivity extends AppCompatActivity {
  public static int SETTING_REQUEST = 63425;
  private Spinner fromSpinner;
  private Spinner toSpinner;
  TextView newFromUnit;
  TextView newToUnit;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_setting);

    // get views of two unit labels in activity_main.xml
    newFromUnit = findViewById(R.id.fromUnit);
    newToUnit = findViewById(R.id.toUnit);

    // create spinners
    fromSpinner = findViewById(R.id.convertFromSpinner);
    toSpinner = findViewById(R.id.convertToSpinner);

    // create adapter from units list in strings.xml
    // R.layout.spinner_style refer to spinner_style.xml
    // and the spinner item will follow the format of spinner_style.xml
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, R.layout.spinner_style);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    // connect adapter to spinners
    fromSpinner.setAdapter(adapter);
    toSpinner.setAdapter(adapter);

    // set default value
    toSpinner.setSelection(2);
  }


  public void applyBtnClicked(View view) {
    String newFromUnitText = fromSpinner.getSelectedItem().toString();
    String newToUnitText = toSpinner.getSelectedItem().toString();

    // put customized units into intent so MainActivity can access it
    Intent intent = new Intent();
    intent.putExtra("newFromUnit", newFromUnitText);
    intent.putExtra("newToUnit", newToUnitText);
    setResult(RESULT_OK, intent);
    finish();
  }
}
