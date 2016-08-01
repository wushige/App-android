package cn.wushige.app_android.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import cn.wushige.app_android.presenter.base.IPresenter;

/**
 * <p>
 * ase Fragment：所有的Fragment都必须继承此类
 * </p>
 *
 * @author wushige
 * @date 2016-08-01 14:28
 */
public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView {

    @Inject
    protected P mPresenter;
    protected View mView;
    protected Activity mContext;

    @Override
    public void onAttach(Activity activity) {
        if (activity instanceof BaseActivity) {
            mContext = activity;
        }
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        initEventAndData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }


    protected abstract int getLayoutId();
    protected abstract void initEventAndData();
}
