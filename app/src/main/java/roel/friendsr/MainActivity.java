package roel.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fill an arrayList with friend objects containing GOT names and pictures
        ArrayList<Friend> friends = new ArrayList<Friend>();
        String[] names = {"Arya", "Cersei", "Daeynerys", "Jaime", "Jon", "Jorah", "Margaery",
                            "Melisandre", "Sansa", "Tyrion",};
        int[] drawableIds = {R.drawable.arya,
                            R.drawable.cersei,
                            R.drawable.daenerys,
                            R.drawable.jaime,
                            R.drawable.jon,
                            R.drawable.jorah,
                            R.drawable.margaery,
                            R.drawable.melisandre,
                            R.drawable.sansa,
                            R.drawable.tyrion,};
        String lorem = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.";
        String[] bios = {"Lorem ipsum blablabla Ik kan van gezicht veranderen",
                        "Incest is wincest",
                        lorem,
                        lorem,
                        lorem,
                        lorem,
                        lorem,
                        lorem,
                        lorem,
                        lorem,
                        lorem,
        };

        for (int i = 0; i < names.length; i++){
            friends.add(new Friend(names[i], bios[i], drawableIds[i]));
        }

        GridView gridView = findViewById(R.id.gridView);

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_card, friends);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new GridItemClickListener());
    }

}
