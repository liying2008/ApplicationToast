package cc.duduhuo.applicationtoast;

import android.app.Application;
import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

/**
 * ==========================================================<br>
 * Copyright: Copyright LiYing 2015-2016. All rights reserved.<br>
 * Author: liying<br>
 * DateAndTime: 2016/10/10 21:14<br>
 * Version: 0.2<br>
 * Description: ApplicationContext Toast<br>
 * Remarks:<br>
 * ==========================================================<br>
 */

public class AppToast {
    private static Toast toast = null;  // Global Toast
    public static final String TAG = "AppToast";
    // Global ApplicationContext
    private static Application app;

    /**
     * AppToast initialization
     *
     * @param application Application <br>
     *                    This initialization is done in the onCreate method of the corresponding Application class.<br>
     *                    <b>Do not forget to configure the android: name attribute under the application node of the AndroidManifest file.</b>
     */
    public static void init(Application application) {
        app = application;
    }

    /**
     * It is not allowed to instantiate this class.
     */
    private AppToast() {
        throw new Error("Don't instantiate this class");
    }

    @IntDef({LENGTH_SHORT, LENGTH_LONG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    /**
     * Display Toast
     *
     * @param resId The resource id of the string resource to use.  Can be formatted text.
     */
    public static void showToast(@StringRes int resId) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(app, resId, LENGTH_SHORT);
        toast.show();
    }

    /**
     * Display Toast
     *
     * @param msg The text to show.  Can be formatted text.
     */
    public static void showToast(CharSequence msg) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(app, msg, LENGTH_SHORT);
        toast.show();
    }

    /**
     * Display Toast
     *
     * @param resId    The resource id of the string resource to use.  Can be formatted text.
     * @param duration How long to display the message. Either {@link  android.widget.Toast#LENGTH_SHORT} or
     *                 {@link android.widget.Toast#LENGTH_LONG}
     */
    public static void showToast(@StringRes int resId, @Duration int duration) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(app, resId, duration);
        toast.show();
    }

    /**
     * Display Toast
     *
     * @param msg      The text to show.  Can be formatted text.
     * @param duration How long to display the message. Either {@link  android.widget.Toast#LENGTH_SHORT} or
     *                 {@link android.widget.Toast#LENGTH_LONG}
     */
    public static void showToast(CharSequence msg, @Duration int duration) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(app, msg, duration);
        toast.show();
    }

    /**
     * Get a Toast object <br>
     * Need to call show() method to be displayed
     *
     * @return Toast object.
     */
    public static Toast getToast() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(app, "", Toast.LENGTH_SHORT);
        return toast;
    }

    /**
     * Get a global Application
     *
     * @return global Application
     */
    public static Application getApplication() {
        return app;
    }
}
