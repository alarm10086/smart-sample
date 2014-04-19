package smart.sample.service.impl;

import smart.framework.dao.DataSet;
import smart.framework.tx.annotation.Service;
import smart.framework.tx.annotation.Transaction;
import smart.framework.util.DateUtil;
import smart.sample.entity.Log;
import smart.sample.service.LogService;

@Service
public class LogServiceImpl implements LogService {

    @Override
    @Transaction
    public void log(String description) {
        Log log = new Log();
        log.setDate(DateUtil.getCurrentDate());
        log.setTime(DateUtil.getCurrentTime());
        log.setDescription(description);
        DataSet.insert(log);

//        // 故意让事务回滚
//        throw new RuntimeException();
    }
}
