package com.example.appdesergio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText edmin, edmax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        b=findViewById(R.id.btnAnterior);
//        TextView tv=findViewById(R.id.TextView);
//        edmin= findViewById(R.id.edmin);
//        edmax= findViewById(R.id.edmax);
//
//        b.setOnClickListener(view -> {
//            //contador = (int)(Math.random() *100);
//            String maxst =edmax.getText().toString();
//            String minst =edmin.getText().toString();
//
//            if(minst.isEmpty()){
//                edmin.setError("Informe o valor mínimo.");
//                return;
//            }
//            if(maxst.isEmpty()){
//                edmax.setError("Informe o valor máximo");
//                return;
//            }
//            int min = Integer.parseInt(minst);
//            int max = Integer.parseInt(maxst);
//
//            Random random= new Random();
//            int r = random.nextInt(max-min)+min; //[0,max]
//            tv.setText(Integer.toString(r));
//
//            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//            intent.putExtra("valor",r);
//            startActivity(intent);
//
//        });
        Intereger[] imagens=new Intereger[]{
                R.drawble.cachorro,
                R.drawble.garden,
                R.drawble.happy,
                R.drawble.patinho,
                R.drawble.porquinho
        };
        Button botaoVoltar, botaoAvancar;
        botaoVoltar=findViewById(R.id.btnAnterior);
        botaoAvancar=findViewById(R.id.btnProximo);
        botaoAvancar.setOnClickListener(View v-->{
            imageView.setImageResource(imagens[posicao]);
        });
    }
}