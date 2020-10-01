package com.wsy.exception;

import com.google.gson.Gson;
import com.wsy.util.BaseUtil;
import com.wsy.util.Msg;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wsy
 * Date: 2020/9/29
 * Time: 23:30
 * Description: No Description
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handle(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        logger.warn("处理异常：" + exception.getMessage());
        boolean judgeRequestType = BaseUtil.judgeRequestType(request);
        //ajax请求处理
        if (judgeRequestType) {
            //获取异常信息
            Msg msg = Msg.error("未知错误");
            //转换为json对象
            Gson gson = new Gson();
            String json = gson.toJson(msg);
            //返回
            response.getWriter().write(json);
            return null;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
