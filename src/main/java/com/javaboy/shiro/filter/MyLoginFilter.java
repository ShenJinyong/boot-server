package com.javaboy.shiro.filter;

import cn.hutool.json.JSONUtil;
import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：登录过滤器
 * @date ：2022/10/14 15:19
 */
public class MyLoginFilter extends AuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        Subject subject = getSubject(servletRequest, servletResponse);
        return subject.getPrincipals() != null;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setStatus(HttpServletResponse.SC_OK);
        res.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = res.getWriter();
        writer.append(JSONUtil.toJsonStr(ResponseEntity.fail(AppCode.UN_LOGIN)));
        writer.close();
        return false;
    }

}
