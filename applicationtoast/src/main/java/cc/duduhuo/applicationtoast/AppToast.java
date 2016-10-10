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
 * =======================================================
 * 版权：©Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying
 * 日期：2016/10/10 21:14
 * 版本：1.0
 * 描述：ApplicationContext Toast
 * 备注：
 * =======================================================
 */

public class AppToast {
    private static Toast toast = null;  // 全局Toast
    public static final String TAG = "AppToast";
    // 全局ApplicationContext
    private static Application app;

    /**
     * AppToast初始化
     *
     * @param application Application <br/>
     *                    在应用相应的Application类中的onCreate方法中进行此初始化工作。<br/>
     *                    <b>不要忘记在AndroidManifest文件的application节点下配置android:name属性。</b>
     */
    public static void init(Application application) {
        app = application;
    }

    /**
     * 不允许实例化这个类
     */
    private AppToast() {
        throw new Error("Don't instantiate this class");
    }

    /**
     * @hide
     */
    @IntDef({LENGTH_SHORT, LENGTH_LONG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    /**
     * 显示Toast
     *
     * @param resId string类型的资源Id
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
     * 显示Toast
     *
     * @param msg 显示的信息
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
     * 显示Toast
     *
     * @param resId    string类型的资源Id
     * @param duration 显示时长. Either {@link  android.widget.Toast#LENGTH_SHORT} or
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
     * 显示Toast
     *
     * @param msg      显示的信息
     * @param duration 显示时长. Either {@link  android.widget.Toast#LENGTH_SHORT} or
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
     * 得到Toast对象 <br/>
     * 需要调用show()方法才可以显示
     *
     * @return Toast实例
     */
    public static Toast getToast() {
        if (toast == null) {
            // 只是为了得到Toast对象，不需要调用show方法
            toast = Toast.makeText(app, "", LENGTH_SHORT);
        }
        return toast;
    }

    /**
     * 得到全局Application
     *
     * @return 全局Application
     */
    public static Application getApplication() {
        return app;
    }
}
