package com.example.provamobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Pergunta3Activity extends AppCompatActivity {

    private RadioGroup rgOpcoes;
    private Button btnProximo;
    private String nomeUsuario;
    private int pontuacaoAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta3);

        nomeUsuario = getIntent().getStringExtra("NOME_USUARIO");
        pontuacaoAtual = getIntent().getIntExtra("PONTUACAO_ATUAL", 0);

        rgOpcoes = findViewById(R.id.rgOpcoes3);
        btnProximo = findViewById(R.id.btnProximo3);

        btnProximo.setOnClickListener(v -> {
            int checkedId = rgOpcoes.getCheckedRadioButtonId();
            if (checkedId == -1) {
                Toast.makeText(Pergunta3Activity.this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (checkedId == R.id.rb3_3) {
                pontuacaoAtual += 3;
            } else {
                pontuacaoAtual -= 1;
            }

            Intent intent = new Intent(Pergunta3Activity.this, Pergunta4Activity.class);
            intent.putExtra("NOME_USUARIO", nomeUsuario);
            intent.putExtra("PONTUACAO_ATUAL", pontuacaoAtual);
            startActivity(intent);
        });
    }
}