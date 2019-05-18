package com.example.android.soundpoolloop;

public class Item {

  boolean BaseChecked;
  boolean MuteChecked;
  boolean OpenChecked;
  boolean SlapChecked;
  boolean TouchChecked;
  boolean CowBellChecked;
  String HalfBitText;
  String HalfBitText2;

  Item(String t, boolean b,boolean c) {
    HalfBitText = t;
    BaseChecked = b;
    MuteChecked = c;
    HalfBitText2=HalfBitText;
  }

  public boolean[] isChecked() {
    return new boolean[]{BaseChecked, MuteChecked,OpenChecked,SlapChecked,TouchChecked,CowBellChecked};
  }

  public String getItemString() {
    return HalfBitText;
  }
}