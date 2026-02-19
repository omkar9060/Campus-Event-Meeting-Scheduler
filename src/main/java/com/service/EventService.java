package com.service;

import com.model.Event;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EventService {

    private List<Event> events = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public Event create(Event e) {
        e.setId(counter.incrementAndGet());
        events.add(e);
        return e;
    }

    public List<Event> getAll(String sortBy) {
        if ("date".equalsIgnoreCase(sortBy)) {
            events.sort(Comparator.comparing(Event::getDateTime));
        }
        return events;
    }

    public Event update(Long id, Event updated) {
        Event e = findById(id);
        e.setTitle(updated.getTitle());
        e.setOrganizer(updated.getOrganizer());
        e.setDateTime(updated.getDateTime());
        e.setCapacity(updated.getCapacity());
        return e;
    }

    public void delete(Long id) {
        events.removeIf(e -> e.getId().equals(id));
    }

    public Event findById(Long id) {
        return events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }
}
