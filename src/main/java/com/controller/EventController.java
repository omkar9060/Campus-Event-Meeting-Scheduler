package com.controller;

import com.model.Event;
import com.service.EventService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public Event create(@Valid @RequestBody Event e) {
        return service.create(e);
    }

    @GetMapping
    public List<Event> list(@RequestParam(required = false) String sort) {
        return service.getAll(sort);
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id,
                        @Valid @RequestBody Event e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
