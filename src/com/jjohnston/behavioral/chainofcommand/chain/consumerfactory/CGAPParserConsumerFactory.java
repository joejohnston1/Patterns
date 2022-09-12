package com.jjohnston.behavioral.chainofcommand.chain.consumerfactory;

import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;

public class CGAPParserConsumerFactory extends AbstractDestinationByContentConsumerFactory {

    @Override
    public String getMessageType(MessageContext context, Message message) throws MessageException {

        // add logic here to determine the message type from the message content/header for APP message types
        // other message types should add their own implementation of the AbstractDestinationByContentConsumerFactory
        return null;
    }
}
