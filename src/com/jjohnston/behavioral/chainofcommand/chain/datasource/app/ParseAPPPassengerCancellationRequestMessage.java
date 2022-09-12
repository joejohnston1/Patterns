package com.jjohnston.behavioral.chainofcommand.chain.datasource.app;

import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;
import com.jjohnston.behavioral.chainofcommand.model.app.PassengerCancelRequestMessage;

public class ParseAPPPassengerCancellationRequestMessage extends AbstractAPPMessageConsumer<PassengerCancelRequestMessage> {

    @Override
    protected PassengerCancelRequestMessage parseMessageBody(MessageContext context, Message msg) throws MessageException {
        return null;
    }
}
