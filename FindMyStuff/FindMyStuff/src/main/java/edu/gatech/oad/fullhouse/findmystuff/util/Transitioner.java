package edu.gatech.oad.fullhouse.findmystuff.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Transitioner {
    private final Handler handler = new Handler();
    private Activity activity; 

    public Transitioner(Activity activity) {
        this.activity = activity;
    }

    /**
     * Transition to a new view.
     * 
     * NOTE: this method is final, to reduce the amount of work a subclass needs
     * to do to hook into the transition process.  Simply override the other method
     * and rest assured it will be called.
     * 
     * @param presenter
     */
    public final void transitionTo(Class<? extends Activity> activityClass) {
        try {
            transitionTo(activityClass, null, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public final void transitionTo(Class<? extends Activity> activityClass, Bundle arguments) {
        try {
            transitionTo(activityClass, arguments, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void transitionToAndFinish(Class<? extends Activity> activityClass) {
        try {
            transitionTo(activityClass, null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    public final void transitionToAndFinish(Class<? extends Activity> activityClass, Bundle arguments) {
        try {
            transitionTo(activityClass, arguments, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    protected void transitionTo(Class<? extends Activity> activityClass, Bundle arguments, boolean finish) {
        handler.post(new TransitionRunnable(activityClass, arguments));
        if (finish) {
            Transitioner.this.activity.finish();
        }
    }
    
    private class TransitionRunnable implements Runnable {

        private Class<? extends Activity> activityClass;
        private Bundle arguments;

        public TransitionRunnable(Class<? extends Activity> activityClass, Bundle arguments) {
            this.activityClass = activityClass;
            this.arguments     = arguments;
        }

        public void run() {
            Intent intent = new Intent();
            intent.setClass(Transitioner.this.activity, this.activityClass);
            if (this.arguments != null) {
                intent.putExtras(arguments);
            }
            Transitioner.this.activity.startActivity(intent);
        }
    }
}
