package com.example.meuquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao1Cinema extends AppCompatActivity {
    RadioButton radioButtonVerdadeiroCinema;
    Button buttonCinemaConfirmar1;
    int qtdErros = 0;
    TextView textViewNomeCinema;
    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao1_cinema);

        radioButtonVerdadeiroCinema = findViewById(R.id.radioButtonVerdadeiroCinema);
        buttonCinemaConfirmar1 = findViewById(R.id.buttonCinemaConfirmar1);
        textViewNomeCinema = findViewById(R.id.textViewNomeCinema);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeCinema.setText(nome);

        buttonCinemaConfirmar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonVerdadeiroCinema.isChecked()) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao1Cinema.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage("Correto!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao1Cinema.this, Questao2Cinema.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao1Cinema.this,  Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}