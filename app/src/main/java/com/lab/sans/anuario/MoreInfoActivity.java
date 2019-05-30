package com.lab.sans.anuario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreInfoActivity extends AppCompatActivity {

    ImageView coolCatImage;
    TextView name, born, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.f_name);
        born = findViewById(R.id.born);
        info = findViewById(R.id.info);
        coolCatImage = findViewById(R.id.cool_cat_image);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        int position = bundle.getInt("local");

        coolCatImage.setImageResource(ListInflater.images[position]);
        name.setText(Data.full_names[position]);
        born.setText(Data.born[position]);
        info.setText(Data.info[position]);
    }
}
