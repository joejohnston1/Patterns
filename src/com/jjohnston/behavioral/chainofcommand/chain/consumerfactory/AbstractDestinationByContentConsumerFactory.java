package com.jjohnston.behavioral.chainofcommand.chain.consumerfactory;

import com.jjohnston.behavioral.chainofcommand.chain.MessageConsumer;
import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;

import java.util.Map;

public abstract class AbstractDestinationByContentConsumerFactory implements MessageConsumerFactory {

    private Map <String, MessageConsumer> iConsumerMap;

    public MessageConsumer getConsumerFor(
            final MessageContext context,
            final Message message) throws MessageException {

        String messageType = getMessageType(context, message);

        return iConsumerMap.get(messageType);
    }

    public abstract String getMessageType(
            MessageContext context,
            Message message) throws MessageException;
}
