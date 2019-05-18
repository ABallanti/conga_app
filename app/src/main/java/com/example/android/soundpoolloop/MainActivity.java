package com.example.android.soundpoolloop;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.Handler;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  public static final int BaseSound = 1;
  public static final int MuteSound = 2;
  public static final int OpenSound = 3;
  public static final int SlapSound = 4;
  public static final int TouchSound = 5;
  public static final int SilenceSound = 6;
  public static final int ClaveSound = 7;
  public static final int CataSound = 8;
  public static final int CowBellSound=9;

  SoundPool mSoundPool;
  HashMap<Integer, Integer> mSoundMap;
  int speed = 300;
  float cataVolume;
  float claveVolume;
  float cowbellVolume;

  public void playSound(int sound) {
    AudioManager mgr = (AudioManager) MainActivity.this.getSystemService(Context.AUDIO_SERVICE);
    float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
    float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    float volume = streamVolumeCurrent / streamVolumeMax;
    if (mSoundPool != null) {
      mSoundPool.play(mSoundMap.get(sound), volume, volume, 0, 0, 1.0f);
    }
  }

  // =============
  private Handler handler = new Handler();
  int SoundID = 0;

  List<Integer> SoundIDList;
  List<Integer> CowBellIDList;
  Boolean IsClaveOn=false;
  Boolean IsCataOn=false;
  Boolean IsCowBellOn=false;

  // ===================

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ArrayList<Item> Arrayhalfbitdata = new ArrayList<>();

    Arrayhalfbitdata.add(new Item("1", false, false));
    Arrayhalfbitdata.add(new Item("+", false, false));
    Arrayhalfbitdata.add(new Item("2", false, false));
    Arrayhalfbitdata.add(new Item("+", false, false));
    Arrayhalfbitdata.add(new Item("3", false, false));
    Arrayhalfbitdata.add(new Item("+", false, false));
    Arrayhalfbitdata.add(new Item("4", false, false));
    Arrayhalfbitdata.add(new Item("+", false, false));
    Arrayhalfbitdata.add(new Item("5", false, false));
    Arrayhalfbitdata.add(new Item("+", false, false));
    Arrayhalfbitdata.add(new Item("6", false, false));
    Arrayhalfbitdata.add(new Item("+", false, false));
    Arrayhalfbitdata.add(new Item("7", false, false));
    Arrayhalfbitdata.add(new Item("+", false, false));
    Arrayhalfbitdata.add(new Item("8", false, false));
    Arrayhalfbitdata.add(new Item("+", false, false));

    // Create a new adapter
    HalfBitAdapter adapter = new HalfBitAdapter(this, Arrayhalfbitdata);

    // List view containing the half bit
    final ListView halfbitListView = findViewById(R.id.ListHalfBit);
    halfbitListView.setAdapter(adapter);

    Button playbtn =  findViewById(R.id.playbtn);
    Button stopbtn =  findViewById(R.id.stopbtn);
    final CheckBox ClaveOn =  findViewById(R.id.ThreeTwoRumbaclave);
    final CheckBox CataOn =  findViewById(R.id.Cata);
    final CheckBox CowBellOn =  findViewById(R.id.CowBell);

    final SeekBar catavolume =  findViewById(R.id.CataSKB);
    final SeekBar speedbar =  findViewById(R.id.speedBar);
    final SeekBar clavevolume =  findViewById(R.id.ThreeTwoRumbaClaveSKB);
    final SeekBar cowbellvolume = findViewById(R.id.CowBellSKB);

    speedbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        speed = 400 - progress;
      }
      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }
      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });

    catavolume.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        cataVolume = (float)progress/10;
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });

    clavevolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        claveVolume = (float) progress/10;
      }
      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }
      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });

    cowbellvolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        cowbellVolume = (float) progress/10;
      }
      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }
      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });


        mSoundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
    mSoundMap = new HashMap<>();

    if (mSoundPool != null) {
      mSoundMap.put(BaseSound, mSoundPool.load(this, R.raw.base_fast, 1));
      mSoundMap.put(SlapSound, mSoundPool.load(this, R.raw.slap_fast, 1));
      mSoundMap.put(OpenSound, mSoundPool.load(this, R.raw.open_fast, 1));
      mSoundMap.put(SilenceSound, mSoundPool.load(this, R.raw.silence_fast, 1));
      mSoundMap.put(TouchSound, mSoundPool.load(this, R.raw.touch_fast, 1));
      mSoundMap.put(MuteSound, mSoundPool.load(this, R.raw.muff_fast, 1));
      mSoundMap.put(ClaveSound, mSoundPool.load(this, R.raw.clave_fast, 1));
      mSoundMap.put(CataSound, mSoundPool.load(this, R.raw.cata_fast, 1));
      mSoundMap.put(CowBellSound, mSoundPool.load(this, R.raw.cow_bell_fast, 1));
    }

    ClaveOn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        final boolean ClaveState;
        ClaveState = ClaveOn.isChecked();
        IsClaveOn = ClaveState;
      }
    });

    CataOn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        final boolean CataState;
        CataState = CataOn.isChecked();
        IsCataOn = CataState;
      }
    });

    CowBellOn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        final boolean CowBellState;
        CowBellState = CowBellOn.isChecked();
        IsCowBellOn = CowBellState;
      }
    });

    playbtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

        SoundIDList = new ArrayList<>();
        CowBellIDList= new ArrayList<>();
        // check the actual series of checkbox

        // Create the soundTrack
        for (int Position = 0; Position <= 15; Position++) {

          Item CurrentHalfBitData = (Item) (halfbitListView
              .getItemAtPosition(Position));

          boolean StrokeID[];
          StrokeID = CurrentHalfBitData.isChecked();

          if (StrokeID[5]) {
            CowBellIDList.add(CowBellSound);
          } else {
            CowBellIDList.add(SilenceSound);
          }

          if (StrokeID[0]) {
            SoundIDList.add(BaseSound);
          } else if (StrokeID[1]) {
            SoundIDList.add(MuteSound);
          } else if (StrokeID[2]) {
            SoundIDList.add(OpenSound);
          } else if (StrokeID[3]) {
            SoundIDList.add(SlapSound);
          } else if (StrokeID[4]) {
            SoundIDList.add(TouchSound);
          } else {
            SoundIDList.add(SilenceSound);
          }
         }
        handler.postDelayed(soundR, speed);
        // ===============

      }
    });

    stopbtn.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick (View v){
          stopRepeating(v);
          //mSoundPool.release();
        }

    });
  }

  public void stopRepeating(View v) {
    handler.removeCallbacks(soundR);
    SoundID = 0;
  }

  // The runnable encapsulate the code we want to execute after the delay
  private Runnable soundR = new Runnable() {
    @Override
    public void run() {
      playSound(SoundIDList.get(SoundID));
      if (IsCowBellOn) {
        mSoundPool.play(mSoundMap.get(CowBellIDList.get(SoundID)), cowbellVolume, cowbellVolume, 0, 0,
                1.0f);
      }
      if (IsClaveOn) {
        if (SoundID == 0 || SoundID == 3 || SoundID == 7 || SoundID == 10 || SoundID == 12) {
          mSoundPool.play(mSoundMap.get(ClaveSound), claveVolume, claveVolume, 0, 0, 1.0f);
        }
      }

      if (IsCataOn) {
        if (SoundID == 0 || SoundID == 2 || SoundID == 3 || SoundID == 5 || SoundID == 7 || SoundID == 8 || SoundID == 10 || SoundID == 12|| SoundID == 13|| SoundID == 15) {
          mSoundPool.play(mSoundMap.get(CataSound), cataVolume, cataVolume, 0, 0, 1.0f);        }
      }

      if (SoundID == 15) {
        SoundID = 0;
      } else {
        SoundID = SoundID + 1;
        }
        handler.postDelayed(this, speed);
      }
    };


}
