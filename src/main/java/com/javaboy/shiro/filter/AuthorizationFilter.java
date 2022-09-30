package com.javaboy.shiro.filter;

import com.alibaba.fastjson.JSONObject;
import com.javaboy.core.domain.ResponseEntity;
import com.javaboy.core.enums.AppCode;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：授权过滤器
 * @date ：2022/9/29 18:02
 */
public class AuthorizationFilter extends PermissionsAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws IOException {
        return super.isAccessAllowed(servletRequest, servletResponse, o);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setStatus(HttpServletResponse.SC_OK);
        res.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = res.getWriter();
        writer.append(JSONObject.toJSONString(ResponseEntity.fail(AppCode.UN_AUTHORIZED)));
        writer.close();
        return false;
    }

}
