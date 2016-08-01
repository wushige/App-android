package cn.wushige.app_android.model.entity;

/**
 * <p>
 * api返回结果基本模型
 * </p>
 *
 * @author wushige
 * @date 2016-08-01 16:36
 */
public class ApiResult<T> {
    private int status_code;
    private String status_msg;
    private T data;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(String status_msg) {
        this.status_msg = status_msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
