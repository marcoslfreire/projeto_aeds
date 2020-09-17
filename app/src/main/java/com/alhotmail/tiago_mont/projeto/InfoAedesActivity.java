package com.alhotmail.tiago_mont.projeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoAedesActivity extends AppCompatActivity {


    private Button buttonSimulador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_aedes);

        buttonSimulador = (Button) findViewById(R.id.buttonSimu);

        buttonSimulador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(InfoAedesActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}

