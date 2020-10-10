package com.jyinfo.jy_security.service.service;

import com.jyinfo.jy_security.ManagerInfo;

public interface ManagerInfoService {

    ManagerInfo findByUsername(String username);
}
