package com.oguzdev.circularfloatingactionmenu.samples;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MenuWithCustomActionButtonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_with_custom_action_button);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CustomButtonDemoFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_with_custom_action_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class CustomButtonDemoFragment extends Fragment {
        public CustomButtonDemoFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_menu_with_custom_action_button, container, false);
            // Our action button is this time just a regular view!
            FloatingActionButton centerActionButton = (FloatingActionButton) rootView.findViewById(R.id.centerActionButton);
            // Add some items to the menu. They are regular views as well!
            FloatingActionButton a = new FloatingActionButton(getActivity());
            a.setBackgroundTintList(getResources().getColorStateList(android.R.color.white));
            FloatingActionButton b = new FloatingActionButton(getActivity());
            b.setBackgroundTintList(getResources().getColorStateList(android.R.color.darker_gray));
            FloatingActionButton c = new FloatingActionButton(getActivity());
            c.setBackgroundTintList(getResources().getColorStateList(android.R.color.holo_red_dark));
            FloatingActionButton d = new FloatingActionButton(getActivity());
            d.setBackgroundTintList(getResources().getColorStateList(android.R.color.holo_orange_light));
            FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            a.setLayoutParams(tvParams);
            b.setLayoutParams(tvParams);
            c.setLayoutParams(tvParams);
            d.setLayoutParams(tvParams);
            SubActionButton.Builder subBuilder = new SubActionButton.Builder(getActivity());
            FloatingActionMenu circleMenu = new FloatingActionMenu.Builder(getActivity())
                    .setStartAngle(90) // A whole circle!
                    .setEndAngle(360)
                    .setRadius(getResources().getDimensionPixelSize(R.dimen.radius_large))
                    .addSubActionView(a)
                    .addSubActionView(b)
                    .addSubActionView(c)
                    .addSubActionView(d)
                    .attachTo(centerActionButton)
                    .build();
            return rootView;
        }
    }
}