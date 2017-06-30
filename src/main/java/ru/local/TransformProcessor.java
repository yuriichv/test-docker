package ru.local;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * Created by yurii on 6/29/17.
 */
@Component
public class TransformProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        String body = "";
        Message message = exchange.getIn();
        Map<String,Object> hdrs = message.getHeaders();
        for (Map.Entry<String, Object> hdr: hdrs.entrySet())
            body = body.concat(hdr.getKey()+"= "+hdr.getValue()+"\n");
        message.setBody(body);
        exchange.setIn(message);
    }
}
