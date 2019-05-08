package com.example.sensorsproject.application.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensorsproject.R;
import com.example.sensorsproject.business.models.MyRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomChoiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private List<MyRoom> mMyRoom;
    private Context mContext;

    public RoomChoiceAdapter(Context context) {
        mMyRoom = new ArrayList<>();
        mContext = context;
    }

    public void updateRoomList(List<MyRoom> list)
    {
        mMyRoom = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        // Set the name of the 'NicePlace'
        ((ViewHolder) viewHolder).mText.setText(mMyRoom.get(i).getRoomName());
        ((ViewHolder) viewHolder).mId.setText(String.valueOf(mMyRoom.get(i).getId()));
    }

    @Override
    public int getItemCount() {

        return mMyRoom.size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mId;
        private TextView mText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.id_recyclerview);
            mText = itemView.findViewById(R.id.text_recyclerview);
        }
    }
}
