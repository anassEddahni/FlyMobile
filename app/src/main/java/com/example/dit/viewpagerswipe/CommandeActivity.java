package com.example.dit.viewpagerswipe;

import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.dit.viewpagerswipe.R.id.spinner;

public class CommandeActivity extends AppCompatActivity {
    @BindView(R.id.configuration) TextView configuration;
    @BindView(R.id.spinner_civilite) Spinner spinnerCivilité;
    @BindView(R.id.spinner_magasin) Spinner spinnerMagasin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        ButterKnife.bind(this);
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/SignPainterHouseScript.ttf");
        configuration.setTypeface(font);
        ArrayAdapter<CharSequence> adapterCivilité = ArrayAdapter.createFromResource(this,
                R.array.list_array_civilité, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterCivilité.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapterMagasin = ArrayAdapter.createFromResource(this,
                R.array.list_array_magasin, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterMagasin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerMagasin.setAdapter(adapterMagasin);
        spinnerCivilité.setAdapter(adapterCivilité);
    }
}
