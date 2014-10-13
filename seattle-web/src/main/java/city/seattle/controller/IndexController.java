package city.seattle.controller;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by niuqinghua on 2014/9/1.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequiresGuest
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
