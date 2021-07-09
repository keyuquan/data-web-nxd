package com.web.nxd.report.service.impl;

import com.web.nxd.report.dao.ReportDao;
import com.web.nxd.report.domain.AppDaySiteKpiDo;
import com.web.nxd.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportDao reportDao;

    @Override
    public List<AppDaySiteKpiDo> listDaySite(Map<String, Object> params) {
        return reportDao.listDayPkg(params);
    }

    @Override
    public Integer listDaySiteCount(Map<String, Object> params) {
        return reportDao.listDayPkgCount(params);
    }
}
