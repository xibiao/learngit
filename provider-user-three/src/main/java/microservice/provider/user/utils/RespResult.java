package microservice.provider.user.utils;

import java.io.Serializable;

public class RespResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String MSG_OK = "success";

    private static final String MSG_FAIL = "fail";

    //状态码，取值：0表示成功，-1表示失败
    private Integer code;

    private String msg;

    private T data;

    private RespResult(){

    }

    private RespResult(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> RespResult<String> ok(){
        RespResult respResult = new RespResult();
        respResult.setCode(0);
        respResult.setMsg(MSG_OK);
        respResult.setData("");
        return respResult;
    }

    public static <T> RespResult<T> ok(T data){
        return new RespResult(0,MSG_OK,data);
    }

    public static <T> RespResult<String> fail(){
        return new RespResult(-1,MSG_FAIL,"");
    }

    public static <T> RespResult<T> fail(T data){
        return new RespResult(-1,MSG_FAIL,data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
