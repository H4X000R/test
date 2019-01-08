package com.mike.jsontest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter (Context context, ArrayList<ExampleItem> exampleList){
        mContext = context;
        mExampleList = exampleList;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, viewGroup,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int position) {

        ExampleItem currentItem = mExampleList.get(position);

        String Title = currentItem.getTitle();
        String Url = currentItem.getUrl();

        exampleViewHolder.mTextTitle.setText(Title);
        exampleViewHolder.mUrl.setText(Url);

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextTitle;
        public TextView mUrl;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextTitle = itemView.findViewById(R.id.text_view_title);
            mUrl = itemView.findViewById(R.id.text_view_url);
        }
    }
}
