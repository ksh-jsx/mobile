package google.shkim.example.com.mp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kj.lee on 2017. 9. 26..
 */

public class ListAdapter extends BaseAdapter
{
    LayoutInflater inflater = null;
    private ArrayList<ItemData> m_oData = null;
    private int nListCnt = 0;
    private int i=0;
    String dateSave = " ";
    private static final String DEBUG_TAG = "{LOG_ANDROID}";
    public ListAdapter(ArrayList<ItemData> _oData)
    {
        m_oData = _oData;
        nListCnt = m_oData.size();
    }

    @Override
    public int getCount()
    {
        Log.i("TAG", "getCount");
        return nListCnt;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if(position ==0)
            dateSave ="a";
        if (convertView == null)
        {
            final Context context = parent.getContext();
            if (inflater == null)
            {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView oTextTitle = (TextView) convertView.findViewById(R.id.textTitle);
        TextView oTextTIme = (TextView) convertView.findViewById(R.id.textTime);
        TextView oTextDate = (TextView) convertView.findViewById(R.id.textDate);
        TextView oTextLat = (TextView) convertView.findViewById(R.id.textLat);
        TextView oTextLng = (TextView) convertView.findViewById(R.id.textLng);
        TextView oimgName = (TextView)convertView.findViewById(R.id.imgName);
        LinearLayout dateLinear = (LinearLayout)convertView.findViewById(R.id.dateLinear);
        LinearLayout etc = (LinearLayout)convertView.findViewById(R.id.etc);
        ImageView lineImage = (ImageView)convertView.findViewById(R.id.lineImage);

        if(dateSave.equals(m_oData.get(position).strDate))
        {
            dateLinear.setVisibility(View.GONE);
            etc.setVisibility(View.VISIBLE);
            Log.d(DEBUG_TAG, "count1: " +m_oData.get(position).count1);
            Log.d(DEBUG_TAG, "count2: " +m_oData.get(position).count2);
            if(m_oData.get(position).count1 == m_oData.get(position).count2)
            {
                lineImage.setImageResource(R.drawable.line_blue_non_bottom);
                oimgName.setText("last");
            }
        }
        else
        {
            Log.d(DEBUG_TAG, "hello");
            dateLinear.setVisibility(View.VISIBLE);
            etc.setVisibility(View.GONE);

        }


        oTextTitle.setText(m_oData.get(position).strTitle);
        oTextTitle.setTag(position);
        oTextTIme.setText(m_oData.get(position).strTIme);
        oTextDate.setText(m_oData.get(position).strDate);
        oTextLat.setText(m_oData.get(position).strLat);
        oTextLng.setText(m_oData.get(position).strLng);
        dateSave = m_oData.get(position).strDate;
        return convertView;
    }


}

