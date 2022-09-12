package com.jjohnston.behavioral.chainofcommand.chain.datasource.app;

import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;
import com.jjohnston.behavioral.chainofcommand.model.app.PassengerCheckInRequestMessage;

public class ParseAPPPassengerCheckInRequestMessage extends AbstractAPPMessageConsumer<PassengerCheckInRequestMessage> {

    @Override
    protected PassengerCheckInRequestMessage parseMessageBody(MessageContext context, Message msg) throws MessageException {
        return null;
    }
}
