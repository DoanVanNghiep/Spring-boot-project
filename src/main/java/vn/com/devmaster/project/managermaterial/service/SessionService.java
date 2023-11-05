package vn.com.devmaster.project.managermaterial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.xml.transform.sax.SAXResult;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    // đọc giá trị attribute trong sesssion
    @SuppressWarnings("unchecked")
    public <T> T get(String name){
        return (T) session.getAttribute(name);
    }
    public <T> T get(String name,T defaultValue){
        T value=get(name);
        return value!= null ?value:defaultValue;
    }
    // thay đổi hoặc tạo mới attribute trong session
    public void set(String name, Object value){
        session.setAttribute(name,value);
    }
    public void remove(String name){
        session.removeAttribute(name);
    }
}
