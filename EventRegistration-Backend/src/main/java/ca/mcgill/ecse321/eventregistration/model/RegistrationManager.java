package ca.mcgill.ecse321.eventregistration.model;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 20 "model.ump"
// line 63 "model.ump"
public class RegistrationManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegistrationManager Associations
  private List<Registration> registrations;
  private List<Event> events;
  private List<Person> participants;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RegistrationManager()
  {
    registrations = new ArrayList<Registration>();
    events = new ArrayList<Event>();
    participants = new ArrayList<Person>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Registration getRegistration(int index)
  {
    Registration aRegistration = registrations.get(index);
    return aRegistration;
  }

  public List<Registration> getRegistrations()
  {
    List<Registration> newRegistrations = Collections.unmodifiableList(registrations);
    return newRegistrations;
  }

  public int numberOfRegistrations()
  {
    int number = registrations.size();
    return number;
  }

  public boolean hasRegistrations()
  {
    boolean has = registrations.size() > 0;
    return has;
  }

  public int indexOfRegistration(Registration aRegistration)
  {
    int index = registrations.indexOf(aRegistration);
    return index;
  }
  /* Code from template association_GetMany */
  public Event getEvent(int index)
  {
    Event aEvent = events.get(index);
    return aEvent;
  }

  public List<Event> getEvents()
  {
    List<Event> newEvents = Collections.unmodifiableList(events);
    return newEvents;
  }

  public int numberOfEvents()
  {
    int number = events.size();
    return number;
  }

  public boolean hasEvents()
  {
    boolean has = events.size() > 0;
    return has;
  }

  public int indexOfEvent(Event aEvent)
  {
    int index = events.indexOf(aEvent);
    return index;
  }
  /* Code from template association_GetMany */
  public Person getParticipant(int index)
  {
    Person aParticipant = participants.get(index);
    return aParticipant;
  }

  public List<Person> getParticipants()
  {
    List<Person> newParticipants = Collections.unmodifiableList(participants);
    return newParticipants;
  }

  public int numberOfParticipants()
  {
    int number = participants.size();
    return number;
  }

  public boolean hasParticipants()
  {
    boolean has = participants.size() > 0;
    return has;
  }

  public int indexOfParticipant(Person aParticipant)
  {
    int index = participants.indexOf(aParticipant);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRegistrations()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Registration addRegistration(int aId, Event aEvent, Person aParticipant)
  {
    return new Registration(aId, this, aEvent, aParticipant);
  }

  public boolean addRegistration(Registration aRegistration)
  {
    boolean wasAdded = false;
    if (registrations.contains(aRegistration)) { return false; }
    RegistrationManager existingRegistrationManager = aRegistration.getRegistrationManager();
    boolean isNewRegistrationManager = existingRegistrationManager != null && !this.equals(existingRegistrationManager);
    if (isNewRegistrationManager)
    {
      aRegistration.setRegistrationManager(this);
    }
    else
    {
      registrations.add(aRegistration);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRegistration(Registration aRegistration)
  {
    boolean wasRemoved = false;
    //Unable to remove aRegistration, as it must always have a registrationManager
    if (!this.equals(aRegistration.getRegistrationManager()))
    {
      registrations.remove(aRegistration);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRegistrationAt(Registration aRegistration, int index)
  {  
    boolean wasAdded = false;
    if(addRegistration(aRegistration))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRegistrations()) { index = numberOfRegistrations() - 1; }
      registrations.remove(aRegistration);
      registrations.add(index, aRegistration);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRegistrationAt(Registration aRegistration, int index)
  {
    boolean wasAdded = false;
    if(registrations.contains(aRegistration))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRegistrations()) { index = numberOfRegistrations() - 1; }
      registrations.remove(aRegistration);
      registrations.add(index, aRegistration);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRegistrationAt(aRegistration, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEvents()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Event addEvent(String aName, Date aEventDate, Time aStartTime, Time aEndTime)
  {
    return new Event(aName, aEventDate, aStartTime, aEndTime, this);
  }

  public boolean addEvent(Event aEvent)
  {
    boolean wasAdded = false;
    if (events.contains(aEvent)) { return false; }
    RegistrationManager existingRegistrationManager = aEvent.getRegistrationManager();
    boolean isNewRegistrationManager = existingRegistrationManager != null && !this.equals(existingRegistrationManager);
    if (isNewRegistrationManager)
    {
      aEvent.setRegistrationManager(this);
    }
    else
    {
      events.add(aEvent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEvent(Event aEvent)
  {
    boolean wasRemoved = false;
    //Unable to remove aEvent, as it must always have a registrationManager
    if (!this.equals(aEvent.getRegistrationManager()))
    {
      events.remove(aEvent);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEventAt(Event aEvent, int index)
  {  
    boolean wasAdded = false;
    if(addEvent(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEventAt(Event aEvent, int index)
  {
    boolean wasAdded = false;
    if(events.contains(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEventAt(aEvent, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfParticipants()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Person addParticipant(String aName)
  {
    return new Person(aName, this);
  }

  public boolean addParticipant(Person aParticipant)
  {
    boolean wasAdded = false;
    if (participants.contains(aParticipant)) { return false; }
    RegistrationManager existingRegistrationManager = aParticipant.getRegistrationManager();
    boolean isNewRegistrationManager = existingRegistrationManager != null && !this.equals(existingRegistrationManager);
    if (isNewRegistrationManager)
    {
      aParticipant.setRegistrationManager(this);
    }
    else
    {
      participants.add(aParticipant);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeParticipant(Person aParticipant)
  {
    boolean wasRemoved = false;
    //Unable to remove aParticipant, as it must always have a registrationManager
    if (!this.equals(aParticipant.getRegistrationManager()))
    {
      participants.remove(aParticipant);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addParticipantAt(Person aParticipant, int index)
  {  
    boolean wasAdded = false;
    if(addParticipant(aParticipant))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParticipants()) { index = numberOfParticipants() - 1; }
      participants.remove(aParticipant);
      participants.add(index, aParticipant);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveParticipantAt(Person aParticipant, int index)
  {
    boolean wasAdded = false;
    if(participants.contains(aParticipant))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParticipants()) { index = numberOfParticipants() - 1; }
      participants.remove(aParticipant);
      participants.add(index, aParticipant);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addParticipantAt(aParticipant, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (registrations.size() > 0)
    {
      Registration aRegistration = registrations.get(registrations.size() - 1);
      aRegistration.delete();
      registrations.remove(aRegistration);
    }
    
    while (events.size() > 0)
    {
      Event aEvent = events.get(events.size() - 1);
      aEvent.delete();
      events.remove(aEvent);
    }
    
    while (participants.size() > 0)
    {
      Person aParticipant = participants.get(participants.size() - 1);
      aParticipant.delete();
      participants.remove(aParticipant);
    }
    
  }

}