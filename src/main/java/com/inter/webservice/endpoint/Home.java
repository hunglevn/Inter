package com.inter.webservice.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inter.util.NetworkUtil;

@RestController
public class Home {
	@RequestMapping(value = "/")
	public String home() {
		String hostName = NetworkUtil.hostName();
		return String.format("Hello, I am %s !", hostName);
	}

}
