package com.lph.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class TimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetweenConfig> {

    public TimeBetweenRoutePredicateFactory() {
        super(TimeBetweenConfig.class);
    }

    /**
     * 实现为谓词判断的方法
     */
    @Override
    public Predicate<ServerWebExchange> apply(TimeBetweenConfig config) {
        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();
        return serverWebExchange -> {
            LocalTime now = LocalTime.now();
            return now.isAfter(start) && now.isBefore(end);
        };
    }

    /**
     * 设置配置类与配置文件的关系
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        /*
         * 例如我们的配置项是：TimeBetween=上午6:00, 下午1:00
         * 那么按照顺序，start对应的是上午6:00；end对应的是下午1:00
         */
        return Arrays.asList("start", "end");
    }
}


