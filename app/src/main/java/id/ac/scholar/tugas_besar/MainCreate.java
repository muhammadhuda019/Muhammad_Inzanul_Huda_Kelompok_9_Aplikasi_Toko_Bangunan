package id.ac.scholar.tugas_besar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ekode, Enama, Estock, Eharga;
    private String Skode, Snama, Sstock, Sharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ekode = (EditText) findViewById(R.id.create_kd);
        Enama = (EditText) findViewById(R.id.create_nama);
        Estock = (EditText) findViewById(R.id.create_stock);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Skode = String.valueOf(Ekode.getText());
                Snama = String.valueOf(Enama.getText());
                Sstock = String.valueOf(Estock.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Skode.equals("")){
                    Ekode.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi kode barang",
                            Toast.LENGTH_SHORT).show();

                } else if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama barang",
                            Toast.LENGTH_SHORT).show();

                } else if (Sstock.equals("")){
                    Estock.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi stock barang",
                            Toast.LENGTH_SHORT).show();

                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi harga barang",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Ekode.setText("");
                    Enama.setText("");
                    Estock.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateBangunan(new Toko_Bangunan(null, Skode, Snama, Sstock, Sharga));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
