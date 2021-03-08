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

public class Questao1Historia extends AppCompatActivity {
    TextView textViewNomeHistoria;
    Button buttonHistoriaConfirmar1;
    RadioButton radioButton1500;
    int qtdErros = 0;
    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao1_historia);

        textViewNomeHistoria = findViewById(R.id.textViewNomeHistoria);
        buttonHistoriaConfirmar1 = findViewById(R.id.buttonHistoriaConfirmar1);
        radioButton1500 = findViewById(R.id.radioButton1500);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");


        textViewNomeHistoria.setText(nome);

        buttonHistoriaConfirmar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton1500.isChecked()) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao1Historia.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage("Correto!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao1Historia.this, Questao2Historia.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao1Historia.this,  Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}