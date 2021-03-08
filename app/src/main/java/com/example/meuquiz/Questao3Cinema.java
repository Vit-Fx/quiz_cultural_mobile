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

public class Questao3Cinema extends AppCompatActivity {
    TextView textViewNomeCinema3;
    Button buttonCinemaConfirmar3;
    CheckBox checkBoxGal, checkBoxScarlett,checkBoxMark, checkBoxBen;
    String nome = "";
    int qtdErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao3_cinema);

        textViewNomeCinema3 = findViewById(R.id.textViewNomeCinema3);
        buttonCinemaConfirmar3 = findViewById(R.id.buttonCinemaConfirmar3);
        checkBoxGal = findViewById(R.id.checkBoxGal);
        checkBoxScarlett = findViewById(R.id.checkBoxScarlett);
        checkBoxMark = findViewById(R.id.checkBoxMark);
        checkBoxBen = findViewById(R.id.checkBoxBen);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        textViewNomeCinema3.setText(nome);

        buttonCinemaConfirmar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxScarlett.isChecked() && checkBoxMark.isChecked() && checkBoxGal.isChecked() == false && checkBoxBen.isChecked() == false) {

                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao3Cinema.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setMessage(nome + " você errou " + qtdErros + " vezes. Obrigada por participar!");
                    msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Questao3Cinema.this, MainActivity.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("qtdErros", qtdErros);
                            startActivity(intent);
                        }
                    });
                    msg.show();
                }
                else {
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao3Cinema.this, Toast.LENGTH_LONG);
                    msg.setTitle("Resultado");
                    msg.setNeutralButton("OK", null);
                    msg.setMessage("Incorreto!").show();
                    qtdErros++;
                }
            }
        });
    }
}

