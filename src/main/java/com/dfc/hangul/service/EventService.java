package com.dfc.hangul.service;
import com.dfc.hangul.model.Event;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {
  public List<Event> list() { return List.of(); } // fine if no upcoming events
}
