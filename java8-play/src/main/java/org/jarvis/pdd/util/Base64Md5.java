package org.jarvis.pdd.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class Base64Md5 {
    public static String EncryptMD5(String input, String parterid) throws Exception {
        return new String(Base64.encodeBase64(DigestUtils
                .md5((input + parterid).getBytes("UTF-8"))));
    }

    public static void main(String args[]) throws Exception {
        System.out.println(EncryptMD5("{\"orderType\":\"1\",\"receiver\":{\"address\":\"华徐公路3029弄18号\",\"phone\":\"021-12345678\",\"city\":\"上海市\",\"district\":\"青浦区\",\"name\":\"沈伟\",\"mobile\":\"18112345678\",\"postCode\":\"\",\"prov\":\"上海\"},\"sender\":{\"address\":\"七宝镇七宝老街1号\",\"phone\":\"021-12345679\",\"city\":\"上海市\",\"district\":\"闵行区\",\"name\":\"沈伟发\",\"mobile\":\"18112345679\",\"postCode\":\"\",\"prov\":\"上海\"},\"mallId\":\"1\",\"orgCode\":\"210045\",\"itemList\":[{\"itemValue\":100,\"name\":\"衣服1\",\"count\":1}],\"goodsValue\":299,\"remark\":\"12345\",\"txLogisticID\":\"XHS15183117908129\"}", "TEST_SECRET_KEY"));

        String secret = "TEST_SECRET_KEY";
        String json = "{\"orderType\":\"1\",\"receiver\":{\"address\":\"华徐公路3029弄18号\",\"phone\":\"021-12345678\",\"city\":\"上海市\",\"district\":\"青浦区\",\"name\":\"沈伟\",\"mobile\":\"18112345678\",\"postCode\":\"\",\"prov\":\"上海\"},\"sender\":{\"address\":\"七宝镇七宝老街1号\",\"phone\":\"021-12345679\",\"city\":\"上海市\",\"district\":\"闵行区\",\"name\":\"沈伟发\",\"mobile\":\"18112345679\",\"postCode\":\"\",\"prov\":\"上海\"},\"mallId\":\"1\",\"orgCode\":\"210045\",\"itemList\":[{\"itemValue\":100,\"name\":\"衣服1\",\"count\":1}],\"goodsValue\":299,\"remark\":\"12345\",\"txLogisticID\":\"XHS15183117908129\"}";
        try {
            String valueParams = json + secret;
            String generateSignature = DigestUtils.md5Hex(valueParams.getBytes());
            System.out.println(json);
            System.out.println(generateSignature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
