package com.vikram.Team_expence_Manager.Service;

import com.vikram.Team_expence_Manager.Dto.EventRequest;
import com.vikram.Team_expence_Manager.Entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventService {
    Event createEvent(EventRequest request);

    List<Event> getAllEvents();

    Event getEventById(Long id);

    public Event addMember(Long eventId, Long userID);

    public Event removeMember(Long eventId,Long userId);

    void deleteEvent(Long id);
}
