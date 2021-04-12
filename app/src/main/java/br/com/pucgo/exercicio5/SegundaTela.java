package br.com.pucgo.exercicio5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaTela extends AppCompatActivity {

    TextView nome, cpf, dataNascimento, telefone, celular, email;
    Button editar, voltar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela);

        nome = findViewById(R.id.nomeCadastrado);
        cpf = findViewById(R.id.cpfCadastrado);
        dataNascimento = findViewById(R.id.dataNascimentoCadastrado);
        telefone = findViewById(R.id.telefoneCadastrado);
        celular = findViewById(R.id.celularCadastrado);
        email = findViewById(R.id.emailCadastrado);
        editar = findViewById(R.id.editar);
        voltar = findViewById(R.id.voltar);

        Intent telaAnterior = getIntent();
        String strNome, strCpf, strDataNascimento, strTelefone, strCelular, strEmail;
        strNome = telaAnterior.getStringExtra("nome");
        strCpf = telaAnterior.getStringExtra("cpf");
        strDataNascimento = telaAnterior.getStringExtra("dataNascimento");
        strTelefone = telaAnterior.getStringExtra("telefone");
        strCelular = telaAnterior.getStringExtra("celular");
        strEmail = telaAnterior.getStringExtra("email");

        nome.setText(strNome);
        cpf.setText(strCpf);
        dataNascimento.setText(strDataNascimento);
        telefone.setText(strTelefone);
        celular.setText(strCelular);
        email.setText(strEmail);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundaTela.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nome", strNome);
                bundle.putString("cpf", strCpf);
                bundle.putString("dataNascimento", strDataNascimento);
                bundle.putString("telefone", strTelefone);
                bundle.putString("celular", strCelular);
                bundle.putString("email", strEmail);
                i.putExtras(bundle);
                startActivity(i);
                finish();
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundaTela.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });




    }
}
