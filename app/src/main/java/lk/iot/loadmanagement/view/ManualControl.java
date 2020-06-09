package lk.iot.loadmanagement.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

import lk.iot.loadmanagement.R;
import lk.iot.loadmanagement.adapter.ManualControlAdapter;
import lk.iot.loadmanagement.data.HomeApplianceDAO;
import lk.iot.loadmanagement.helper.ClickListener;
import lk.iot.loadmanagement.model.HomeAppliance;

public class ManualControl extends AppCompatActivity {

    RecyclerView rvMCItems;
    ManualControlAdapter adapter;
    ArrayList<HomeAppliance> list;
    Toolbar MCToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_control);
        MCToolBar = findViewById(R.id.tb_manual_control);
        rvMCItems = findViewById(R.id.rvMCItems);
        list = new HomeApplianceDAO(ManualControl.this).getAll();

        MCToolBar.setTitle("Manual Control");
        adapter = new ManualControlAdapter(ManualControl.this,list,new ClickListener(){

            @Override
            public void onCheckedChanged(int position, CompoundButton cb, boolean on) {
                HomeAppliance hm = list.get(position);
                Toast.makeText(ManualControl.this,hm.getName()+" : "+on,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {}
            @Override
            public void onPositionClicked(int position, View view) {}

        });

        LinearLayoutManager layoutManager = new LinearLayoutManager( ManualControl.this,  RecyclerView.VERTICAL, false );
        rvMCItems.setLayoutManager( layoutManager );
        rvMCItems.setHasFixedSize( true );
        rvMCItems.setAdapter(adapter);
    }
}
