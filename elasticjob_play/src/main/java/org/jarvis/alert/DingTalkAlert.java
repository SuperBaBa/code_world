package org.jarvis.alert;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import org.apache.commons.codec.binary.Base64;
import org.jarvis.listener.ESResponseActionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

/**
 * author:tennyson date:2020/6/16
 **/
@Configuration
public class DingTalkAlert {
    @Value(value = "${dingTalkUrl}")
    private String dingTalkURL;
    @Autowired
    @Qualifier(value = "getConditionJSON")
    private Map<String, Long> condition;

    public static void main(String[] args) throws Exception {
        Long timestamp = System.currentTimeMillis();
        String secret = "this is secret";

        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        System.out.println(sign);
    }

    public void sendMessage(Map<String, ArrayList<String>> stringSetMap, ESResponseActionListener.Filter filter) {
        String image = "![screenshot](https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=959636631,445041190&fm=26&gp=0.jpg)";
        stringSetMap = filter.filterInvaildAlert(stringSetMap, condition);
        if (stringSetMap.isEmpty())return;
        StringBuilder content = new StringBuilder();
        for (String appId : stringSetMap.keySet()) {
            content.append("\n# ")
                    .append(appId)
                    .append("\t检测到\t**")
                    .append(stringSetMap.get(appId).size())
                    .append("**\t条ERROR日志\n")
                    .append("\t*当前阈值设定=>")
                    .append(condition.get(appId))
                    .append("*\n")
                    .append("> 日志详情如下：\n")
                    .append("> - ")
                    .append(stringSetMap.get(appId).get(0))
                    .append("\n");
        }

        DingTalkClient client = new DefaultDingTalkClient(dingTalkURL);

        OapiRobotSendRequest request = new OapiRobotSendRequest();
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll(true);
        request.setMsgtype("actionCard");
        OapiRobotSendRequest.Actioncard actioncard = new OapiRobotSendRequest.Actioncard();
        actioncard.setTitle("ELK日志中心告警");
        actioncard.setSingleTitle("查看星图监控");
        actioncard.setSingleURL("http://xt.yto.net.cn/monitor-pc-portal/index?source=PORTAL");

        actioncard.setBtnOrientation("0");
        actioncard.setText(image+content.toString());

        request.setAt(at);
        request.setActionCard(actioncard);
        System.out.println("111111111111111433333333333333333333333");
//        try {
//            OapiRobotSendResponse response = client.execute(request);
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
    }

}
