package com.codinginflow.constraintlayout;
 
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
 
public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private Placeholder placeholder;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        layout = findViewById(R.id.layout);
        placeholder = findViewById(R.id.placeholder);
    }
 
    public void swapView(View v) {
        TransitionManager.beginDelayedTransition(layout);
        placeholder.setContentId(v.getId());
    }
}