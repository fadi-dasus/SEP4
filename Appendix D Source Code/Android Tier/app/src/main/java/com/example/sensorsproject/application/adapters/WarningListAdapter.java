package com.example.sensorsproject.application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensorsproject.R;
import com.example.sensorsproject.business.models.Warning;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WarningListAdapter extends RecyclerView.Adapter<WarningListAdapter.ViewHolder> {

    /*
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.warning_measurement_type) TextView textMeasurementType;
        @BindView(R.id.warning_value) TextView textValue;
        @BindView(R.id.warning_time) TextView textTime;
        @BindView(R.id.warning_status_text) TextView textStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /*
     * WarningListAdapter
     */

    private List<Warning> warningList;

    public WarningListAdapter(){
        this.warningList = new ArrayList<>();
    }

    public void setWarningList(List<Warning> warnings){
        this.warningList = warnings;
        notifyDataSetChanged();
    }

    /*
     * RecyclerViewAdapter
     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_warning_list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Warning currentWarning = warningList.get(position);
        String measurementType = currentWarning.getMeasurementType();
        String value = currentWarning.getValue();
        String time = currentWarning.getLocalDate();
        String status = currentWarning.getStatus();

        holder.textMeasurementType.setText(measurementType);
        holder.textValue.setText(value);
        holder.textTime.setText(time);
        holder.textStatus.setText(status);
    }

    @Override
    public int getItemCount() {
        return warningList.size();
    }
}
