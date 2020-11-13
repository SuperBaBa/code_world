package org.jarvis.config;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

/**
 * @author marcus
 * @date 2020/11/3-14:11
 */
@ConditionalOnClass(value = {com.dingtalk.api.DingTalkClient.class})
public class DingTalkAlertConfiguration {
    @Value(value = "${dingTalkUrl}")
    private String dingTalkURL;

    @Bean
    public void initDingTalkClient(String dingTalkURL) {
        DingTalkClient client = new DefaultDingTalkClient(dingTalkURL);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll(true);
        request.setMsgtype("actionCard");
        OapiRobotSendRequest.Actioncard actioncard = new OapiRobotSendRequest.Actioncard();
        actioncard.setTitle("ELK日志中心告警");
        actioncard.setSingleTitle("查看星图监控");
        actioncard.setSingleURL("http://xt.L");

        actioncard.setBtnOrientation("0");

        request.setAt(at);
        request.setActionCard(actioncard);
        try {
            OapiRobotSendResponse response = client.execute(request);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
