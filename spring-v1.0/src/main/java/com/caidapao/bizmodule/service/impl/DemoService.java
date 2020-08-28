package com.caidapao.bizmodule.service.impl;

import com.caidapao.bizmodule.service.IDemoService;
import com.caidapao.mvcspringframework.annotation.DPService;

/**
 * 核心业务逻辑
 */
@DPService
public class DemoService implements IDemoService {

    public String get(String name) {
        return "My name is " + name + ",from service.";
    }

}
