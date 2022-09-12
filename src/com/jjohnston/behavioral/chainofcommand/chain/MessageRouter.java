package com.jjohnston.behavioral.chainofcommand.chain;

import com.jjohnston.behavioral.chainofcommand.chain.consumerfactory.MessageConsumerFactory;
import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;

/**
 * The chain is made up of a series of MessageRouter objects, the next MessageRouter in the chain is configured via the
 * iChainedMessageConsumer on the AbstractMessageConsumer.
 *
 * The MessageRouter uses its configured MessageConsumerFactory to determine the correct MessageConsumer to use for
 * a given message.
 *
 * The MessageConsumerFactory can have multiple implementations the two used in this example are
 * AbstractDestinationByTypeConsumerFactory and AbstractDestinationByContentConsumerFactory.
 *
 */
public class MessageRouter extends AbstractMessageConsumer {

    private MessageConsumerFactory iConsumerFactory;

    public MessageRouter(final MessageConsumerFactory factory) {
        this.iConsumerFactory = factory;
    }

    @Override
    protected Message handleMessageImpl(MessageContext context, Message msg) throws MessageException {

        // Try to find a consumer for the given message in the consumer factory
        MessageConsumer consumer = iConsumerFactory.getConsumerFor(context, msg);
        if (consumer == null) {
            return msg;
        }

       return consumer.handleMessage(context, msg);
    }
}
