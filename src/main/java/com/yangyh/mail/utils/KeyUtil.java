package com.yangyh.mail.utils;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

/**
 * @description: 主键生成策略-工具类
 * @author: yangyh
 * @create: 2019-09-04 00:21
 */
public class KeyUtil {

    /**
     * 主键生成策略
     * @return
     */
    public static String generatorUUID() {
        TimeBasedGenerator timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
        return timeBasedGenerator.generate().toString();
    }
}
