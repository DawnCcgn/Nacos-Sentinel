package hpw.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author gn
 * @date 2021/7/8 10:33
 */
@Slf4j
@RestController
public class CircuitBreakController {



    @RequestMapping("gaw")
    public String bd(){

        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>送个你</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "    *{\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "    }\n" +
                "    ul,ol{\n" +
                "        list-style: none;\n" +
                "    }\n" +
                "    body{\n" +
                "        height: 100vh;\n" +
                "        background: #000000;\n" +
                "        display: flex;\n" +
                "        justify-content: center;\n" +
                "        align-items: center;\n" +
                "    }\n" +
                "    ul{\n" +
                "        height: 200px;\n" +
                "        display: flex;\n" +
                "    }\n" +
                "    li{\n" +
                "        width: 20px;\n" +
                "        height: 20px;\n" +
                "        border-radius: 10px;\n" +
                "        background: red;\n" +
                "        margin-right: 20px;\n" +
                "    }\n" +
                "    li:nth-child(1){\n" +
                "        background: red;\n" +
                "        animation: love1 4s 0s infinite;\n" +
                "    }\n" +
                "    li:nth-child(2){\n" +
                "        background: darkturquoise;\n" +
                "        animation: love2 4s 0.2s infinite;\n" +
                "    }\n" +
                "    li:nth-child(3){\n" +
                "        background: darksalmon;\n" +
                "        animation: love3 4s 0.4s infinite;\n" +
                "    }\n" +
                "    li:nth-child(4){\n" +
                "        background: deeppink;\n" +
                "        animation: love4 4s 0.6s infinite;\n" +
                "    }\n" +
                "    li:nth-child(5){\n" +
                "        background: yellow;\n" +
                "        animation: love5 4s 0.8s infinite;\n" +
                "    }\n" +
                "    li:nth-child(6){\n" +
                "        background: deeppink;\n" +
                "        animation: love4 4s 1s infinite;\n" +
                "    }\n" +
                "    li:nth-child(7){\n" +
                "        background: darksalmon;\n" +
                "        animation: love3 4s 1.2s infinite;\n" +
                "    }\n" +
                "    li:nth-child(8){\n" +
                "        background: darkturquoise;\n" +
                "        animation: love2 4s 1.4s infinite;\n" +
                "    }\n" +
                "    li:nth-child(9){\n" +
                "        background: red;\n" +
                "        animation: love1 4s 1.6s infinite;\n" +
                "    }\n" +
                "\n" +
                "    @keyframes love1 {\n" +
                "        30%,50%{\n" +
                "            height: 60px;\n" +
                "            transform: translateY(-30px);\n" +
                "        }\n" +
                "        70%,100%{\n" +
                "            height: 0px;\n" +
                "            transform: translateY(0px);\n" +
                "        }\n" +
                "    }\n" +
                "    @keyframes love2 {\n" +
                "        30%,50%{\n" +
                "            height: 125px;\n" +
                "            transform: translateY(-60px);\n" +
                "        }\n" +
                "        70%,100%{\n" +
                "            height: 0px;\n" +
                "            transform: translateY(0px);\n" +
                "        }\n" +
                "    }\n" +
                "    @keyframes love3 {\n" +
                "        30%,50%{\n" +
                "            height: 160px;\n" +
                "            transform: translateY(-75px);\n" +
                "        }\n" +
                "        70%,100%{\n" +
                "            height: 0px;\n" +
                "            transform: translateY(0px);\n" +
                "        }\n" +
                "    }\n" +
                "    @keyframes love4 {\n" +
                "        30%,50%{\n" +
                "            height: 180px;\n" +
                "            transform: translateY(-60px);\n" +
                "        }\n" +
                "        70%,100%{\n" +
                "            height: 0px;\n" +
                "            transform: translateY(0px);\n" +
                "        }\n" +
                "    }\n" +
                "    @keyframes love5 {\n" +
                "        30%,50%{\n" +
                "            height: 200px;\n" +
                "            transform: translateY(-45px);\n" +
                "        }\n" +
                "        70%,100%{\n" +
                "            height: 0px;\n" +
                "            transform: translateY(0px);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    h1{\n" +
                "        color: white;\n" +
                "        margin-top: 500px;\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "</style>\n" +
                "<body οnmοusedοwn=\"change()\">\n" +
                "\n" +
                "<div>\n" +
                "    <ul>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "    </ul>\n" +
                "</div>\n" +
                "\n" +
                "<br>\n" +
                "<h1 id=\"ioy\"></h1>\n" +
                "\n" +
                "<script>\n" +
                "    var ioy=document.getElementById(\"ioy\")\n" +
                "    function change() {\n" +
                "        ioy.innerHTML=\"I LOVE YOU! YOU ARE MY LIFE!\";\n" +
                "\n" +
                "    }\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }



    @RequestMapping("circuitBreak")
    @SentinelResource(value = "circuitBreak",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler")
    public String circuitBreak(){

        Random random = new Random();
        int sleepTime = random.nextInt(70)* 10;


        try { TimeUnit.MILLISECONDS.sleep(sleepTime); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("circuitBreak 测试RT" + sleepTime);
        return "熔断 ------慢调用比例" + sleepTime;
    }

    @RequestMapping("circuitBreak2")
    @SentinelResource(value = "circuitBreak2",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler")
    public String circuitBreak2(){

        Random random = new Random();
        int  num = random.nextInt(2);

        int i = 1/num;
        log.info("circuitBreak 测试  异常比例----->" + num);
        return "熔断 ------异常比例----->" + num;
    }


    @RequestMapping("circuitBreak3")
    @SentinelResource(value = "circuitBreak3",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler")
    public String circuitBreak3(){

        Random random = new Random();
        int  num = random.nextInt(3);

        int i = 1/num;

        log.info("circuitBreak 测试  异常数----->" + num);
        return "熔断 ------异常数----->" + num;
    }


    public String exceptionHandler(){

        log.error("处理异常");
        return "异常处理";
    }

    public String flowHandler(BlockException e){

        log.info("限流处理");
        return "限流处理";
    }
}
