package id.ac.scholar.tugas_besar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_TokoBangunan";
    private static final String tb_bangunan = "tb_bangunan";
    private static final String tb_bangunan_id = "id";
    private static final String tb_bangunan_kd = "kd";
    private static final String tb_bangunan_nama = "nama";
    private static final String tb_bangunan_stock = "stock";
    private static final String tb_bangunan_harga = "harga";
    private static final String CREATE_TABLE_BANGUNAN = "CREATE TABLE " +
            tb_bangunan + "("
            + tb_bangunan_id + " INTEGER PRIMARY KEY ,"
            + tb_bangunan_kd + " TEXT,"
            + tb_bangunan_nama + " TEXT,"
            + tb_bangunan_stock + " TEXT,"
            + tb_bangunan_harga + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BANGUNAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateBangunan (Toko_Bangunan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_bangunan_id, mdNotif.get_id());
        values.put(tb_bangunan_kd, mdNotif.get_kd());
        values.put(tb_bangunan_nama, mdNotif.get_nama());
        values.put(tb_bangunan_stock, mdNotif.get_stock());
        values.put(tb_bangunan_harga, mdNotif.get_harga());
        db.insert(tb_bangunan, null, values);
        db.close();
    }

    public List<Toko_Bangunan> ReadBangunan() {
        List<Toko_Bangunan> judulModelList = new ArrayList<Toko_Bangunan>();
        String selectQuery = "SELECT * FROM " + tb_bangunan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Toko_Bangunan mdKontak = new Toko_Bangunan();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_kd(cursor.getString(1));
                mdKontak.set_nama(cursor.getString(2));
                mdKontak.set_stock(cursor.getString(3));
                mdKontak.set_harga(cursor.getString(4));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateBangunan (Toko_Bangunan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_bangunan_kd, mdNotif.get_kd());
        values.put(tb_bangunan_nama, mdNotif.get_nama());
        values.put(tb_bangunan_stock, mdNotif.get_stock());
        values.put(tb_bangunan_harga, mdNotif.get_harga());
        return db.update(tb_bangunan, values, tb_bangunan_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteBangunan (Toko_Bangunan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_bangunan, tb_bangunan_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
