package br.com.pucgo.exercicio5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText nome, cpf, dataNascimento, telefone, celular, email;
    Button cadastrar;
    DatePickerDialog.OnDateSetListener datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        cpf = findViewById(R.id.cpf);
        dataNascimento = findViewById(R.id.dataNascimento);
        telefone = findViewById(R.id.telefone);
        celular = findViewById(R.id.celular);
        email = findViewById(R.id.email);
        cadastrar = findViewById(R.id.cadastrar);

        Intent telaAnterior = getIntent();
        String strNome, strCpf, strDataNascimento, strTelefone, strCelular, strEmail;
        strNome = telaAnterior.getStringExtra("nome");
        strCpf = telaAnterior.getStringExtra("cpf");
        strDataNascimento = telaAnterior.getStringExtra("dataNascimento");
        strTelefone = telaAnterior.getStringExtra("telefone");
        strCelular = telaAnterior.getStringExtra("celular");
        strEmail = telaAnterior.getStringExtra("email");
        if(strNome != null
                && strCpf != null
                && strDataNascimento != null
                && strTelefone != null
                && strCelular != null
                && strEmail != null
        ){
            if(!strNome.isEmpty()
                    && !strCpf.isEmpty()
                    && !strDataNascimento.isEmpty()
                    && !strTelefone.isEmpty()
                    && !strCelular.isEmpty()
                    && !strEmail.isEmpty()
            ){
                nome.setText(strNome);
                cpf.setText(strCpf);
                dataNascimento.setText(strDataNascimento);
                telefone.setText(strTelefone);
                celular.setText(strCelular);
                email.setText(strEmail);
            }
        }



        dataNascimento.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int dia, mes, ano;
                dia = calendar.get(Calendar.DAY_OF_MONTH);
                mes = calendar.get(Calendar.MONTH);
                ano = calendar.get(Calendar.YEAR);
                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        datePicker, ano, mes, dia
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                return true;
            }
        });

        datePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String dataString = dayOfMonth + "/" + month + "/" + year;
                dataNascimento.setText(dataString);
            }
        };

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNome, strCpf, strDataNascimento, strTelefone, strCelular, strEmail;
                strNome = nome.getText().toString();
                strCpf = cpf.getText().toString();
                strDataNascimento = dataNascimento.getText().toString();
                strTelefone = telefone.getText().toString();
                strCelular = celular.getText().toString();
                strEmail = email.getText().toString();

                Intent i = new Intent(MainActivity.this, SegundaTela.class);
                Bundle bundle = new Bundle();
                if(!strNome.isEmpty()
                        && !strCpf.isEmpty()
                        && !strDataNascimento.isEmpty()
                        && !strTelefone.isEmpty()
                        && !strCelular.isEmpty()
                        && !strEmail.isEmpty()
                ){
                    bundle.putString("nome", strNome);
                    bundle.putString("cpf", strCpf);
                    bundle.putString("dataNascimento", strDataNascimento);
                    bundle.putString("telefone", strTelefone);
                    bundle.putString("celular", strCelular);
                    bundle.putString("email", strEmail);

                }
                i.putExtras(bundle);
                startActivity(i);
                finish();

            }
        });



    }
}