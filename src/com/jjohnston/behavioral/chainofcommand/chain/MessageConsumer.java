package com.jjohnston.behavioral.chainofcommand.chain;

import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;

public interface MessageConsumer {

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
    Message handleMessage(MessageContext context, Message msg) throws MessageException;
}