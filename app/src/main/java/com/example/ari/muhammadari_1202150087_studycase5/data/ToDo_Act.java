package com.example.ari.muhammadari_1202150087_studycase5.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ari.muhammadari_1202150087_studycase5.R;
import com.example.ari.muhammadari_1202150087_studycase5.data.database.Database;

/**
 * Created by Ari on 24/03/2018.
 */

public class ToDo_Act extends AppCompatActivity {
    //deklarasi variable yang akan digunakan
    EditText kerjaan, deskripsi, prioritas;
    Button tambah;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_layout);

        //set title menjadi add to do
        setTitle("List Kerjaan");

        //mengakses id edit text pada layout
        kerjaan = (EditText) findViewById(R.id.etTodo);
        deskripsi = (EditText) findViewById(R.id.etDesk);
        prioritas = (EditText) findViewById(R.id.etPrior);
        tambah = (Button) findViewById(R.id.btnTambah);
        db = new Database(this);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //apabila data todoname, deskripsi dan prioritas di isi,
                if (db.inputdata(new Data(kerjaan.getText().toString(), deskripsi.getText().toString(),
                        prioritas.getText().toString()))){

                    //maka akan menampilkan toast bawha data berhasil di tambahkan ke dalam list
                    Toast.makeText(ToDo_Act.this, "Berhasil Menambah Aktivitas!", Toast.LENGTH_SHORT).show();

                    //berpindah dari add to do ke list to do
                    startActivity(new Intent(ToDo_Act.this, ListKerjaan.class));

                    //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
                    ToDo_Act.this.finish();
                }else {
                    //apabila edit text kosong maka akan muncul toast bahwa tidak bisa menambah ke dalam list
                    Toast.makeText(ToDo_Act.this, "Tidak bisa menambah List", Toast.LENGTH_SHORT).show();
                    //set semua edit text menjadi kosong
                    kerjaan.setText(null);
                    deskripsi.setText(null);
                    prioritas.setText(null);
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        //intent dari add to do menuju list to do
        Intent intent = new Intent(ToDo_Act.this, ListKerjaan.class);
        //memulai intent
        startActivity(intent);
        //menutup aktivitas setelah intent dijalankan
        this.finish();
    }
}
