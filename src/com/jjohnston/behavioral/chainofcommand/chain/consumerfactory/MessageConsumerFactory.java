package com.jjohnston.behavioral.chainofcommand.chain.consumerfactory;

import com.jjohnston.behavioral.chainofcommand.chain.MessageConsumer;
import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;

public interface MessageConsumerFactory {

    /**
     * Find a message consumer suitable for processing the given message.
     *
     * @param context  The message context.
     * @param message The message that is to be processed.
     * @return a message consumer suitable for processing the given message or null if one
     * cannot be found.
     * @throws MessageException if something goes wrong.
     */
    MessageConsumer getConsumerFor(MessageContext context, Message message) throws MessageException;
}
