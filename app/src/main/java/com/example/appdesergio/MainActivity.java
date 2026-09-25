import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Variáveis principais
    EditText edpeso, edaltura; // Campos onde o usuário digita peso e altura
    TextView tvresulado; // (não é usado nessa tela ainda)
    Button buttonCalcular; // Botão que o usuário vai clicar para calcular

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Log para mostrar no Logcat que a tela iniciou
        Log.d("ciclo de vida", "metodo onCreate");

        // Carrega o layout principal dessa tela
        setContentView(R.layout.activity_main);

        // Liga os EditText do layout às variáveis do Java
        edpeso = findViewById(R.id.edpeso);
        edpeso.setText(""); // Deixa o campo vazio ao iniciar
        edaltura = findViewById(R.id.edaltura);
        edaltura.setText(""); // Deixa o campo vazio também

        // Liga o botão ao layout e cria evento de clique
        buttonCalcular = findViewById(R.id.button);

        // Define tratamento do clique do botão
        buttonCalcular.setOnClickListener(v -> {

            // Criamos uma intenção para abrir a Activity IMCresultados
            Intent intent = new Intent(getApplicationContext(), imcResultado.class);

            // Pega os valores digitados pelo usuário e converte para Double
            Double peso = Double.parseDouble(edpeso.getText().toString());
            Double altura = Double.parseDouble(edaltura.getText().toString());

            // Definindo parâmetros para o bundle (extras da Intent)
            intent.putExtra("peso", peso); // Envia o peso
            intent.putExtra("altura", altura); // Envia a altura

            // Inicia a nova Activity (abre a tela de resultado)
            startActivity(intent);
        });
    }
}