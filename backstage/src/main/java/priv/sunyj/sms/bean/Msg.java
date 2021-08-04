package priv.sunyj.sms.bean;

import java.util.HashMap;

public class Msg {

    //状态码 100成功 200失败
    private String code;
    //状态信息
    private String message;
    //返回信息
    HashMap<String,Object> map=new HashMap<String, Object>();

    public static Msg success(){
        Msg msg = new Msg();
        msg.setCode("100");
        msg.setMessage("操作成功");
        return msg;
    }
    public static Msg fail(){
        Msg msg = new Msg();
        msg.setCode("200");
        msg.setMessage("操作失败");
        return msg;
    }
    public  Msg add(String key,Object value){
        this.getMap().put(key,value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }



}
