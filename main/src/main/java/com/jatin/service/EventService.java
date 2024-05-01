package com.jatin.service;

import com.jatin.model.Event;
import com.jatin.model.Restaurant;
import com.jatin.request.CreateEventRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "http://localhost:8083", value = "Event-Service-Client")
public interface EventService {
    @PostMapping("/api/admin/events")
    public Event createEvent(@RequestBody CreateEventRequest req, @RequestHeader("Authorization") String jwt);

    @DeleteMapping("/api/admin/events/{eventId}")
    public void deleteEvent(@PathVariable Long eventId, @RequestHeader("Authorization") String jwt) throws Exception;

    @GetMapping("/api/admin/events/restaurant/{restaurantId}")
    public List<Event> getRestaurantEvents(@PathVariable Long restaurantId);
}
