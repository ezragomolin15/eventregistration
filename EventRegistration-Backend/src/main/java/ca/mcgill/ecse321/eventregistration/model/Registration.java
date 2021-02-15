package ca.mcgill.ecse321.eventregistration.model;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 15 "model.ump"
// line 58 "model.ump"
public class Registration
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Registration Attributes
  private int id;

  //Registration Associations
  private RegistrationManager registrationManager;
  private Event event;
  private Person participant;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Registration(int aId, RegistrationManager aRegistrationManager, Event aEvent, Person aParticipant)
  {
    id = aId;
    boolean didAddRegistrationManager = setRegistrationManager(aRegistrationManager);
    if (!didAddRegistrationManager)
    {
      throw new RuntimeException("Unable to create registration due to registrationManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setEvent(aEvent))
    {
      throw new RuntimeException("Unable to create Registration due to aEvent. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setParticipant(aParticipant))
    {
      throw new RuntimeException("Unable to create Registration due to aParticipant. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }
  /* Code from template association_GetOne */
  public RegistrationManager getRegistrationManager()
  {
    return registrationManager;
  }
  /* Code from template association_GetOne */
  public Event getEvent()
  {
    return event;
  }
  /* Code from template association_GetOne */
  public Person getParticipant()
  {
    return participant;
  }
  /* Code from template association_SetOneToMany */
  public boolean setRegistrationManager(RegistrationManager aRegistrationManager)
  {
    boolean wasSet = false;
    if (aRegistrationManager == null)
    {
      return wasSet;
    }

    RegistrationManager existingRegistrationManager = registrationManager;
    registrationManager = aRegistrationManager;
    if (existingRegistrationManager != null && !existingRegistrationManager.equals(aRegistrationManager))
    {
      existingRegistrationManager.removeRegistration(this);
    }
    registrationManager.addRegistration(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setEvent(Event aNewEvent)
  {
    boolean wasSet = false;
    if (aNewEvent != null)
    {
      event = aNewEvent;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setParticipant(Person aNewParticipant)
  {
    boolean wasSet = false;
    if (aNewParticipant != null)
    {
      participant = aNewParticipant;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    RegistrationManager placeholderRegistrationManager = registrationManager;
    this.registrationManager = null;
    if(placeholderRegistrationManager != null)
    {
      placeholderRegistrationManager.removeRegistration(this);
    }
    event = null;
    participant = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "registrationManager = "+(getRegistrationManager()!=null?Integer.toHexString(System.identityHashCode(getRegistrationManager())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "event = "+(getEvent()!=null?Integer.toHexString(System.identityHashCode(getEvent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "participant = "+(getParticipant()!=null?Integer.toHexString(System.identityHashCode(getParticipant())):"null");
  }
}
