package cn.wushige.app_android.util;

import android.app.Activity;

import java.util.Stack;

/**
 * <p>
 *
 * </p>
 *
 * @author wushige
 * @date 2016-08-01 14:27
 */
public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager mInstance;

    private AppManager() {}


    public static AppManager getAppManager() {
        if (mInstance == null) {
            synchronized (AppManager.class) {
                if (mInstance == null) {
                    mInstance = new AppManager();
                }
            }
        }
        return mInstance;
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity);
        }
    }


    public Activity curremtActivity() {
        return activityStack.lastElement();
    }


    public void finishActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity) && !activity.isFinishing()) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    public void finishAllActivity() {
        for (int i= 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }


}
