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

public class Questao2Artes extends AppCompatActivity {
     RadioButton radioButtonSalvador;
     Button buttonArtConfirmar2;
     int qtdErros = 0;
     TextView textViewNomeArt2;
     String nome = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2_artes);

        radioButtonSalvador = findViewById(R.id.radioButtonSalvador);
        buttonArtConfirmar2 = findViewById(R.id.buttonArtConfirmar2);
        textViewNomeArt2 = findViewById(R.id.textViewNomeArt2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeArt2.setText(nome);

        buttonArtConfirmar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonSalvador.isChecked()) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao2Artes.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage("Correto!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao2Artes.this, Questao3Artes.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao2Artes.this,  Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}
