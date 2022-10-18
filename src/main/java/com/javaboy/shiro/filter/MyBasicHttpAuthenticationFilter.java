package com.javaboy.shiro.filter;

import cn.hutool.json.JSONUtil;
import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import com.javaboy.shiro.domain.JwtToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： Basic HTTP 身份验证拦截器
 * @date ：2022/10/15 15:07
 */
public class MyBasicHttpAuthenticationFilter extends BasicHttpAuthenticationFilter {

    private String token;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (this.getAuthzHeader(request) != null) {
            try {
                executeLogin(request, response);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        Subject subject = getSubject(request, response);
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

    @Override
    protected String getAuthzHeader(ServletRequest request) {
        try {
            HttpServletRequest httpRequest = WebUtils.toHttp(request);
            this.token = httpRequest.getHeader(AUTHORIZATION_HEADER);
            return this.token;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        this.getSubject(request, response).login(new JwtToken(this.token));
        return true;
    }

}
