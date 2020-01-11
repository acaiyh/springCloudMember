package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @EnableEurekaClient 如果使用Eureka为注册中心
 *      消费者启动的时候，使用服务别名，会发送一个rest请求到服务注册中心获取对应的服务信息，然后缓存在本地，
 *      每隔30秒从服务器上更新一次。
 *      可以通过 fetch-inte vall-second=30 参数进行修改 eureka.client.registry 设置时间，默认30s.
 *
 * @EnableDiscoveryClient 使用 consul 或者 zookeeper 注册中心
 *      Zookeeper 和 Eureka 的区别
 *          CAP 理论：
 *              一个分布式系统不可能同时满足 C(一致性) A(可用性) P(区分容错性)。
 *              由于区分容错性是分布式系统必须要保证的，因此我们只能在 A 和 C 之间进行权衡，Zookeeper保证的是CP,Eureka保证的是AP.。
 *          CAP ：
 *              C：Consistency(一致性)，数据一致更新，所有的数据变动是同步的。
 *              A：Availability(可用性)，好的影响性能。
 *              P：Partition tolerance(区分容忍性)可靠性。
 *
 *
 * 添加 配置中心，一部分配置在 ConfigCenter中，如需添加配置或者修改配置，可在 ConfigCenter -> app-cloud-member-dev.yml 中配置
 * 配置完 需要调用接口刷新到最新配置 http://127.0.0.1:8000/actuator/refresh
 * @author caiyunchun
 * @date 2019/5/22 0022
 * @return
 */


@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient //consul注册中心
@EnableHystrix
public class AppEurekaMember {

    public static void main(String[] args) {
        SpringApplication.run(AppEurekaMember.class,args);
    }
}
