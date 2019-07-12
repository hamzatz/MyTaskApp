package com.e.mytaskapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.mytaskapp.R;
import com.e.mytaskapp.models.Task;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    List<Task> list;
    private ClickListener clickListener;

    public interface ClickListener{

        void OnNoteClick (int pos);
        void OnNoteLong(int pos);

    }


    public MyAdapter(List<Task> arrayList) {
        this.list = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_my,viewGroup,false);
        MyViewHolder myViewHolder= new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.onBind(list.get(i));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView descriptionTextView;
        Task task;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView= itemView.findViewById(R.id.title_view_holder);
            descriptionTextView= itemView.findViewById(R.id.description_view_holder);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickListener.OnNoteClick(getAdapterPosition());

                }
            }); itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.OnNoteLong(getAdapterPosition());
                }
            });


        }
        public void onBind(Task task){

            this.task=task;
            titleTextView.setText(task.getTitle());
            descriptionTextView.setText(task.getDescription());



        }
    }
}