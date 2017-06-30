package ru.local;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.Exchange.CONTENT_TYPE;

/**
 * Created by yurii on 6/25/17.
 */
@Component
public class HelloRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .host("{{application.host}}")
                .port("{{application.port}}")
                .contextPath("/")
                .component("jetty");

        rest("{text}").get()
                .to("direct:hello");

        from("direct:hello")
                .setHeader(Exchange.CONTENT_TYPE, constant("text/html"))
              //  .setBody(simple("<H1>Hello ${header.text}</H1>"))
                .process("transformProcessor");


    }
}
