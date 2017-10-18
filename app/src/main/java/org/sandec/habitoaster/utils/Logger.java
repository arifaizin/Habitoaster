package org.sandec.habitoaster.utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.analytics.FirebaseAnalytics;

@SuppressWarnings("unused")
public class Logger {

    public static void debug(String Tag, String message) {
        Log.d(Tag, message);
    }

    public static void firebaseAnalyticsEvent(@NonNull FirebaseAnalytics firebaseAnalytics, String contentType, Bundle bundle) {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
