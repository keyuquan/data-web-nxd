package com.web.nxd.common.controller;

import com.web.nxd.common.utils.ShiroUtils;
import org.springframework.stereotype.Controller;
import com.web.nxd.system.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}