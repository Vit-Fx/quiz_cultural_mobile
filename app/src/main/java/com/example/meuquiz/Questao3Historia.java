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

public class Questao3Historia extends AppCompatActivity {
    RadioButton radioButtonFalsoHistoria;
    Button buttonHistoriaConfirmar3;
    TextView textViewNomeHistoria3;
    int qtdErros = 0;
    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao3_historia);

        radioButtonFalsoHistoria = findViewById(R.id.radioButtonFalsoHistoria);
        buttonHistoriaConfirmar3 = findViewById(R.id.buttonHistoriaConfirmar3);
        textViewNomeHistoria3 = findViewById(R.id.textViewNomeHistoria3);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeHistoria3.setText(nome);

        buttonHistoriaConfirmar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonFalsoHistoria.isChecked()){

                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao3Historia.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage(nome + " você errou " + qtdErros + " vezes. Obrigada por participar!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao3Historia.this, MainActivity.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao3Historia.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}