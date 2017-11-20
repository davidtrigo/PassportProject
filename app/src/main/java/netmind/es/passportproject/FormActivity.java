package netmind.es.passportproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    // Persistencia Datos SharedPreference
    private final static String SHARED_PREFERENCES = "MisPreferencias";
    private final static String TXT_NOMBRE = "txtNombre";

    // Datos del formulario
    private String nombre = "", apellidos = "";
    private int spinnerSelection = 0;
    private boolean checkBoxState = false;

    // Views UI
    private EditText txtNombre, txtApellido;
    private Spinner spinner;
    private CheckBox cbSuperHero;
    private Button btnSave, btnLoad, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
    }

    private void initLayout() {
        Log.d(FormActivity.class.getSimpleName(), "initLayout");
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        spinner = findViewById(R.id.spinner);
        cbSuperHero = findViewById(R.id.cbSuperHero);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    private void clearLayout() {
        // Empty views data
        nombre = "";
        apellidos = "";
        spinnerSelection = 0;
        checkBoxState = false;
        initLayoutData();

        txtNombre.setText(nombre);
        txtApellido.setText(apellidos);
        spinner.setSelection(spinnerSelection);
        cbSuperHero.setChecked(checkBoxState);
    }

    private void saveData() {
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Texto edittext
        nombre = txtNombre.getText().toString();
        editor.putString("txtNombre", nombre);

        apellidos = txtApellido.getText().toString();
        editor.putString("txtApellido", apellidos);

        // Spinner posición
        spinnerSelection = spinner.getSelectedItemPosition();
        editor.putInt("spinner", spinnerSelection);

        // Booleano del chekbox
        checkBoxState = cbSuperHero.isChecked();
        editor.putBoolean("cbSuperHero", checkBoxState);

        editor.apply();
        finish();
    }

    private void loadData() {
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

        nombre = sharedPreferences.getString("txtNombre", "");
        apellidos = sharedPreferences.getString("txtApellido", "");
        spinnerSelection = sharedPreferences.getInt("spinner", 0);
        checkBoxState = sharedPreferences.getBoolean("cbSuperHero", false);

        initLayoutData();
    }

    private void initLayoutData() {
        txtNombre.setText(nombre);
        txtApellido.setText(apellidos);
        spinner.setSelection(spinnerSelection);
        cbSuperHero.setChecked(checkBoxState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveData();
                break;
            case R.id.btnLoad:
                loadData();
                break;
            case R.id.btnDelete:
                deleteSavedData();
                break;
        }
    }

    private void deleteSavedData() {
        // Delete SharedPrefences data
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("txtNombre");
        editor.remove("txtApellido");
        editor.remove("spinner");
        editor.remove("cbSuperHero");
        editor.apply();

clearLayout();
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//    }
}
