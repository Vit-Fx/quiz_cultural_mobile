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

public class Questao1Musica extends AppCompatActivity {
    TextView textViewNomeMusica;
    RadioButton radioButton27;
    Button buttonMusicaConfirmar1;
    String nome = "";
    int qtdErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao1_musica);

        textViewNomeMusica = findViewById(R.id.textViewNomeMusica);
        radioButton27 = findViewById(R.id.radioButton27);
        buttonMusicaConfirmar1 = findViewById(R.id.buttonMusicaConfirmar1);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeMusica.setText(nome);

        buttonMusicaConfirmar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton27.isChecked()) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao1Musica.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage("Correto!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao1Musica.this, Questao2Musica.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao1Musica.this,  Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}