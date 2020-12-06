package id.ac.scholar.tugas_besar;

public class Toko_Bangunan {
    private String _id, _kd, _nama, _stock, _harga;
    public Toko_Bangunan(String id, String kd, String nama, String stock, String harga) {
        this._id = id;
        this._kd = kd;
        this._nama = nama;
        this._stock = stock;
        this._harga = harga;
    }
    public Toko_Bangunan() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_kd() {
        return _kd;
    }
    public void set_kd(String _kd) {
        this._kd = _kd;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_stock() {
        return _stock;
    }
    public void set_stock(String _stock) { this._stock = _stock;}
    public String get_harga() { return _harga; }
    public void set_harga(String _harga) { this._harga = _harga;}
}
