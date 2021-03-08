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

public class Questao2Historia extends AppCompatActivity {
    TextView textViewNomeHistoria2;
    CheckBox checkBoxGetulio, checkBoxVenceslau, checkBoxJoao, checkBoxAfonso;
    Button buttonHistoriaConfirmar2;
    String nome = "";
    int qtdErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2_historia);

        textViewNomeHistoria2 = findViewById(R.id.textViewNomeHistoria2);
        checkBoxGetulio = findViewById(R.id.checkBoxGetulio);
        checkBoxVenceslau = findViewById(R.id.checkBoxVenceslau);
        checkBoxJoao = findViewById(R.id.checkBoxJoao);
        checkBoxAfonso = findViewById(R.id.checkBoxAfonso);
        buttonHistoriaConfirmar2 = findViewById(R.id.buttonHistoriaConfirmar2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeHistoria2.setText(nome);

        buttonHistoriaConfirmar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxJoao.isChecked() && checkBoxGetulio.isChecked() == false && checkBoxVenceslau.isChecked() == false && checkBoxAfonso.isChecked() == false) {

                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao2Historia.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage("Correto!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao2Historia.this, Questao3Historia.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao2Historia.this,  Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}