package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText namapanjang,namapanggilan,ttl,alamat,hobi,pekerjaan;
    Spinner jkelamin;
    Button tgllahir,proses;
    TextView kalimatpengenalandiri;
    private int mTahun, mBulan, mHari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namapanjang = (EditText) findViewById(R.id.edt_namapanjang);
        namapanggilan = (EditText) findViewById(R.id.edt_namapanggilan);
        ttl = (EditText) findViewById(R.id.edt_ttl);
        alamat = (EditText) findViewById(R.id.edt_alamat);
        hobi = (EditText) findViewById(R.id.edt_hobi);
        pekerjaan = (EditText) findViewById(R.id.edt_pekerjaan);

        jkelamin = (Spinner) findViewById(R.id.spn_jeniskelamin);

        tgllahir = (Button)findViewById(R.id.btn_tgllahir);
        proses = (Button) findViewById(R.id.btn_proses);

        kalimatpengenalandiri=(TextView) findViewById(R.id.txt_kalimatpengenalan);

        List<String>ListKelamin = new ArrayList<String>();
        ListKelamin.add("Pria");
        ListKelamin.add("Perempuan");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ListKelamin );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jkelamin.setAdapter(adapter);

        tgllahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                mTahun = cal.get(Calendar.YEAR);
                mBulan = cal.get(Calendar.MONTH);
                mHari = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatedialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tgllahir.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(month) + "-" + String.valueOf(year));

                    }
                }, mTahun, mBulan, mHari);
                mDatedialog.setTitle("Pilih Tanggal Lahir");
                mDatedialog.show();

        }});
    proses.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            kalimatpengenalandiri.setText("Nama Saya "+namapanjang.getText().toString()+",Panggilan saya "+namapanggilan.getText().toString()+",Saya lahir di "+ttl.getText().toString()+
                    ",Alamat saya di "+alamat.getText().toString()+",Hobi saya adalah "+hobi.getText().toString()+",Dan Pekerjaan saya adalah "+pekerjaan.getText().toString()+",Senang berkenalan dengan anda...");
        }
    });

    }
}