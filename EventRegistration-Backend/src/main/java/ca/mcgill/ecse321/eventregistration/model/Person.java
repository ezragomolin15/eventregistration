package ca.mcgill.ecse321.eventregistration.model;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 2 "model.ump"
// line 48 "model.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;

  //Person Associations
  private RegistrationManager registrationManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, RegistrationManager aRegistrationManager)
  {
    name = aName;
    boolean didAddRegistrationManager = setRegistrationManager(aRegistrationManager);
    if (!didAddRegistrationManager)
    {
      throw new RuntimeException("Unable to create participant due to registrationManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetOne */
  public RegistrationManager getRegistrationManager()
  {
    return registrationManager;
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
      existingRegistrationManager.removeParticipant(this);
    }
    registrationManager.addParticipant(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    RegistrationManager placeholderRegistrationManager = registrationManager;
    this.registrationManager = null;
    if(placeholderRegistrationManager != null)
    {
      placeholderRegistrationManager.removeParticipant(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "registrationManager = "+(getRegistrationManager()!=null?Integer.toHexString(System.identityHashCode(getRegistrationManager())):"null");
  }
}