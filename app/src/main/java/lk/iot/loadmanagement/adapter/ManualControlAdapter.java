package lk.iot.loadmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import lk.iot.loadmanagement.R;
import lk.iot.loadmanagement.helper.ClickListener;
import lk.iot.loadmanagement.model.HomeAppliance;

public class ManualControlAdapter extends RecyclerView.Adapter<ManualControlAdapter.ManualControlAdapterViewHolder> {

    Context context;
    ArrayList<HomeAppliance> list;
    ClickListener listener;

    public ManualControlAdapter(Context context, ArrayList<HomeAppliance>list, ClickListener listener){
        this.context = context;
        this.list = list;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ManualControlAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.layout_for_manual_control, parent, false );
        return new ManualControlAdapterViewHolder( view,listener );
    }

    @Override
    public void onBindViewHolder(@NonNull ManualControlAdapterViewHolder holder, int position) {
       HomeAppliance homeAppliance = list.get(position);
        holder.switch_home.setText(homeAppliance.getName());
        holder.switch_home.setTextOn("ON");
        holder.switch_home.setTextOff("OFF");
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public static class ManualControlAdapterViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {

        Switch switch_home;
        private WeakReference<ClickListener> listenerRef;
        public ManualControlAdapterViewHolder(@NonNull View itemView,ClickListener listener) {
            super(itemView);

            switch_home = itemView.findViewById(R.id.switch_home);
            switch_home.setOnCheckedChangeListener(this);
            listenerRef = new WeakReference<>(listener);
        }

//        @Override
//        public void onClick(View v) {
//            listenerRef.get().onPositionClicked(getAdapterPosition(),v);
//        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            listenerRef.get().onCheckedChanged(getAdapterPosition(),buttonView,isChecked);
        }
    }
}
