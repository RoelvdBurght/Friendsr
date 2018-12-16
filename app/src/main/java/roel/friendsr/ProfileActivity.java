package roel.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    private Friend thisFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
        thisFriend = retrievedFriend;

        // sets the name and profile pic
        int profilePic = retrievedFriend.getDrawableId();
        ImageView imageViewPf = (ImageView) findViewById(R.id.imageView);
        imageViewPf.setImageResource(profilePic);

        String name = retrievedFriend.getName();
        TextView namePP = (TextView) findViewById(R.id.name);
        namePP.setText(retrievedFriend.getName());

        // sets the bio
        TextView bio = (TextView) findViewById(R.id.bio);
        bio.setText(retrievedFriend.getBio());

        // set the previous score to the ratingbar, or if there is none
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        String user = prefs.getString("friendName", null);

        float score;
        if (user != null) {
            score = prefs.getFloat(name, 0);
        }
        else {
            score = 0;
        }

        RatingBar friendScore = findViewById(R.id.rating);
        friendScore.setOnRatingBarChangeListener(new OnRatingBarChangeListener());
        friendScore.setRating(score);
    }

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            Log.d("tag", thisFriend.getName());
            editor.putFloat(thisFriend.getName(), rating);
            editor.commit();
        }
    }
}
