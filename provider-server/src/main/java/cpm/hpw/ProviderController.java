package cpm.hpw;

/**
 * @author gn
 * @date 2021/6/28 15:17
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProviderController {
    @GetMapping("/provider/msg")
     public String sendMessage(){
        return "This is the message from provider service!";
 }
}
