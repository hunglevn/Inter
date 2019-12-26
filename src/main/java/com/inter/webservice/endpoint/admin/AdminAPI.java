package com.inter.webservice.endpoint.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inter.webservice.endpoint.ClientAPI;

/**
 * API for administrator.
 * Need to authentication with "ADMIN" role.
 * For example, these are steps to call "/api/admin/feedback/search" API
 * 1. curl -i -X POST -d username=kevin -d password=123456 -c D:/Temp/cookies.txt  http://localhost:8080/login
 * 2. curl -i -X GET -b D:/Temp/cookies.txt  http://localhost:8080/api/admin/feedback/search?keyword=hello
 * @author Kevin
 *
 */
public class AdminAPI {
	protected Logger logger = LoggerFactory.getLogger(ClientAPI.class);
}
