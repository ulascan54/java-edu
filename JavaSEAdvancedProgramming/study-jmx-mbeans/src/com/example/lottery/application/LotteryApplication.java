package com.example.lottery.application;

import com.example.lottery.jmx.WebServiceQualitySampler;
import com.example.lottery.jmx.WebServiceQualitySamplerMXBean;
import com.example.lottery.service.LotteryService;
import com.example.lottery.service.soup.StandardLotteryService;

import javax.management.*;
import javax.xml.ws.Endpoint;
import java.lang.management.ManagementFactory;

public class LotteryApplication {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        StandardLotteryService lotteryService = new StandardLotteryService();
        ObjectName mBeanName = new ObjectName("com.example.jmx:type=WebServiceQuality");
        WebServiceQualitySampler sampler = new WebServiceQualitySampler(lotteryService);
        mBeanServer.registerMBean(sampler, mBeanName );
        lotteryService.addObserver(sampler);
        System.err.println("Lottery Service is running at 8100");

        Endpoint.publish("http://localhost:8100/lottery", lotteryService);
    }
}
