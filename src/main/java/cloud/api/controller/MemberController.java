package cloud.api.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    @Value("${server.port}")
    public String port;

    @RequestMapping(value = "/")
    public String index(){
        System.out.println("index : " + Thread.currentThread().getName());
        return "This is member project " + port;
    }

    @HystrixCommand(fallbackMethod = "memberFallback")  //服务降级处理  Hystrix默认开启了线程池隔离 服务熔断
    @GetMapping("/getMember")
    public List getMember(){
        System.out.println("当前线程 : " + Thread.currentThread().getName());
        List list = new ArrayList();
        list.add("威威");
        list.add("阿杨");
        list.add("小洋");
        return list;
    }

    @RequestMapping(value = "memberFallback")
    public List memberFallback(){
        List<String> ls = new ArrayList<String>();
        ls.add("系统正在飞速旋转，请手稍等或者 重试.");
        System.out.println("系统正在飞速旋转，请手稍等或者 重试.");
        return ls;
    }

 }
