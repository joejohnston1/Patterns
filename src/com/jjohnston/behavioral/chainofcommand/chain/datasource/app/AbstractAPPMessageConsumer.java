package com.jjohnston.behavioral.chainofcommand.chain.datasource.app;

import com.jjohnston.behavioral.chainofcommand.chain.AbstractMessageConsumer;
import com.jjohnston.behavioral.chainofcommand.model.*;

public abstract class AbstractAPPMessageConsumer<T extends CGMessage> extends AbstractMessageConsumer {

    /**
     * <p>Handle the given message.</p>
     * <p>Implementations are expected to perform the necessary processing required
     * to handle the given message. Unknown messages should result in a MessageException
     * being thrown.</p>
     * @param context  The message context containing any applicable state data.
     * @param msg The message to be processed
     * @return The message resulting from processing this message, may be null if no further messages are produced.
     * @throws MessageException if there is a problem when handling a message. It is expected that one of the subclasses of MessageException will be thrown.
     */
    @Override
    public Message handleMessageImpl(final MessageContext context, final Message msg) throws MessageException {

        RawMessage raw = (RawMessage) msg;
        String msgStr =raw.getTextMessage();

        try {

            T appMessage = parseMessageBody(
                    context,
                    msg
            );

            return appMessage;

        } catch (MessageException me) {

            // create empty message add errors etc
            return null;
        }

    }

    /**
     * Subclasses are expected to implement this method to read the message body.
     *
     * @param context  The message context
     * @param msg  The message to parse.
     * @return  The parsed APP message.
     * @throws MessageException if an error occurs during message parsing.
     */
    protected abstract T parseMessageBody(
            MessageContext context,
            Message msg) throws MessageException;
}
