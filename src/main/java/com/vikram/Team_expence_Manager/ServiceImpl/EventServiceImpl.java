package com.vikram.Team_expence_Manager.ServiceImpl;

import com.vikram.Team_expence_Manager.Dto.EventRequest;
import com.vikram.Team_expence_Manager.Entity.Event;
import com.vikram.Team_expence_Manager.Entity.User;
import com.vikram.Team_expence_Manager.Exceptions.ResourceNotFoundException;
import com.vikram.Team_expence_Manager.Repository.EventRepo;
import com.vikram.Team_expence_Manager.Repository.UserRepo;
import com.vikram.Team_expence_Manager.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepo eventRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public Event createEvent(EventRequest x) {
        Event event = new Event();
        event.setEventName(request.eventName());
        event.setLocation(request.location());
        return eventRepo.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Event with ID " + id + " not found"
                ));
    }

    @Override
    public Event addMember(Long eventId, Long userId) {
        Event event = getEventById(eventId);
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User id not found with user" + userId));
        event.getMembers().add(user);
        return eventRepo.save(event);
    }

    @Override
    public Event removeMember(Long eventId, Long userId) {
        Event event = getEventById(eventId);
        User user = userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User with Id"+userId+"not found"));
        event.getMembers().remove(user);
        return eventRepo.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepo.delete(event);

    }
}
