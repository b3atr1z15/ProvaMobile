package com.example.provamobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private RadioGroup rgOpcoes;
    private Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.etNome);
        rgOpcoes = findViewById(R.id.rgOpcoes1);
        btnProximo = findViewById(R.id.btnProximo1);

        btnProximo.setOnClickListener(v -> {
            String nome = etNome.getText().toString().trim();

            if (nome.isEmpty()) {
                Toast.makeText(MainActivity.this, "Por favor, digite o nome do participante.", Toast.LENGTH_SHORT).show();
                return;
            }

            int checkedId = rgOpcoes.getCheckedRadioButtonId();
            if (checkedId == -1) {
                Toast.makeText(MainActivity.this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show();
                return;
            }

            int pontuacao = (checkedId == R.id.rb1_1) ? 3 : -1;

            Intent intent = new Intent(MainActivity.this, Pergunta2Activity.class);
            intent.putExtra("NOME_USUARIO", nome);
            intent.putExtra("PONTUACAO_ATUAL", pontuacao);
            startActivity(intent);
        });
    }
}