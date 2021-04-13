package es.ulpgc.eite.cleancode.catalog.categorias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CategoriaItem;

public class CategoriaAdapter extends ArrayAdapter<CategoriaItem> {
    private final List<CategoriaItem> itemList;
    private final View.OnClickListener clickListener;
    public CategoriaAdapter(
            Context context, List<CategoriaItem> items, View.OnClickListener listener) {

        super(context, 0, items);
        itemList = items;
        clickListener = listener;
    }
    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public CategoriaItem getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.product_list_content, parent, false);
        }

        itemView.setTag(itemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.content);
        contentView.setText(itemList.get(position).content);

        return itemView;
    }
}
