package com.pascalwelsch.goprowearremote.net;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import android.util.Log;

/**
 * @author Pascal Welsch
 * @since 25.06.14.
 */
public final class GoProAction {

    public static final int TAKE_PHOTO = 10;

    public static final int START_VIDEO = 20;

    public static final int STOP_VIDEO = 21;

    public static final int SWITCH_TO_PHOTO = 1;

    public static final int SWITCH_TO_VIDEO = 2;

    public static final int POWER_ON = 30;

    public static final int POWER_OFF = 31;

    private static final String TAG = GoProAction.class.getSimpleName();

    private GoProAction() {

    }

    public static void fireGoProCommand(final String type, final String command,
            final boolean isBacpacRequest, final String password, RequestQueue queue) {

        final GoProRequest goProRequest = new GoProRequest(password, type, command,
                isBacpacRequest,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(final VolleyError volleyError) {
                        Log.v(TAG, volleyError.toString());
                    }
                }
        );
        queue.add(goProRequest);
    }
}
