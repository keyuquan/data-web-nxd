package com.web.nxd.common.service;

import com.web.nxd.common.domain.LogDO;
import com.web.nxd.common.domain.PageDO;
import com.web.nxd.common.utils.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
