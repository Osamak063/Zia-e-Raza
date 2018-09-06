package com.example.osamakhalid.zia_e_raza.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.osamakhalid.zia_e_raza.R;

public class HomeActivity extends AppCompatActivity {
    ReadMoreTextView text;
    TextView eng, urdu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        text = findViewById(R.id.textView);
        eng = findViewById(R.id.eng);
        urdu = findViewById(R.id.urdu);
        text.setMovementMethod(new ScrollingMovementMethod());
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        urdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ServiceActivity.class));
            }
        });
    }
}
