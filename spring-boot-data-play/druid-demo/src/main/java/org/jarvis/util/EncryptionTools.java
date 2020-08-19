package org.jarvis.util;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @author marcus
 * @date 2020/8/9-19:13
 */
public class EncryptionTools {
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCkQNqK8eYsYI7f0ZO4y6eT3cGc/K8H2TweOIkY" +
            "ifVIOgLdX8pOwzXKErZmPnYk4E56q5AGY3Uj7KGnKZ+KT1qls9aXwnP4pdxzy7KObEU0bZAEkflJ" +
            "toEwHeqXyLULXWCnFRh0OERa7er8poPD2vXfoeFEZLYyE+1IJ8CN+JYMTQIDAQAB";

    private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKRA2orx5ixgjt/Rk7jLp5PdwZz8" +
            "rwfZPB44iRiJ9Ug6At1fyk7DNcoStmY+diTgTnqrkAZjdSPsoacpn4pPWqWz1pfCc/il3HPLso5s" +
            "RTRtkASR+Um2gTAd6pfItQtdYKcVGHQ4RFrt6vymg8Pa9d+h4URktjIT7UgnwI34lgxNAgMBAAEC" +
            "gYEAl2lFTEITGSNlcUMjdn0dnDwWp11zB7wkJAOftWQvHIaFb4ZG2vYuVnmLdJLtm66+CWyvVoRG" +
            "Tnhqx8qhzAC8oHeNICNQQSiR4lFB530uQ/Hw3ovqWpRDJ2M0/ANfQk3AiuJtFV+WaY7vTiu/+Poz" +
            "ThDWqDFViYjfRUBH18v/Mc0CQQDrbV4QZ1mwJN3Mo++1jeiZgo19LUwj8HNtJ8CYGrCyCgwVfSDT" +
            "wfv/9srD+ygv+7Y+eNw3AWAzfwkdteUFFQCrAkEAsptJ2v+y5M4avmvuRtJX98ectyLFu34Fgqa7" +
            "eaBpMxqq5uTPHth/Ut7YjLpYQcwLOaYB4Hu5bccItlAAhztW5wJAOwkX12EzOlpkTBan240UULpO" +
            "JJ+hQjnfl/Wp8/ptaJfgY9sWykMQoCUQv4hRkYa7Mns4LYroxsEKVirwnQ+hNQJBALAx2W4eCdEG" +
            "MgPgXbOoFffuB3/y4bXQ4Ia/DPszcBRmHmqhFmKLmS+bf21091QRgpFgX0GhTJArZUDVM3A07ckC" +
            "QA8K/ok2bcsAuFJAz0KhstxcwKVa0nLrgC3DI/fASFQ0nFwtpFwQ/+BlUOLnyat8dzOIekYveDpf" +
            "AfPtmzJiox8=";


    public static void main(String[] args) throws Exception {
        String encryptedString = ConfigTools.encrypt(PRIVATE_KEY, "I have a beautiful girlfriend");
        System.out.println(ConfigTools.decrypt(PUBLIC_KEY, encryptedString));
    }

}
