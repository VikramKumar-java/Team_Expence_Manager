package com.vikram.Team_expence_Manager.Controller;

import com.vikram.Team_expence_Manager.Dto.EventRequest;
import com.vikram.Team_expence_Manager.Entity.Event;
import com.vikram.Team_expence_Manager.Service.EventService;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("/createEvent")
    public ResponseEntity<Event> createEvent(
            @Valid @RequestBody EventRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(eventService.createEvent(request));
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("getEventById/{id}")
    public ResponseEntity<Event> getEventById(
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(eventService.getEventById(id));
    }
    @GetMapping("/{eventId}/members/{userId}")
    public ResponseEntity<Event> addMember(@PathVariable Long eventId , @PathVariable Long userId){
        return ResponseEntity.ok(eventService.addMember(eventId,userId));

    }
    @DeleteMapping("/{eventId}/removeMember/{userId}")
    public ResponseEntity<Event> removeMember(@PathVariable Long eventId,@PathVariable Long userId){
        return ResponseEntity.ok(eventService.removeMember(eventId,userId));
    }


    @DeleteMapping("deleteEvent/{id}")
    public ResponseEntity<Void> deleteEvent(
            @PathVariable("id") Long id) {

        eventService.deleteEvent(id);

        return ResponseEntity.noContent().build();
    }

}
