package cn.wushige.app_android.presenter.base;

import cn.wushige.app_android.ui.base.IView;

/**
 * <p>
 * Presenter Interface：定义presenter基本方法
 * </p>
 *
 * @author wushige
 * @date 2016-08-01 14:40
 */
public interface IPresenter<V extends IView> {

    void attachView(V view);

    void detachView();
}
