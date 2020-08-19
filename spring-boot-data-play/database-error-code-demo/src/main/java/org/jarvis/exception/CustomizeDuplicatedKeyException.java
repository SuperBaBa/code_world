package org.jarvis.exception;

import org.springframework.dao.DuplicateKeyException;

/**
 * 自定义主键冲突异常
 * author:tennyson date:2020/7/7
 **/
public class CustomizeDuplicatedKeyException extends DuplicateKeyException {
    public CustomizeDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomizeDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
