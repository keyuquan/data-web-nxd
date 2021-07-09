package com.web.nxd.report.dao;

import com.web.nxd.report.domain.AppDaySiteKpiDo;
import org.mapstruct.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportDao {
    @Transactional(value = "dorisDBTransactionManager")
    List<AppDaySiteKpiDo> listDayPkg(Map<String, Object> map);
    @Transactional(value = "dorisDBTransactionManager")
    Integer listDayPkgCount(Map<String, Object> map);
}
