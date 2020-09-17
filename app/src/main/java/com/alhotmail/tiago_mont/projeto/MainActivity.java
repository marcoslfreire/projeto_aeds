package com.alhotmail.tiago_mont.projeto;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    Spinner dorCabec;
    Spinner dorArtic;
    Spinner febre;
    Spinner dorMusc;
    Spinner coceira;
    Spinner inc_art;
    Spinner mancha;
    Spinner conjunt;
    Spinner manif_hemo;
    private Button Result;
    private TextView edtResult;
    private int contD = 0, contZ=0, contC=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dorCabec = (Spinner) findViewById(R.id.spinCab);

        dorArtic = (Spinner) findViewById(R.id.spinArt);

        febre = (Spinner) findViewById(R.id.spinFeb);

        dorMusc = (Spinner) findViewById(R.id.spinMuc);

        coceira = (Spinner) findViewById(R.id.spinCoc);

        inc_art = (Spinner) findViewById(R.id.spinInArt);

        mancha = (Spinner) findViewById(R.id.spinMhc);

        conjunt = (Spinner) findViewById(R.id.spinConj);

        manif_hemo = (Spinner) findViewById(R.id.spinManhemo);

        construirCampos();


        Result = (Button) findViewById(R.id.btnResult);

        Result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int op = dorCabec.getSelectedItemPosition();

                switch (op){

                    case 1:

                        contC++;
                        contZ++;
                        break;

                    case 2:

                        contD++;
                        break;

                }

                int op1 = dorArtic.getSelectedItemPosition();

                switch (op1){

                    case 1:

                        contD++;

                    case 2:

                        contZ++;
                        contC++;

                    case 3:

                        contC++;


                }

                int op2 = febre.getSelectedItemPosition();

                switch (op2){

                    case 1:

                        contZ++;

                    case 2:

                        contD++;

                        contC++;

                }

                int op3 = dorMusc.getSelectedItemPosition();

                switch (op3){

                    case 1:

                        contZ++;

                    case 2:

                        contD++;

                        contC++;


                }

                int op4 = coceira.getSelectedItemPosition();

                switch (op4){

                    case 1:

                        contD++;

                        contC++;

                    case 2:

                        contZ++;

                    case 3:

                        contZ++;

                }

                int op5 = inc_art.getSelectedItemPosition();

                switch (op5){

                    case 1:

                        contZ++;

                    case 2:

                        contC++;

                    case 3:

                        contC++;

                    case 4:

                        contD++;

                }

                int op6 = mancha.getSelectedItemPosition();

                switch (op6){

                    case 1:

                        contZ++;

                    case 2:

                        contC++;

                    case 3:

                        contD++;

                }

                int op7 = conjunt.getSelectedItemPosition();

                switch (op7){

                    case 1:

                        contZ++;

                        contC++;

                    case 2:

                        contD++;

                }

                int op8 = manif_hemo.getSelectedItemPosition();

                switch (op8) {

                    case 1:

                        contC++;


                    case 2:

                        contD++;

                    case 3:

                        contZ++;

                }

                if ((contD > contZ) && (contD > contC)){

                    int Dengue = (contD*100)/10;
                    int Zika = (contZ*100)/10;
                    int chikungunya = (contZ*100)/10;

                    AlertDialog.Builder dialogD = new AlertDialog.Builder(MainActivity.this);
                    dialogD.setTitle("Resultado dos Sintomas:");
                    dialogD.setMessage("Dengue: " + Dengue + "%");

                    AlertDialog.Builder dialogZ = new AlertDialog.Builder(MainActivity.this);
                    dialogZ.setMessage("Zika: " + Zika + "%");

                    AlertDialog.Builder dialogC = new AlertDialog.Builder(MainActivity.this);
                    dialogC.setTitle("Resultado");
                    dialogC.setMessage("Chikungunya: "+chikungunya+"%");

                    dialogD.setNeutralButton("OK", null);
                    dialogD.show();

                } else if ((contZ > contD) && (contZ > contC)){

                    int Zika = (contZ*100)/10;
                    int Dengue = (contD*100)/10;
                    int chikungunya = (contZ*100)/10;

                    AlertDialog.Builder dialogZ = new AlertDialog.Builder(MainActivity.this);
                    dialogZ.setTitle("Resultado dos Sintomas:");
                    dialogZ.setMessage("Zika: "+Zika+"%");

                    AlertDialog.Builder dialogD = new AlertDialog.Builder(MainActivity.this);
                    dialogD.setTitle("Resultado dos Sintomas:");
                    dialogD.setMessage("Dengue: " + Dengue + "%");

                    AlertDialog.Builder dialogC = new AlertDialog.Builder(MainActivity.this);
                    dialogC.setTitle("Resultado");
                    dialogC.setMessage("Chikungunya: "+chikungunya+"%");

                    dialogZ.setNeutralButton("OK", null);
                    dialogZ.show();

                } else if ((contC > contD) && (contC > contZ)){

                    int chikungunya = (contZ*100)/10;
                    int Dengue = (contD*100)/10;
                    int Zika = (contZ*100)/10;

                    AlertDialog.Builder dialogC = new AlertDialog.Builder(MainActivity.this);
                    dialogC.setTitle("Resultado dos Sintomas:");
                    dialogC.setMessage("Chikungunya: "+chikungunya+"%");

                    AlertDialog.Builder dialogZ = new AlertDialog.Builder(MainActivity.this);
                    dialogZ.setTitle("Resultado dos Sintomas:");
                    dialogZ.setMessage("Zika: "+Zika+"%");

                    AlertDialog.Builder dialogD = new AlertDialog.Builder(MainActivity.this);
                    dialogD.setTitle("Resultado dos Sintomas:");
                    dialogD.setMessage("Dengue: " + Dengue + "%");

                    dialogC.setNeutralButton("OK", null);
                    dialogC.show();

                }


                contD = 0;

                contZ = 0;

                contC = 0;

                construirCampos();

                }
        });

    }

    private void construirCampos(){

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.dor_cabec, android.R.layout.simple_spinner_item);
        dorCabec.setAdapter(adapter1);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.dor_artic, android.R.layout.simple_spinner_item);
        dorArtic.setAdapter(adapter2);

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.febre, android.R.layout.simple_spinner_item);
        febre.setAdapter(adapter3);

        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this, R.array.dor_musc, android.R.layout.simple_spinner_item);
        dorMusc.setAdapter(adapter4);

        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this, R.array.coceira, android.R.layout.simple_spinner_item);
        coceira.setAdapter(adapter5);

        ArrayAdapter adapter6 = ArrayAdapter.createFromResource(this, R.array.inc_art , android.R.layout.simple_spinner_item);
        inc_art.setAdapter(adapter6);

        ArrayAdapter adapter7 = ArrayAdapter.createFromResource(this, R.array.manchas , android.R.layout.simple_spinner_item);
        mancha.setAdapter(adapter7);

        ArrayAdapter adapter8 = ArrayAdapter.createFromResource(this, R.array.conjuntivite , android.R.layout.simple_spinner_item);
        conjunt.setAdapter(adapter8);

        ArrayAdapter adapter9 = ArrayAdapter.createFromResource(this, R.array.manifest_hemorrag, android.R.layout.simple_spinner_item);
        manif_hemo.setAdapter(adapter9);


        }

}

