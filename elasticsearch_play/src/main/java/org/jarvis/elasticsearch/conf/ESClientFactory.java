package org.jarvis.elasticsearch.conf;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ESClientFactory {
    // 私有化构造器，只能使用单例的方式进行获取，饿汉模式保证线程安全
    private ESClientFactory() {

    }

    private static RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("10.130.9.129", 9200, "http"),
                    new HttpHost("10.130.9.129", 9201, "http")));

    public static RestHighLevelClient getESClient() {
        return client;
    }
}
