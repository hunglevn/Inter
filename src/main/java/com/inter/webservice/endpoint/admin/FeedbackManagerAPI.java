package com.inter.webservice.endpoint.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/feedback")
public class FeedbackManagerAPI extends AdminAPI implements IFeedbackManagerAPI {
	/**
	 * Using Elastic Search to search feeding back message from MySQL DB.
	 * Return JSON search result to client
	 * Sample JSON response:
	 * ...
	 */
	@Override
	@RequestMapping("search")
	public String search(@RequestParam("keyword")String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
