package com.jjohnston.behavioral.chainofcommand.chain.datasource.cgap;

import com.jjohnston.behavioral.chainofcommand.chain.MessageRouter;
import com.jjohnston.behavioral.chainofcommand.chain.consumerfactory.APPParserConsumerFactory;
import com.jjohnston.behavioral.chainofcommand.chain.consumerfactory.CGAPParserConsumerFactory;
import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;

public class CGAPParser extends MessageRouter {

    /**
     * The APPParserConsumerFactory is an instance of a ConsumerFactory implementation, currently one of
     * AbstractDestinationByContentConsumerFactory or AbstractDestinationByTypeConsumerFactory
     *
     * It contains the logic for deriving the message type for APP messages.
     *
     * @param factory
     */
    public CGAPParser(final CGAPParserConsumerFactory factory) {
        super(factory);
    }

    /**
     * Here we override the handleMessageImpl if we want to add some details to the context.
     *
     * We call the handleMessageImpl on the super class, the MessageRouter, which will use the APPParserConsumerFactory
     * to get the correct MessageConsumer for the given message.
     *
     * @param context  The message context
     * @param msg  The message to process
     * @return
     * @throws MessageException
     */
    @Override
    protected Message handleMessageImpl(final MessageContext context, final Message msg) throws MessageException {

        // can set some information on the context if required, otherwise could just create a MessageRouter with the
        // required consumer factory

        return super.handleMessageImpl(context, msg);
    }
}
