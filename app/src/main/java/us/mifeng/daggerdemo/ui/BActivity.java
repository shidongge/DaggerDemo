package us.mifeng.daggerdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import us.mifeng.daggerdemo.R;

/**
 * Created by shido on 2017/6/27.
 */

public class BActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bactivity);
    }
}
