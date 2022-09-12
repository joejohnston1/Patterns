package com.jjohnston.behavioral.chainofcommand.chain.datasource.cgap;

import com.jjohnston.behavioral.chainofcommand.chain.datasource.app.AbstractAPPMessageConsumer;
import com.jjohnston.behavioral.chainofcommand.model.Message;
import com.jjohnston.behavioral.chainofcommand.model.MessageContext;
import com.jjohnston.behavioral.chainofcommand.model.MessageException;
import com.jjohnston.behavioral.chainofcommand.model.app.PassengerCheckInRequestMessage;

public class ParseCGAPPassengerCheckInRequestMessage extends AbstractAPPMessageConsumer<PassengerCheckInRequestMessage> {

    @Override
    protected PassengerCheckInRequestMessage parseMessageBody(MessageContext context, Message msg) throws MessageException {
        return null;
    }
}
