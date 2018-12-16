package roel.friendsr;

import android.content.Context;
import android.support.v7.widget.CardView;
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
    private Context context;
    String tag = "FriendsAdapter";
    public FriendsAdapter(Context c, int resourceId, ArrayList<Friend> FriendList) {
        super(c, resourceId, FriendList);
        this.context = c;
        friends = FriendList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_card, parent, false);
        }

        int viewHeight = (parent.getHeight()/2) - (parent.getHeight()/64);
        int viewWidth = (parent.getWidth()/2) - (parent.getWidth()/64);
        convertView.setLayoutParams(new CardView.LayoutParams(viewWidth, viewHeight));
        // Get the friend at this position
        Friend thisFriend = friends.get(position);

        // Set the PF and name of this friend
        ImageView gridPf = convertView.findViewById(R.id.image);
        gridPf.setImageResource(thisFriend.getDrawableId());

        TextView gridName = convertView.findViewById(R.id.name);
        gridName.setText(thisFriend.getName());

        return convertView;
    }

}
