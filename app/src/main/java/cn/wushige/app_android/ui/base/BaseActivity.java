package cn.wushige.app_android.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import cn.wushige.app_android.presenter.base.IPresenter;
import cn.wushige.app_android.util.AppManager;

/**
 * <p>
 * Base Activity：所有的Activity都必须继承此类
 * </p>
 *
 * @author wushige
 * @date 2016-08-01 14:27
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView {

    @Inject
    protected P mPresenter;
    protected Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        if (mPresenter != null) mPresenter.attachView(this);
        initEventAndData();
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().removeActivity(this);
        if (mPresenter != null) mPresenter.detachView();
    }

    protected abstract int getLayout();
    protected abstract void initEventAndData();
}
