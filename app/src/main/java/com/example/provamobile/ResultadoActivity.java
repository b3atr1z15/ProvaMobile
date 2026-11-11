package com.example.provamobile;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvNomeParticipante;
    private TextView tvPontuacao;
    private TextView tvMensagemDesempenho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvNomeParticipante = findViewById(R.id.tvNomeParticipante);
        tvPontuacao = findViewById(R.id.tvPontuacao);
        tvMensagemDesempenho = findViewById(R.id.tvMensagemDesempenho);

        String nome = getIntent().getStringExtra("NOME_USUARIO");
        int pontuacaoFinal = getIntent().getIntExtra("PONTUACAO_FINAL", 0);

        tvNomeParticipante.setText("Participante: " + nome);
        tvPontuacao.setText("Pontuação: " + pontuacaoFinal);

        // Regras de Mensagem de Desempenho
        if (pontuacaoFinal == 12) {
            tvMensagemDesempenho.setText("Você é um verdadeiro mestre da Vexilologia");
        } else if (pontuacaoFinal == 8) {
            tvMensagemDesempenho.setText("Você conhece sobre bandeiras, mas ainda pode melhorar");
        } else if (pontuacaoFinal == 4) {
            tvMensagemDesempenho.setText("Você não é versado nas artes da Vexilologia");
        } else { // 0 ou menos
            tvMensagemDesempenho.setText("Você para o ensino fundamental");
        }
    }
}