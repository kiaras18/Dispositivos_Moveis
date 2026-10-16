package com.example.app_exemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NotaAdapter extends ArrayAdapter<Nota> {

    public NotaAdapter(Context context, List<Nota> notas) {
        super(context, 0, notas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = (convertView != null)
                ? convertView
                : LayoutInflater.from(getContext()).inflate(R.layout.item_nota, parent, false);

        Nota nota = getItem(position);

        TextView txtTitulo = itemView.findViewById(R.id.txtTituloItem);
        TextView txtTexto = itemView.findViewById(R.id.txtTextoItem);

        if (nota != null) {
            txtTitulo.setText(nota.getTitulo());
            txtTexto.setText(nota.getTexto());
        }

        return itemView;
    }
}
