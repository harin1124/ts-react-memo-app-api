package react.memo.tsreactmemoappapi;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/user")
    public HashMap<String, Object> getUserInfo(){
        System.out.println("test 진입");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "aaa");
        return map;
    }
}
