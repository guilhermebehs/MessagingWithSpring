package br.com.guilherme.behs.messaging.adapter.in.http;

import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;
import br.com.guilherme.behs.messaging.port.out.PublisherAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "messaging")

public class MessagingController {

    private final PublisherAdapter publisherAdapter;

    public MessagingController(PublisherAdapter publisherAdapter) {
        this.publisherAdapter = publisherAdapter;
    }

    @PostMapping
    public ResponseEntity<OrderStatusChanged> create(@RequestBody() OrderStatusChanged orderStatusChanged){
        publisherAdapter.send(orderStatusChanged);
        return new ResponseEntity<OrderStatusChanged>(orderStatusChanged,HttpStatus.CREATED);
    }
}
