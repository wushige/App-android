package cn.wushige.app_android.presenter.base;

import android.app.Activity;

import cn.wushige.app_android.data.DataManager;
import cn.wushige.app_android.model.exception.ErrorHanding;
import cn.wushige.app_android.ui.base.IView;
import cn.wushige.app_android.util.ToastUtils;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * <p>
 * Base Presenter：所有的Presenter都必须继承此类
 * </p>
 *
 * @author wushige
 * @date 2016-08-01 14:40
 */
public abstract class BasePresenter<V extends IView> implements IPresenter<V> {

    protected Activity mActivity;
    protected V mView;
    protected CompositeSubscription mCompositeSubscription;
    protected DataManager dataManager;

    public BasePresenter(DataManager dataManager, Activity activity) {
        this.dataManager = dataManager;
        this.mActivity = activity;
    }

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    protected void handleError(Throwable throwable) {
        ToastUtils.show(mActivity, ErrorHanding.handleError(throwable));
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
