package id.ac.scholar.tugas_besar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Toko_Bangunan> ListBangunan = new ArrayList<Toko_Bangunan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListBangunan );
        mListView = (ListView) findViewById(R.id.List_bangunan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListBangunan.clear();
        List<Toko_Bangunan> contacts = db.ReadBangunan();
        for (Toko_Bangunan cn : contacts) {
            Toko_Bangunan judulModel = new Toko_Bangunan();
            judulModel.set_id(cn.get_id());
            judulModel.set_kd(cn.get_kd());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_stock(cn.get_stock());
            judulModel.set_harga(cn.get_harga());
            ListBangunan.add(judulModel);
            if ((ListBangunan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Toko_Bangunan obj_itemDetails = (Toko_Bangunan) o;
        String Sid = obj_itemDetails.get_id();
        String Skd = obj_itemDetails.get_kd();
        String Snama = obj_itemDetails.get_nama();
        String Sstock = obj_itemDetails.get_stock();
        String Sharga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ikd", Skd);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Istock", Sstock);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListBangunan.clear();
        mListView.setAdapter(adapter_off);
        List<Toko_Bangunan> contacts = db.ReadBangunan();
        for (Toko_Bangunan cn : contacts) {
            Toko_Bangunan judulModel = new Toko_Bangunan();
            judulModel.set_id(cn.get_id());
            judulModel.set_kd(cn.get_kd());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_stock(cn.get_stock());
            judulModel.set_harga(cn.get_harga());
            ListBangunan.add(judulModel);
            if ((ListBangunan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
