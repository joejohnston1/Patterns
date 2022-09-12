package com.jjohnston.behavioral.chainofcommand.chain.consumerfactory;

import com.jjohnston.behavioral.chainofcommand.chain.MessageConsumer;
import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;

import java.util.Map;

public class DestinationByDataSourceType implements MessageConsumerFactory {

    private Map<String, MessageConsumer> iConsumerMap;

    @Override
    public MessageConsumer getConsumerFor(MessageContext context, Message message) throws MessageException {
        return null;
    }
}
