package com.imooc.propertites;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by pp on 2017/3/25.
 */
@Component
@ConfigurationProperties(prefix = "girl")
@Data
public class GirlProperties {

    private String cupSize;

    private Integer age;

}
