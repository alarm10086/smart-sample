package com.smart.sample.service;

import com.smart.plugin.ws.annotation.WebService;
import com.smart.sample.entity.User;
import com.smart.sample.ws.FieldMapAdapter;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface UserService {

    User login(@XmlJavaTypeAdapter(FieldMapAdapter.class) Map<String, Object> fieldMap);
}
