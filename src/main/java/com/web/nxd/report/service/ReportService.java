package com.web.nxd.report.service;

import com.web.nxd.report.domain.AppDaySiteKpiDo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportService {
    List<AppDaySiteKpiDo> listDaySite(Map<String, Object> params);

    Integer listDaySiteCount(Map<String, Object> params);
}
