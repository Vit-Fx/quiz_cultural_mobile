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

public class Questao4Artes extends AppCompatActivity {
    TextView textViewNomeArt4;
    Button buttonArtConfirmar4;
    CheckBox checkBoxComedores, checkBoxAmendoeira, checkBoxBarqueiros, checkBoxNoite;
    String nome = "";
    int qtdErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao4_artes);

        textViewNomeArt4 = findViewById(R.id.textViewNomeArt4);
        buttonArtConfirmar4 = findViewById(R.id.buttonArtConfirmar4);
        checkBoxComedores = findViewById(R.id.checkBoxComedores);
        checkBoxAmendoeira = findViewById(R.id.checkBoxAmendoeira);
        checkBoxBarqueiros = findViewById(R.id.checkBoxBarqueiros);
        checkBoxNoite = findViewById(R.id.checkBoxNoite);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeArt4.setText(nome);

        buttonArtConfirmar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxComedores.isChecked() && checkBoxAmendoeira.isChecked() && checkBoxNoite.isChecked() && checkBoxBarqueiros.isChecked() == false) {

                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao4Artes.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage(nome + " você errou " + qtdErros + " vezes. Obrigada por participar!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao4Artes.this, MainActivity.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao4Artes.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}