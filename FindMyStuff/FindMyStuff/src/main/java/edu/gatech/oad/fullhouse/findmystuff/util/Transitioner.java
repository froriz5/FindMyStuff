package edu.gatech.oad.fullhouse.findmystuff.util;

import android.app.Activity;
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
            transitionTo(activityClass, null, false, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public final void transitionTo(Class<? extends Activity> activityClass, Bundle arguments) {
        try {
            transitionTo(activityClass, arguments, false, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void transitionToAndFinish(Class<? extends Activity> activityClass) {
        try {
            transitionTo(activityClass, null, true, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    public final void transitionToAndFinish(Class<? extends Activity> activityClass, Bundle arguments) {
        try {
            transitionTo(activityClass, arguments, true, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    public final void transitionToAndGetResult(Class<? extends Activity> activityClass, int requestCode) {
        try {
            transitionTo(activityClass, null, false, requestCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    protected void transitionTo(Class<? extends Activity> activityClass, Bundle arguments, boolean finish, Integer requestCode) {
        handler.post(new TransitionRunnable(activityClass, arguments, requestCode));
        if (finish) {
            Transitioner.this.activity.finish();
        }
    }
    
    private class TransitionRunnable implements Runnable {

        private Class<? extends Activity> activityClass;
        private Bundle arguments;
        private Integer requestCode;

        public TransitionRunnable(Class<? extends Activity> activityClass, Bundle arguments, Integer requestCode) {
            this.activityClass = activityClass;
            this.arguments     = arguments;
            this.requestCode   = requestCode;
        }

        public void run() {
            Intent intent = new Intent();
            intent.setClass(Transitioner.this.activity, this.activityClass);
            if (this.arguments != null) {
                intent.putExtras(arguments);
            }
            if (requestCode != null) {
                Transitioner.this.activity.startActivityForResult(intent, requestCode);
            } else {
                Transitioner.this.activity.startActivity(intent);
            }
        }
    }
}
