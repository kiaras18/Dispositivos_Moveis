package com.example.app_exemplo;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtTitulo;
    private EditText edtTexto;
    private ListView listViewNotas;

    private DatabaseHelper dbHelper;

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

        edtTitulo = findViewById(R.id.edtTitulo);
        edtTexto = findViewById(R.id.edtTexto);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        listViewNotas = findViewById(R.id.listViewNotas);

        dbHelper = new DatabaseHelper(this);

        carregarNotas();

        btnSalvar.setOnClickListener(v -> {
            String titulo = edtTitulo.getText().toString().trim();
            String texto = edtTexto.getText().toString().trim();

            if (TextUtils.isEmpty(titulo) && TextUtils.isEmpty(texto)) {
                Toast.makeText(MainActivity.this, R.string.msg_preencha_campos, Toast.LENGTH_SHORT).show();
                return;
            }

            long res = dbHelper.inseriNota(titulo, texto);
            if (res > 0) {
                Toast.makeText(MainActivity.this, R.string.msg_salvo_sucesso, Toast.LENGTH_SHORT).show();
                edtTitulo.setText("");
                edtTexto.setText("");
                carregarNotas();
            } else {
                Toast.makeText(MainActivity.this, R.string.msg_erro_salvar, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void carregarNotas() {
        List<Nota> listaNotas = dbHelper.listarNotas();
        NotaAdapter adapter = new NotaAdapter(this, listaNotas);
        listViewNotas.setAdapter(adapter);
    }
}
