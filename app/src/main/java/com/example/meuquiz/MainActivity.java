package com.example.meuquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonConfirmar;
    TextView textViewAssunto;
    Button buttonArtes;
    Button buttonCinema;
    Button buttonHistoria;
    Button buttonMusica;
    EditText editTextNome;
    String nome = "";
    TextView textViewOla;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            buttonArtes = findViewById(R.id.buttonArtes);
            buttonCinema = findViewById(R.id.buttonCinema);
            buttonHistoria = findViewById(R.id.buttonHistoria);
            buttonMusica = findViewById(R.id.buttonMusica);
            editTextNome = findViewById(R.id.editTextNome);
            buttonConfirmar = findViewById(R.id.buttonConfirmar);
            textViewAssunto = findViewById(R.id.textViewAssunto);
            textViewOla = findViewById(R.id.textViewOla);


        buttonArtes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Questao1Artes.class);
                intent.putExtra("nome", editTextNome.getText().toString().trim());

                startActivity(intent);
            }
        });
        buttonCinema.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Questao1Cinema.class);
                    intent.putExtra("nome", editTextNome.getText().toString().trim());

                    startActivity(intent);
                }
         });

        buttonHistoria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Questao1Historia.class);
                    intent.putExtra("nome", editTextNome.getText().toString().trim());

                    startActivity(intent);
                }
        });

            buttonMusica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Questao1Musica.class);
                    intent.putExtra("nome", editTextNome.getText().toString().trim());

                    startActivity(intent);
                }
            });

        buttonConfirmar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                    nome = editTextNome.getText().toString().trim();
                    if (nome.equals("")) {
                        nome = "Anônimo";
                        editTextNome.setText(nome);
                    }

                    editTextNome.setVisibility(View.GONE);
                    buttonConfirmar.setVisibility(View.GONE);

                    if (textViewAssunto.getVisibility() == View.GONE && buttonArtes.getVisibility() == View.GONE &&
                            buttonCinema.getVisibility() == View.GONE && buttonHistoria.getVisibility() == View.GONE && buttonMusica.getVisibility() == View.GONE) {

                        textViewOla.setVisibility(View.VISIBLE);
                        textViewOla.setText("Olá " + nome + "!");
                        textViewAssunto.setVisibility(View.VISIBLE);
                        buttonArtes.setVisibility(View.VISIBLE);
                        buttonCinema.setVisibility(View.VISIBLE);
                        buttonHistoria.setVisibility(View.VISIBLE);
                        buttonMusica.setVisibility(View.VISIBLE);
                    }
            }
        });
    }
}