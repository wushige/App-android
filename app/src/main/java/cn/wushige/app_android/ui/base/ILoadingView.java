package cn.wushige.app_android.ui.base;

/**
 * <p>
 * <p/>
 * </p>
 *
 * @author wushige
 * @date 2016-08-01 15:32
 */
public interface ILoadingView extends IView {

    void showLoading();
    void showContent();
    void showNoData();
    void showError(String msg);
}
