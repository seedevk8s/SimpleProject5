package able.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import able.com.web.HController;

@Controller
public class IncludeCommonController extends HController {

	@RequestMapping(value = "/cmm/index.do")
	public String selectSampleList(ModelMap model) throws Exception {

		return "dashboard";
	}
	
}
