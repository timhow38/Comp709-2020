package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
 
public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private ConstraintSet constraintSetOld = new ConstraintSet();
    private ConstraintSet constraintSetNew = new ConstraintSet();
    private boolean altLayout;
 
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        layout = findViewById(R.id.layout);
 
        constraintSetOld.clone(layout);
        constraintSetNew.clone(this, R.layout.activity_main_alt);
    }
 
    public void swapView(View v) {
        Transition changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new OvershootInterpolator());
 
        TransitionManager.beginDelayedTransition(layout, changeBounds);
 
        if (!altLayout) {
            constraintSetNew.applyTo(layout);
            altLayout = true;
        } else {
            constraintSetOld.applyTo(layout);
            altLayout = false;
        }
    }
}