package roel.friendsr;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

    public FriendsAdapter(Context context, int resourceId, ArrayList<Friend> FriendList) {
        super(context, resourceId, FriendList);
        friends = FriendList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // Get the friend at this position
        Friend thisFriend = friends.get(position);

        // Set the PF and name of this friend
        ImageView gridPf = (ImageView) convertView.findViewById(R.id.pf);
        gridPf.setImageResource(thisFriend.getDrawableId());

        TextView gridName = (TextView) convertView.findViewById(R.id.name);
        gridName.setText(thisFriend.getName());

        return convertView;
    }
}
