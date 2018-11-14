package roel.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    public FriendsAdapter(Context context, int resourceId, ArrayList<Friend> FriendList) {
        private ArrayList<Friend> friends = FriendList;
        super(context, resourceId, friends);
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        return convertView;
    }
}

