package com.dingmouren.smaple.paletteimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.dingmouren.paletteimageview.PaletteImageView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private PaletteImageView paletteImageView;
    private SeekBar mSeek1,mSeek2,mSeek3,mSeek4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

    }



    private void initView() {
        paletteImageView = (PaletteImageView) findViewById(R.id.palette);
        mSeek1 = (SeekBar) findViewById(R.id.seek1);
        mSeek2 = (SeekBar) findViewById(R.id.seek2);
        mSeek3 = (SeekBar) findViewById(R.id.seek3);
        mSeek4 = (SeekBar) findViewById(R.id.seek4);
    }

    private void initListener() {
        mSeek1.setOnSeekBarChangeListener(this);
        mSeek2.setOnSeekBarChangeListener(this);
        mSeek3.setOnSeekBarChangeListener(this);
        mSeek4.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        show(seekBar,progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}


    private void show(SeekBar seekBar,int progress) {
        switch (seekBar.getId()){
            case R.id.seek1:
                paletteImageView.setPaletteRadius(progress);
                break;
            case R.id.seek2:
                paletteImageView.setPaletteShadowRadius(progress);
                break;
            case R.id.seek3:
                paletteImageView.setPaletteShadowOffset(progress,0);
                break;
            case R.id.seek4:
                paletteImageView.setPaletteShadowOffset(0,progress);
                break;
        }
    }
}
