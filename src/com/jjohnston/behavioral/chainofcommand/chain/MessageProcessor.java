package com.jjohnston.behavioral.chainofcommand.chain;

public interface MessageProcessor extends MessageConsumer {

    /**
     * <p>Sets the MessageConsumer that this message source will send any
     * received messages to.
     * </p><p>
     * Implementations of this interface should throw a suitable runtime
     * exception if the required consumer is not specified.
     * </p>
     * @param consumer the MessageConsumer that this message source will send any
     * messages to for processing.
     */
    void setMessageConsumer(MessageConsumer consumer);

    /**
     * <p>Sets the MessageConsumer that this message processor will send any
     * user exception messages to.
     * </p><p>
     * Implementations of this interface should throw a suitable runtime
     * exception if the required consumer is not specified.
     * </p>
     * @param consumer  the MessageConsumer that this message source will send any
     * user exception messages to for processing.
     */
    void setExceptionConsumer(MessageConsumer consumer);
}