package hpw.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author gn
 * @date 2021/7/7 11:57
 */
@Slf4j
@Service
public class SentinelService {

    @SentinelResource(value = "sentinelService",
            fallback= "fallbackHandler",
            blockHandler = "flowHandler")
    public String getService(){
        return "hello ----- SentinelService";
    }

    public String fallbackHandler(){

        log.info(Thread.currentThread().getName());

        return "降级操作" +Thread.currentThread().getName();
    }


}
