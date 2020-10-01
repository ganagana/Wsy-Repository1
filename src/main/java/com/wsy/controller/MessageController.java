package com.wsy.controller;

import com.wsy.util.BaseUtil;
import com.wsy.util.Msg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author: wsy
 * Date: 2020/9/30
 * Time: 21:44
 * Description: No Description
 */
@RestController
public class MessageController {
    @RequestMapping("send/message")
    public Msg sendMessage(String phone) {
        Msg msg = BaseUtil.sendShortMessage(phone);
        if (Objects.equals(true, msg.getStatus())) {
            //得到发送的验证码
            String code = (String) msg.getData();
            //在redis中存入验证码
            String key = "REDIS_CODE_" + phone;
            Jedis jedis = new Jedis("localhost");
            jedis.setex(key, 180, code);
            return Msg.ok("发送成功");
        } else {
            return msg;
        }
    }
    /**
     * 登录
     * @param
     * @return
     */
    @RequestMapping("/user/login")
    public Msg userLogin(String phone,String verify) {
        //从Redis中得到发送的验证码
        String key = "REDIS_CODE_" + phone;
        Jedis jedis = new Jedis("localhost");
        String code = jedis.get(key);
        //判断验证码是否存在
        if (code == null) {
            return Msg.error("验证码以过期，请重新获取！");
        }
        //判断输入的验证码是否正确
        if (!Objects.equals(code, verify)) {
            return Msg.error("验证码错误");
        }
        //删除redis中的验证码
        jedis.del(key);

        return ;
    }
}
