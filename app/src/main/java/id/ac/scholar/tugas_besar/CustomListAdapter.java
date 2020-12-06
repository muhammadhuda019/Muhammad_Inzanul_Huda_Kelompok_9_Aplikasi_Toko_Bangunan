package id.ac.scholar.tugas_besar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Toko_Bangunan> movieItems;

    public CustomListAdapter(Activity activity, List<Toko_Bangunan> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView kode = (TextView) convertView.findViewById(R.id.text_kode);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView stock = (TextView) convertView.findViewById(R.id.text_stock);
        TextView harga = (TextView) convertView.findViewById(R.id.text_harga);
        Toko_Bangunan m = movieItems.get(position);
        kode.setText("Kode Barang   :       "+ m.get_kd());
        nama.setText("Nama Barang  :       "+ m.get_nama());
        stock.setText("Stock Barang  :       "+ m.get_stock());
        harga.setText("Harga Barang :       "+ m.get_harga());
        return convertView;
    }
}
