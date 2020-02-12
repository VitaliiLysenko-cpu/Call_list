package com.example.calllist.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calllist.R;
import com.example.calllist.adapter.ListNumAdapter;
import com.example.calllist.pojo.InfoOfCallSubscriber;

import java.util.Arrays;
import java.util.Collection;

public class ListOfCallingNumbers extends AppCompatActivity{
    private final static String INFO_SUB = "infoSub";
    private RecyclerView recyclerListOfCallNum;
    private ListNumAdapter listNumAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_calling_numbers);

        initRecyclerView();
        loadInfoOfCallSubscriber();
    }

    private void loadInfoOfCallSubscriber() {
        Collection<InfoOfCallSubscriber> infoOfCallSubscribers = getInfoOfCallSubscribers();
        listNumAdapter.setItems(infoOfCallSubscribers);

    }

    private Collection<InfoOfCallSubscriber> getInfoOfCallSubscribers() {
        return Arrays.asList(
                new InfoOfCallSubscriber("Федя", "Thu May 9 07:31:08 +0000 2020"),
                new InfoOfCallSubscriber("Толян", "Thu May 9 07:32:08 +0000 2020"),
                new InfoOfCallSubscriber("Люда", "Thu May 9 07:33:08 +0000 2020"),
                new InfoOfCallSubscriber("Коля", "Thu May 9 07:35:08 +0000 2020"),
                new InfoOfCallSubscriber("Санек", "Thu May 9 07:29:08 +0000 2020"),
                new InfoOfCallSubscriber("Муся", "Thu May 9 07:40:08 +0000 2020"),
                new InfoOfCallSubscriber("Ксенья", "Thu May 9 07:51:08 +0000 2020"),
                new InfoOfCallSubscriber("Ганночка", "Thu May 9 07:16:08 +0000 2020"),
                new InfoOfCallSubscriber("Дарина", "Thu May 9 07:27:08 +0000 2020"),
                new InfoOfCallSubscriber("Алексей", "Thu May 9 07:08:08 +0000 2020"),
                new InfoOfCallSubscriber("Юлия", "Thu May 9 07:01:08 +0000 2020"),
                new InfoOfCallSubscriber("Нина", "Thu May 9 09:31:08 +0000 2020")
        );
    }

    private void initRecyclerView() {
        recyclerListOfCallNum = findViewById(R.id.recycler_view_list_of_calling_numbers);
        recyclerListOfCallNum.setLayoutManager(new LinearLayoutManager(this));
        
        ListNumAdapter.OnListNumClickListener onListNumClickListener = new ListNumAdapter.OnListNumClickListener() {
            @Override
            public void OnListNumClick(int adapterPosition) {
                listNumAdapter.getItemId(adapterPosition);

                Intent intent = new Intent(ListOfCallingNumbers.this, InfoOnSubscriber.class);
                intent.putExtra(ListOfCallingNumbers.INFO_SUB,  adapterPosition);
                startActivity(intent);
            }
        } ;
        listNumAdapter = new ListNumAdapter(onListNumClickListener);
        recyclerListOfCallNum.setAdapter(listNumAdapter);
    }
}

