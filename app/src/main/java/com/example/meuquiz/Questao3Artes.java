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

public class Questao3Artes extends AppCompatActivity {
    RadioButton radioButtonPensador;
    Button buttonArtConfirmar3;
    int qtdErros = 0;
    TextView textViewNomeArt3;
    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao3_artes);

        radioButtonPensador = findViewById(R.id.radioButtonPensador);
        buttonArtConfirmar3 = findViewById(R.id.buttonArtConfirmar3);
        textViewNomeArt3 = findViewById(R.id.textViewNomeArt3);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeArt3.setText(nome);

        buttonArtConfirmar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonPensador.isChecked()) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao3Artes.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage("Correto!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao3Artes.this, Questao4Artes.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao3Artes.this,  Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}