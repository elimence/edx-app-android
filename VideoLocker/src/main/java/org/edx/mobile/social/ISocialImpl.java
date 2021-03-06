package org.edx.mobile.social;

import android.app.Activity;

import java.lang.ref.WeakReference;

public abstract class ISocialImpl implements ISocial {
    
    protected ISocial.Callback callback;
    private WeakReference<Activity> activity;
    
    public ISocialImpl(Activity activity) {
        this.activity = new WeakReference<Activity>(activity);
    }
    
    @Override
    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Activity getActivity(){
        Activity wrapped = activity.get();
        if ( wrapped != null ){
            return wrapped.isFinishing() || wrapped.isDestroyed() ? null : wrapped;
        }
        return wrapped;
    }
}
