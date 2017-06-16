package com.jurtz.marcel.audiocontrol;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {


    private SeekBar sbVolumeRingtone;
    private SeekBar sbVolumeMedia;
    private SeekBar sbVolumeAlarm;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbVolumeRingtone = (SeekBar) findViewById(R.id.sbVolumeRingtone);
        sbVolumeMedia = (SeekBar) findViewById(R.id.sbVolumeMedia);
        sbVolumeAlarm = (SeekBar) findViewById(R.id.sbVolumeAlarm);

        audioManager = (AudioManager) this.getSystemService(getApplicationContext().AUDIO_SERVICE);

        // Range between 0 and max volume
        sbVolumeRingtone.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_RING));
        sbVolumeRingtone.setKeyProgressIncrement(1);
        sbVolumeRingtone.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));

        sbVolumeMedia.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        sbVolumeMedia.setKeyProgressIncrement(1);
        sbVolumeMedia.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

        sbVolumeAlarm.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM));
        sbVolumeAlarm.setKeyProgressIncrement(1);
        sbVolumeAlarm.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));

        //register OnSeekBarChangeListener to enable ringtone volume changing
        sbVolumeRingtone.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Change volume
                // Show toast & play sound
                audioManager.setStreamVolume(AudioManager.STREAM_RING, progress, AudioManager.FLAG_SHOW_UI + AudioManager.FLAG_PLAY_SOUND);
            }
        });

        //register OnSeekBarChangeListener to enable media volume changing
        sbVolumeMedia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Change volume
                // Show toast & play sound
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_SHOW_UI + AudioManager.FLAG_PLAY_SOUND);
            }
        });

        //register OnSeekBarChangeListener to enable alarm volume changing
        sbVolumeAlarm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Change volume
                // Show toast & play sound
                audioManager.setStreamVolume(AudioManager.STREAM_ALARM, progress, AudioManager.FLAG_SHOW_UI + AudioManager.FLAG_PLAY_SOUND);
            }
        });
    }
}
