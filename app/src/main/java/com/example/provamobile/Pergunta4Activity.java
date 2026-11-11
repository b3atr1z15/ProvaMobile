package com.example.provamobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Pergunta4Activity extends AppCompatActivity {

    private RadioGroup rgOpcoes;
    private Button btnProximo;
    private String nomeUsuario;
    private int pontuacaoAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta4);

        nomeUsuario = getIntent().getStringExtra("NOME_USUARIO");
        pontuacaoAtual = getIntent().getIntExtra("PONTUACAO_ATUAL", 0);

        rgOpcoes = findViewById(R.id.rgOpcoes4);
        btnProximo = findViewById(R.id.btnProximo4);

        btnProximo.setOnClickListener(v -> {
            int checkedId = rgOpcoes.getCheckedRadioButtonId();
            if (checkedId == -1) {
                Toast.makeText(Pergunta4Activity.this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (checkedId == R.id.rb4_1) {
                pontuacaoAtual += 3;
            } else {
                pontuacaoAtual -= 1;
            }

            Intent intent = new Intent(Pergunta4Activity.this, ResultadoActivity.class);
            intent.putExtra("NOME_USUARIO", nomeUsuario);
            intent.putExtra("PONTUACAO_FINAL", pontuacaoAtual);
            startActivity(intent);
        });
    }
}