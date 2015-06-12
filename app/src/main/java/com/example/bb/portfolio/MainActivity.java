package com.example.bb.portfolio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


// TODO: learn how to style ripples
// TODO: there has to be a simple, declarative way to tint the buttons

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tint the buttons programmatically. That's the one technique
        // I've found that doesn't ruin ripples and is backward-compatible.

        // Seems we can't use android:background because that interferes with ripples.
        // And android:colorButtonNormal or android:backgroundTint are not available
        // on older API levels.
        // See http://stackoverflow.com/questions/27735890/lollipops-backgroundtint-has-no-effect-on-a-button
        int buttons[] = { R.id.button1, R.id.button2, R.id.button3
                        , R.id.button4, R.id.button5};
        ColorStateList csl = getResources().getColorStateList(R.color.regular_button);
        for (int b : buttons) {
            Button button = (Button) findViewById(b);
            setColorStateList(button, csl);
        }
        Button capstoneB = (Button) findViewById(R.id.button6);
        csl = getResources().getColorStateList(R.color.capstone_button);
        setColorStateList(capstoneB, csl);
    }

    private void setColorStateList(Button button, ColorStateList csl) {
        if (! (button instanceof AppCompatButton)) {
            return;
        }
        AppCompatButton acb = (AppCompatButton) button;
        acb.setSupportBackgroundTintList(csl);
    }

    // Placeholders

    public void onButtonClick(View view) {
        showToast("Launch Spotify Streamer");
    }

    public void onButton2Click(View view) {
        showToast("Launch Scores App");
    }

    public void onButton3Click(View view) {
        showToast("Launch Library App");
    }

    public void onButton4Click(View view) {
        showToast("Launch Build It Bigger");
    }

    public void onButton5Click(View view) {
        showToast("Launch XYZ Reader");
    }

    public void onButton6Click(View view) {
        showToast("Launch Capstone App!");
    }

    private void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
