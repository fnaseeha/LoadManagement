package lk.iot.loadmanagement.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import lk.iot.loadmanagement.R;

public class CustomerInfo extends AppCompatActivity {

    private Toolbar mToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        mToolBar =  findViewById( R.id.tb_main );
        mToolBar.setTitle( "Customer Information" );
        mToolBar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
}
