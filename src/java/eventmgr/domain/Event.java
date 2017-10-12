package eventmgr.domain;


import java.util.Date;
import java.util.Set;

public class Event {
	
	private String name;
	private Date startDate;
	private int id;
	private Location location;
        private Set<Speaker> speakers;
        
        protected void setSpeakers(Set<Speaker> speakers)
        {
            this.speakers=speakers;
        }
        public Set<Speaker> getSpeakers() { return speakers; }
        
        public void addSpeaker( Speaker speaker ) {
		if ( ! speakers.contains(speaker) ) speakers.add(speaker);
	}

    @Override
    public String toString() {
        return "Event{" + "name=" + name + ", startDate=" + startDate + ", id=" + id + ", location=" + location + ", speakers=" + speakers + '}';
    }

        
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(int id) {
		this.id = id;
	}
	public void setLocation(Location location)
	{
		this.location=location;
	}
	public Location getLocation()
	{
		return location;
	}

}
