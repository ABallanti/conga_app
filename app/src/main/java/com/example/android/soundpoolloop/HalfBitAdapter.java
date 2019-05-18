// https://demonuts.com/listview-checkbox/

package com.example.android.soundpoolloop;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import android.widget.TextView;
import com.example.android.soundpoolloop.R;
import java.util.List;
import org.w3c.dom.Text;


public class HalfBitAdapter extends BaseAdapter {

  // CLASSES DECLARATION
  class ViewHolder {
    TextView HalfBitText;
    CheckBox checkBox;
    Boolean[] isChecked;
  }

  private Context context;
  private List<Item> list;

  HalfBitAdapter(Context c, List<Item> l) {
    context = c;
    list = l;
  }

  @Override
  public int getCount() {
    return list.size();
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public Object getItem(int position) {
    return list.get(position);
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    View HalfBitView = convertView;

    // Create view holders
    ViewHolder BaseVH = new ViewHolder();
    ViewHolder MuteVH = new ViewHolder();
    ViewHolder OpenVH = new ViewHolder();
    ViewHolder SlapVH = new ViewHolder();
    ViewHolder TouchVH = new ViewHolder();

    ViewHolder CowBellVH = new ViewHolder();

    ViewHolder TextBit= new ViewHolder();
    ViewHolder TextBit2= new ViewHolder();

    ViewHolder[] StrokesVH_Array;

    int[] AudioCB_Array;

    StrokesVH_Array  = new ViewHolder[]{BaseVH, MuteVH, OpenVH, SlapVH, TouchVH,CowBellVH,TextBit,TextBit2};

    AudioCB_Array = new int[]{R.id.BaseCbk, R.id.MuteCbk, R.id.OpenCbk, R.id.SlapCbk,
        R.id.TouchCbk,R.id.CowBellCbk,R.id.HalfBitText,R.id.HalfBitText2};

    if (HalfBitView == null) {
      LayoutInflater inflater = ((Activity) context).getLayoutInflater();
      HalfBitView = inflater.inflate(R.layout.list_halfbit, parent, false);

      for (int i = 0; i < AudioCB_Array.length-2; i++) {
        StrokesVH_Array[i].checkBox = HalfBitView.findViewById(AudioCB_Array[i]);
      }
      StrokesVH_Array[AudioCB_Array.length-2].HalfBitText=HalfBitView.findViewById(AudioCB_Array[AudioCB_Array.length-2]);
      StrokesVH_Array[AudioCB_Array.length-1].HalfBitText=HalfBitView.findViewById(AudioCB_Array[AudioCB_Array.length-1]);

      HalfBitView.setTag(StrokesVH_Array);
    } else {
      StrokesVH_Array = (ViewHolder[]) HalfBitView.getTag();
    }

    StrokesVH_Array[0].checkBox.setChecked(list.get(position).BaseChecked);
    StrokesVH_Array[1].checkBox.setChecked(list.get(position).MuteChecked);
    StrokesVH_Array[2].checkBox.setChecked(list.get(position).OpenChecked);
    StrokesVH_Array[3].checkBox.setChecked(list.get(position).SlapChecked);
    StrokesVH_Array[4].checkBox.setChecked(list.get(position).TouchChecked);
    StrokesVH_Array[5].checkBox.setChecked(list.get(position).CowBellChecked);

    StrokesVH_Array[6].HalfBitText.setText(list.get(position).HalfBitText);
    StrokesVH_Array[7].HalfBitText.setText(list.get(position).HalfBitText2);


    // When the checkbox is clicked
    StrokesVH_Array[0].checkBox.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            final boolean[] newState;
            newState = list.get(position).isChecked();
            list.get(position).BaseChecked = !newState[0];
          }
        });
    StrokesVH_Array[0].checkBox.setChecked(list.get(position).BaseChecked);

    StrokesVH_Array[1].checkBox.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            final boolean[] newState;
            newState = list.get(position).isChecked();
            list.get(position).MuteChecked = !newState[1];
          }
        });
    StrokesVH_Array[1].checkBox.setChecked(list.get(position).MuteChecked);

    StrokesVH_Array[2].checkBox.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            final boolean[] newState;
            newState = list.get(position).isChecked();
            list.get(position).OpenChecked = !newState[2];
          }
        });
    StrokesVH_Array[2].checkBox.setChecked(list.get(position).OpenChecked);

    StrokesVH_Array[3].checkBox.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            final boolean[] newState;
            newState = list.get(position).isChecked();
            list.get(position).SlapChecked = !newState[3];
          }
        });
    StrokesVH_Array[3].checkBox.setChecked(list.get(position).SlapChecked);

    StrokesVH_Array[4].checkBox.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            final boolean[] newState;
            newState = list.get(position).isChecked();
            list.get(position).TouchChecked = !newState[4];
          }
        });
    StrokesVH_Array[4].checkBox.setChecked(list.get(position).TouchChecked);

    StrokesVH_Array[5].checkBox.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            final boolean[] newState;
            newState = list.get(position).isChecked();
            list.get(position).CowBellChecked = !newState[5];
          }
        });
    StrokesVH_Array[5].checkBox.setChecked(list.get(position).CowBellChecked);

    return HalfBitView;
  }

}
