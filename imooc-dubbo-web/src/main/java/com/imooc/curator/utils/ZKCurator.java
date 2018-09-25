package com.imooc.curator.utils;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ZKCurator {
    private CuratorFramework client = null;		// zk客户端

    public static final String zkServerPath = "192.168.202.61:2181,192.168.202.62:2181,192.168.202.63:2181";

    final static Logger log = LoggerFactory.getLogger(ZKCurator.class);

    {
        // 使用命名空间
        RetryPolicy retryPolicy = new RetryNTimes(10,5000);
        client = CuratorFrameworkFactory.builder()
                .connectString(zkServerPath)
                .sessionTimeoutMs(30000).retryPolicy(retryPolicy)
                .namespace("zk-curator-connector").build();
        client.start();
        System.out.println("ZKCurator()...");
    }

    /**
     * @Description: 初始化操作
     */
    public void ZKCurator() {
    }

    /**
     * @Description: 判断zk是否连接
     */
    public boolean isZKAlive() {
        return client.isStarted();
    }
}
