package com.jjohnston.behavioral.chainofcommand.chain;

import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;

public abstract class AbstractMessageConsumer implements MessageProcessor {

    /** The chained message consumer. In this example this is a chain of MessageRouter objects. */
    private MessageConsumer iChainedMessageConsumer;

    /** The exception message consumer. */
    private MessageConsumer iExceptionConsumer;

    @Override
    public void setMessageConsumer(MessageConsumer consumer) {

    }

    @Override
    public void setExceptionConsumer(MessageConsumer consumer) {

    }

    /**
     * <p>Handle the given message.</p>
     * <p>Implementations are expected to perform the necessary processing required
     * to handle the given message. Unknown messages should result in a MessageException
     * being thrown.</p>
     * @param context  The message context.
     * @param msg The message to be processed
     * @return The message resulting from processing this message, may be null if no further messages are produced.
     * @throws MessageException if there is a problem when handling a message. It is expected that one of the subclasses of MessageException will be thrown.
     */
    public Message handleMessage(final MessageContext context, final Message msg) throws MessageException {

        try {
            Message result = handleMessageImpl(context, msg);

            if (iChainedMessageConsumer != null && result != null) {
                return iChainedMessageConsumer.handleMessage(context, result);
            }
            return result;

        } catch (MessageException e) {
            return handleException(context, msg, e);
        }
    }

    /**
     * The actual implementation of the handle message method to be overridden by subclasses.
     *
     * @param context  The message context
     * @param msg  The message to process
     * @return  The processed message
     * @throws MessageException  if the message cannot be parsed.
     */
    protected abstract Message handleMessageImpl(MessageContext context, Message msg) throws MessageException;

    /**
     * Handle the specified exception appropriately.
     * @param context  The message context.
     * @param msg The message that caused the exception
     * @param ex The exception that was raised while processing the given message.
     * @return  The message after it's been processed.
     * @throws MessageException if the message cannot be processed.
     */
    protected Message handleException(
            final MessageContext context,
            final Message msg,
            final MessageException ex) throws MessageException {

        if (iExceptionConsumer != null) {
            return iExceptionConsumer.handleMessage(context, msg);
        } else {
            return msg;
        }
    }

}
