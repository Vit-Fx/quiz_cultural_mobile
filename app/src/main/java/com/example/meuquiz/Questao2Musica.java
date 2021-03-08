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

public class Questao2Musica extends AppCompatActivity {
    TextView textViewNomeMusica2;
    CheckBox checkBoxHello, checkBoxBillie, checkBoxSomeone, checkBoxThat;
    Button buttonMusicaConfirmar2;
    String nome = "";
    int qtdErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2_musica);

        textViewNomeMusica2 = findViewById(R.id.textViewNomeMusica2);
        checkBoxHello = findViewById(R.id.checkBoxHello);
        checkBoxBillie = findViewById(R.id.checkBoxBillie);
        checkBoxSomeone = findViewById(R.id.checkBoxSomeone);
        checkBoxThat = findViewById(R.id.checkBoxThat);
        buttonMusicaConfirmar2 = findViewById(R.id.buttonMusicaConfirmar2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeMusica2.setText(nome);

        buttonMusicaConfirmar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxHello.isChecked() && checkBoxSomeone.isChecked() && checkBoxBillie.isChecked() == false && checkBoxThat.isChecked() == false) {

                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao2Musica.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage("Correto!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao2Musica.this, Questao3Musica.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao2Musica.this,  Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}