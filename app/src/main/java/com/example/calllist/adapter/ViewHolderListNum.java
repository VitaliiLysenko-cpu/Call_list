package com.example.calllist.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calllist.R;
import com.example.calllist.pojo.InfoOfCallSubscriber;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ViewHolderListNum extends RecyclerView.ViewHolder {

    private static final String FORMAT_GET_DATE = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
    private static final String MONTH_DAY_FORMAT = "MMM d HH:mm";

    private ImageView iconCall;
    private TextView nameCall;
    private TextView dateAndTime;
    private ListNumAdapter.OnListNumClickListener onListNumClickListener;

    public ViewHolderListNum(final View itemView,
                             final ListNumAdapter. OnListNumClickListener onListNumClickListenet) {
        super(itemView);

        iconCall = itemView.findViewById(R.id.icon_call_item);
        nameCall = itemView.findViewById(R.id.name_call_item);
        dateAndTime = itemView.findViewById(R.id.date_and_time_call_item);

        this.onListNumClickListener = onListNumClickListenet;

    }

    public void bind( final InfoOfCallSubscriber infoOfCallSubscriber) {

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onListNumClickListener.OnListNumClick(getAdapterPosition());
            }
        }) ;
        nameCall.setText(infoOfCallSubscriber.getName());
        dateAndTime.setText(infoOfCallSubscriber.getCreationDate());
        iconCall.setImageResource(R.drawable.ic_local_phone_black_24dp);
        dateAndTime.setText(getFormattedDate(infoOfCallSubscriber.getCreationDate()));
    }

    private String getFormattedDate(String rawDate) {
        SimpleDateFormat utcFormat = new SimpleDateFormat(FORMAT_GET_DATE, Locale.ROOT);
        SimpleDateFormat displayFormat = new SimpleDateFormat(MONTH_DAY_FORMAT, Locale.getDefault());
        try {
            Date date = utcFormat.parse(rawDate);
            return displayFormat.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
