package com.example.appdesergio;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class imcresultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Carrega o layout da tela de resultados do IMC
        setContentView(R.layout.activity_imcresultado);

        // Recupera os dados enviados pela Intent
        Bundle bundle = getIntent().getExtras();

        // Pega os valores de peso e altura
        Double peso = bundle.getDouble("peso"); // Peso em kg
        Double altura = bundle.getDouble("altura"); // Altura em metros

        // Calcula o IMC usando a fórmula
        Double imc = (peso / (altura * altura));

        // Liga as variáveis aos componentes da tela
        TextView tvIMC = findViewById(R.id.textViewIMC); // Mostra o IMC
        TextView tvaltura = findViewById(R.id.tvAlturaResult); // Mostra a altura
        TextView tvpeso = findViewById(R.id.tvpesoResult); // Mostra o peso
        TextView tvDescricao = findViewById(R.id.textViewDescricaoIMC); // Mostra a descrição do IMC
        ImageView imageView = findViewById(R.id.imageViewPerfil); // Mostra a imagem correspondente

        // Exibe os valores formatados nos TextViews
        tvIMC.setText(String.format("%.2f", imc) + " kg/m²");
        tvaltura.setText(String.format("%.2f", altura) + " m");
        tvpeso.setText(String.format("%.2f", peso) + " kg");

        // Verifica em qual faixa está o IMC e define descrição e imagem
        if (imc < 18.5) { // Se o IMC for menor que 18.5
            tvDescricao.setText("Abaixo do peso");
            imageView.setImageResource(R.drawable.abaixopeso);
        } else if (imc >= 18.5 && imc <= 24.9) { // Se IMC estiver no intervalo normal
            tvDescricao.setText("Peso normal");
            imageView.setImageResource(R.drawable.normal);
        } else if (imc >= 25 && imc <= 29.9) { // Se IMC estiver na faixa de sobrepeso
            tvDescricao.setText("Sobrepeso");
            imageView.setImageResource(R.drawable.sobrepeso);
        } else if (imc >= 30 && imc <= 34.9) { // Se IMC for obesidade grau 1
            tvDescricao.setText("Obesidade grau 1");
            imageView.setImageResource(R.drawable.obesidade1);
        } else if (imc >= 35 && imc <= 39.9) { // Se IMC for obesidade grau 2
            tvDescricao.setText("Obesidade grau 2");
            imageView.setImageResource(R.drawable.obesidade2);
        } else { // Se não entrar em nenhuma das condições acima, é obesidade grau 3
            tvDescricao.setText("Obesidade grau 3");
            imageView.setImageResource(R.drawable.obesidade3);
        }

    }
}