package id.ac.scholar.tugas_besar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Skode, Snama, Sstock, Sharga;
    private EditText Ekode, Enama, Estock, Eharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Skode = i.getStringExtra("Ikd");
        Snama = i.getStringExtra("Inama");
        Sstock = i.getStringExtra("Istock");
        Sharga = i.getStringExtra("Iharga");
        Ekode = (EditText) findViewById(R.id.updel_kd);
        Enama = (EditText) findViewById(R.id.updel_nama);
        Estock = (EditText) findViewById(R.id.updel_stock);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Ekode.setText(Skode);
        Enama.setText(Snama);
        Estock.setText(Sstock);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Skode = String.valueOf(Ekode.getText());
                Snama = String.valueOf(Enama.getText());
                Sstock = String.valueOf(Estock.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Skode.equals("")){
                    Ekode.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kode barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Sstock.equals("")){
                    Estock.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi stock barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga barang",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateBangunan(new Toko_Bangunan(Sid, Skode, Snama, Sstock, Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteBangunan(new Toko_Bangunan(Sid, Skode, Snama, Sstock, Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
