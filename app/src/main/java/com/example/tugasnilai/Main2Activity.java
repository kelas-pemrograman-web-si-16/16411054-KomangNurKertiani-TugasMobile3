package com.example.tugasnilai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.edNpm)
    EditText edNpm;
    @BindView(R.id.edNama)
    EditText edNama;
    @BindView(R.id.edTugas)
    EditText edTugas;
    @BindView(R.id.edQuiz)
    EditText edQuiz;
    @BindView(R.id.edUts)
    EditText edUts;
    @BindView(R.id.edUas)
    EditText edUas;

    String strNpm, strNama;
    double dblTugas, dblQuiz, dblUts, dblUas, dblHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        Intent getData = getIntent();
        strNpm = getData.getStringExtra("npm");
        strNama= getData.getStringExtra("nama");

        edNpm.setText(strNpm);
        edNama.setText(strNama);
    }
    @OnClick(R.id.btnHitung)
    void btnHitung(){
        dblTugas = Double.parseDouble(edTugas.getText().toString());
        dblQuiz  = Double.parseDouble(edQuiz.getText().toString());
        dblUts   = Double.parseDouble(edUts.getText().toString());
        dblUas   = Double.parseDouble(edUas.getText().toString());

        dblHasil = (dblTugas + dblQuiz + dblUts + dblUas) / 4;

        //Toast.makeText(getApplicationContext(), String.valueOf(dblHasil),
        //        Toast.LENGTH_LONG).show();
        Intent a = new Intent(Main2Activity.this, Main3Activity.class);
        a.putExtra("nama", strNama);
        a.putExtra("npm", strNpm);
        a.putExtra("nilai", String.valueOf(dblHasil));
        startActivity(a);
        finish();
    }
}
