package com.suthar.rentel.ui.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "prototype")
@Component
public class LogoutAction extends ActionSupport implements SessionAware {

    private SessionMap<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = (SessionMap<String, Object>) session;
    }

    @Override
    public String execute() throws Exception {
        session.invalidate();
        return SUCCESS;
    }
}
