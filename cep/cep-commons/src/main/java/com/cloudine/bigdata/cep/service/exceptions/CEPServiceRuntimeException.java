package com.cloudine.bigdata.cep.service.exceptions;

/**
 * CEP Service Runtime Exception Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CEPServiceRuntimeException extends RuntimeException {

    /**
     * 기본 생성자.
     *
     * @param message 에러 메시지
     */
    public CEPServiceRuntimeException(String message) {
        super(message);
    }

    /**
     * 기본 생성자.
     *
     * @param message 에러 메시지
     * @param cause   원인이 되는 예외
     */
    public CEPServiceRuntimeException(String message, Exception cause) {
        super(message, cause);
    }

    /**
     * 기본 생성자.
     *
     * @param cause 원인이 되는 예외
     */
    public CEPServiceRuntimeException(Exception cause) {
        super(cause);
    }
}
