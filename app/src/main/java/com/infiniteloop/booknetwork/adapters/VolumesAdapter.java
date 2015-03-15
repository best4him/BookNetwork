package com.infiniteloop.booknetwork.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.infiniteloop.booknetwork.R;
import com.infiniteloop.booknetwork.models.Volume;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Gherasim on 1/9/2015.
 */
public class VolumesAdapter extends BaseAdapter {

    ArrayList<Volume> mEvents;
    Context mContext;

    public VolumesAdapter(Context context, ArrayList<Volume> events) {

        mEvents = events;
        mContext = context;
    }

    @Override
    public Volume getItem(int i) {
        return mEvents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if(convertView == null){

            convertView = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.cell_volume, viewGroup, false);

            VolumeViewHolder viewHolder = new VolumeViewHolder();

            viewHolder.title = (TextView) convertView.findViewById(R.id.cell_volumeTitle);
            viewHolder.subtitle = (TextView) convertView.findViewById(R.id.cell_volumeSubTitle);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.cell_volumeImageView);

            convertView.setTag(viewHolder);

        }

        VolumeViewHolder viewHolder = (VolumeViewHolder)convertView.getTag();

        viewHolder.title.setText(getItem(i).getVolumeInfo().getTitle());
        viewHolder.title.setText(getItem(i).getVolumeInfo().getSubtitle());
        if(getItem(i).getVolumeInfo().getImageLinks() != null)Picasso.with(mContext).load(getItem(i).getVolumeInfo().getImageLinks().getThumbnail()).into(viewHolder.image);

        return convertView;
    }

    @Override
    public int getCount() {

        if(mEvents == null){

            return 0;
        } else {
            return mEvents.size();
        }
    }

    public class VolumeViewHolder {

        TextView title;
        TextView subtitle;
        ImageView image;
    }
}
