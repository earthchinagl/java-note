package com.example.ribbonRule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  或者在配置文件中使用如下配置代替该配置类
 *  provider.ribbon.NFLoadBalancerRuleClassName=com.netflix.loadbalancer.RandomRule
 */
@Configuration
@RibbonClient(name = "myProvider", configuration = RibbonClientConfiguration.class)
public class RibbonRuleConfig {
    // 自定义Ribbon的负载均衡策略
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
