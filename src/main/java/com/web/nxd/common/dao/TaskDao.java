package com.web.nxd.common.dao;

import com.web.nxd.common.domain.TaskDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface TaskDao {

	TaskDO get(Long id);

	List<TaskDO> list(Map<String,Object> map);

	int count(Map<String,Object> map);

	int save(TaskDO task);

	int update(TaskDO task);

	int remove(Long id);

	int batchRemove(Long[] ids);
}
