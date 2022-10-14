package com.javaboy.shiro.filter;

import cn.hutool.json.JSONUtil;
import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：权限过滤器
 * @date ：2022/10/14 15:26
 */
public class MyAuthorizationFilter extends PermissionsAuthorizationFilter {

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
        writer.append(JSONUtil.toJsonStr(ResponseEntity.fail(AppCode.UN_AUTHORIZED)));
        writer.close();
        return false;
    }

}
