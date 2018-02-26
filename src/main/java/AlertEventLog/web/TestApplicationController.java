package AlertEventLog.web;

import AlertEventLog.util.SpringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/application")
public class TestApplicationController {
    @RequestMapping("/test")
    public Object testSpringUtil1() {
        return SpringUtil.getBean("testDemo");
    }
}
