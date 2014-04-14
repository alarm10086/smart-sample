package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Service;
import com.smart.framework.annotation.Transaction;
import com.smart.framework.util.DateUtil;
import com.smart.sample.entity.Log;
import com.smart.sample.service.LogService;

@Service
public class LogServiceImpl implements LogService {

    @Override
    @Transaction
    public void log(String description) {
        Log log = new Log();
        log.setDate(DateUtil.getCurrentDate());
        log.setTime(DateUtil.getCurrentTime());
        DataSet.insert(log);
    }
}
