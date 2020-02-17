package com.mastercard.db.split.service.impl;

import com.mastercard.db.split.dao.PingDao;
import com.mastercard.db.split.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PingServiceImpl implements PingService {

    @Autowired
    private PingDao pingDao;

    @Override
    public String ping() {
        return pingDao.ping();
    }
}
