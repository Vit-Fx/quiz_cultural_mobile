package com.example.meuquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Questao1Artes extends AppCompatActivity {
    Button buttonArtConfirmar1;
    CheckBox checkBoxLygia, checkBoxMichelangelo, checkBoxRomero;
    TextView textViewNomeArt;
    int qtdErros = 0;
    String nome = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao1_artes);

        buttonArtConfirmar1 = findViewById(R.id.buttonArtConfirmar1);
        checkBoxLygia = findViewById(R.id.checkBoxLygia);
        checkBoxMichelangelo = findViewById(R.id.checkBoxMichelangelo);
        checkBoxRomero = findViewById(R.id.checkBoxRomero);
        textViewNomeArt = findViewById(R.id.textViewNomeArt);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeArt.setText(nome);

        buttonArtConfirmar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxLygia.isChecked() && checkBoxRomero.isChecked() && checkBoxMichelangelo.isChecked() == false) {

                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao1Artes.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage("Correto!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao1Artes.this, Questao2Artes.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao1Artes.this,  Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}