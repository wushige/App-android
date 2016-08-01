package cn.wushige.app_android.util;

/**
 * <p>
 * </p>
 *
 * @author wushige
 * @date 2016-08-01 14:40
 */
public abstract class Singleton<T, P> {
    private volatile  T mInstance;

    protected abstract T create(P p);

    public final T get(P p) {
        if (mInstance == null) {
            synchronized (this) {
                if (mInstance == null) {
                    mInstance = create(p);
                }
            }
        }
        return mInstance;
    }
}
