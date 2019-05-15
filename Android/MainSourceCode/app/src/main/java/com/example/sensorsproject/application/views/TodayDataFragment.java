package com.example.sensorsproject.application.views;


import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.icu.util.Measure;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.DateValueFormatter;
import com.example.sensorsproject.application.viewmodels.LiveDataViewModel;
import com.example.sensorsproject.application.viewmodels.MeasurementViewModel;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayDataFragment extends Fragment {

    @BindView(R.id.button_co2) Button buttonCo2;
    @BindView(R.id.button_hum) Button buttonHum;
    @BindView(R.id.button_temp) Button buttonTemp;
    @BindView(R.id.chart) LineChart lineChart;

    private MeasurementViewModel measurementViewModel;
    private LiveDataViewModel liveDataViewModel;
    private static float LINE_LENGTH = 10f;
    private static float SPACE_LENGTH = 5f;

    private String roomId;

    public TodayDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        measurementViewModel = ViewModelProviders.of(getActivity()).get(MeasurementViewModel.class);
        liveDataViewModel = ViewModelProviders.of(getActivity()).get(LiveDataViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today_data, container, false);
        ButterKnife.bind(this, view);

        roomId = liveDataViewModel.getCurrentRoom().getValue().getId();

        subscribeCo2Data();
        subscribeHumData();
        subscribeTempData();
        setOnClickListeners();
        setupLineChart();

        return view;
    }

    public void setupCo2Chart(List<CO2> co2List){
        Description desc = new Description();
        desc.setText("C02 Data");
        lineChart.setDescription(desc);

        if(lineChart.getData() != null) {
            lineChart.getData().clearValues();
        }
        ArrayList<Entry> values = new ArrayList<>();
        String[] dates = new String[co2List.size()];
        for(int i = 0; i < co2List.size(); i++){
            float pos = (float) i;
            float value = Float.parseFloat(co2List.get(i).getValue());
            dates[i] = co2List.get(i).getTimestamp();
            values.add(new Entry(pos, value));
        }

        XAxis axis = lineChart.getXAxis();
        axis.setValueFormatter(new DateValueFormatter(dates));

        LineDataSet set1;
        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(values, "CO2 Data");
            set1.setDrawIcons(false);
            set1.enableDashedLine(LINE_LENGTH, SPACE_LENGTH, 0f);
            set1.enableDashedHighlightLine(LINE_LENGTH, SPACE_LENGTH, 0f);
            set1.setColor(Color.DKGRAY);
            set1.setCircleColor(Color.DKGRAY);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{LINE_LENGTH, SPACE_LENGTH}, 0f));
            set1.setFormSize(15.f);
            set1.setFillColor(Color.DKGRAY);
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            lineChart.setData(data);
        }
        lineChart.invalidate();
    }

    public void setupHumChart(List<Humidity> humidityList){
        Description desc = new Description();
        desc.setText("Humidity Data");
        lineChart.setDescription(desc);

        if(lineChart.getData() != null) {
            lineChart.getData().clearValues();
        }
        ArrayList<Entry> values = new ArrayList<>();
        String[] dates = new String[humidityList.size()];
        for(int i = 0; i < humidityList.size(); i++){
            float pos = (float) i;
            float value = Float.parseFloat(humidityList.get(i).getValue());
            dates[i] = humidityList.get(i).getTimestamp();
            values.add(new Entry(pos, value));
        }

        XAxis axis = lineChart.getXAxis();
        axis.setValueFormatter(new DateValueFormatter(dates));

        LineDataSet set1;
        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(values, "Humidity Data");
            set1.setDrawIcons(false);
            set1.enableDashedLine(LINE_LENGTH, SPACE_LENGTH, 0f);
            set1.enableDashedHighlightLine(LINE_LENGTH, SPACE_LENGTH, 0f);
            set1.setColor(Color.BLUE);
            set1.setCircleColor(Color.BLUE);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{LINE_LENGTH, SPACE_LENGTH}, 0f));
            set1.setFormSize(15.f);
            set1.setFillColor(Color.BLUE);
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            lineChart.setData(data);
        }
        lineChart.invalidate();
    }

    public void setupTempChart(List<Temperature> temperatureList){
        Description desc = new Description();
        desc.setText("Temperature Data");
        lineChart.setDescription(desc);

        if(lineChart.getData() != null) {
            lineChart.getData().clearValues();
        }
        ArrayList<Entry> values = new ArrayList<>();
        String[] dates = new String[temperatureList.size()];
        for(int i = 0; i < temperatureList.size(); i++){
            float pos = (float) i;
            float value = Float.parseFloat(temperatureList.get(i).getValue());
            dates[i] = temperatureList.get(i).getTimestamp();
            values.add(new Entry(pos, value));
        }

        XAxis axis = lineChart.getXAxis();
        axis.setValueFormatter(new DateValueFormatter(dates));

        LineDataSet set1;
        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(values, "Temperature Data");
            set1.setDrawIcons(false);
            set1.enableDashedLine(LINE_LENGTH, SPACE_LENGTH, 0f);
            set1.enableDashedHighlightLine(LINE_LENGTH, SPACE_LENGTH, 0f);
            set1.setColor(Color.RED);
            set1.setCircleColor(Color.RED);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{LINE_LENGTH, SPACE_LENGTH}, 0f));
            set1.setFormSize(15.f);
            set1.setFillColor(Color.RED);
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            lineChart.setData(data);
        }
        lineChart.invalidate();
    }

    public void setupLineChart(){
        lineChart.setTouchEnabled(true);
        lineChart.setPinchZoom(true);
    }

    public void subscribeCo2Data(){
        measurementViewModel.getAllCo2sByRoomIdToday().observe(this, co2s -> {
            if(co2s != null & co2s.size() > 0){
                setupCo2Chart(co2s);
            }
        });
    }

    private void setOnClickListeners(){

        buttonCo2.setOnClickListener(v -> {
            measurementViewModel.searchAllCo2sByRoomIdToday(roomId);
        });

        buttonHum.setOnClickListener(v -> {
            measurementViewModel.searchAllHumiditiesByRoomIdToday(roomId);
        });

        buttonTemp.setOnClickListener(v -> {
            measurementViewModel.searchAllTemperaturesByRoomIdToday(roomId);
        });
    }

    private void subscribeHumData(){
        measurementViewModel.getAllHumiditiesByRoomIdToday().observe(this, humidities -> {
            if(humidities != null && humidities.size() > 0){
                setupHumChart(humidities);
            }
        });
    }

    private void subscribeTempData(){
        measurementViewModel.getAllTemperaturesByRoomIdToday().observe(this, temperatures -> {
            if(temperatures != null && temperatures.size() > 0) {
                setupTempChart(temperatures);
            }
        });
    }
}
