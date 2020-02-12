package com.example.calllist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calllist.R;
import com.example.calllist.pojo.InfoOfCallSubscriber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("deprecation")
public class ListNumAdapter extends RecyclerView.Adapter<ViewHolderListNum> {

    private OnListNumClickListener onListNumClickListener;
    private List<InfoOfCallSubscriber> infoOfCallSubscribersList = new ArrayList<>();

    public ListNumAdapter(OnListNumClickListener onListNumClickListener) {
        this.onListNumClickListener = onListNumClickListener;
    }

    @NonNull
    @Override
    public ViewHolderListNum onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_calling_number, parent, false);
        return new ViewHolderListNum(view, onListNumClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListNum holder, int position) {
        holder.bind(infoOfCallSubscribersList.get(position));
    }

    @Override
    public int getItemCount() {
        return infoOfCallSubscribersList.size();
    }


    public void setItems(Collection<InfoOfCallSubscriber> infoOfCallSubscribers) {
        infoOfCallSubscribersList.addAll(infoOfCallSubscribers);
        notifyDataSetChanged();
    }

    public OnListNumClickListener getOnListNumClickListener () {
        return onListNumClickListener;
    }

    public interface OnListNumClickListener {
        void OnListNumClick(int adapterPosition);
    }
}


