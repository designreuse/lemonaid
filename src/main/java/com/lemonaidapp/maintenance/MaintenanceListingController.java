package com.lemonaidapp.maintenance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/maintenance/listing")
public class MaintenanceListingController {

	private final Logger log = LoggerFactory.getLogger(MaintenanceListingController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "maintenance/listing.jsp";
	}

}
