package lihuaizhan.bwie.com.lihuaizhanproject.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/17.
 */

public class LoginBean implements Serializable {

    /**
     * code : 0
     * data : {"appkey":"504589a457d6e92f","appsecret":"BB37E0F1A749A3A1EEE2CC904181F34A","createtime":"2017-12-18T14:01:41","icon":"https://www.zhaoapi.cn/images/1513576114069abc123.jpg","mobile":"17311111111","password":"473344696F4685CAE5B5B3C354BC77BE","token":"23328B7E31ACDAA310049F85238618EC","uid":4383,"username":"17311111111"}
     * msg : 登录成功
     */

    private String code;
    private DataBean data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean implements Serializable{
        /**
         * appkey : 504589a457d6e92f
         * appsecret : BB37E0F1A749A3A1EEE2CC904181F34A
         * createtime : 2017-12-18T14:01:41
         * icon : https://www.zhaoapi.cn/images/1513576114069abc123.jpg
         * mobile : 17311111111
         * password : 473344696F4685CAE5B5B3C354BC77BE
         * token : 23328B7E31ACDAA310049F85238618EC
         * uid : 4383
         * username : 17311111111
         */

        private String appkey;
        private String appsecret;
        private String createtime;
        private String icon;
        private String mobile;
        private String password;
        private String token;
        private int uid;
        private String username;

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
