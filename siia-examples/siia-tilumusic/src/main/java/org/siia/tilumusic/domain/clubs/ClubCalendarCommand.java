package org.siia.tilumusic.domain.clubs;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAccessType;

import org.joda.time.DateTime;
import org.siia.tilumusic.domain.DJStream;
import org.siia.tilumusic.domain.bindings.JodaDateTimeAdapter;
import org.siia.tilumusic.domain.bindings.ListDJStreamAdapter;

@XmlRootElement(name="clubCalendar")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClubCalendarCommand {
	@XmlElement
	@XmlJavaTypeAdapter(JodaDateTimeAdapter.class)
	private DateTime startingCalendarSchedule;
	@XmlElement
	@XmlJavaTypeAdapter(JodaDateTimeAdapter.class)
	private DateTime endingCalendarSchedule;
	
	@XmlElement
	private DJStream djStream;
	  	@XmlElementWrapper(name="list-djstream")
	    @XmlElement(name="djStream")
	private List<DJStream> listdjStream;
	
	
	
	public DateTime getStartingCalendarSchedule() {
		return startingCalendarSchedule;
	}

	public DateTime getEndingCalendarSchedule() {
		return endingCalendarSchedule;
	}

	public DJStream getDjStream() {
		System.out.println("djStream->"+ djStream.getDjEventNumber() );
		return djStream;
	}
	public List<DJStream> getListDJStream(){
		return listdjStream;
	}

	private ClubCalendarCommand(){
		
	}
	public ClubCalendarCommand  (DateTime startingCalendarSchedule, DateTime endingCalendarSchedule,
			DJStream djStream ){
		this.startingCalendarSchedule=startingCalendarSchedule;
		this.endingCalendarSchedule=endingCalendarSchedule;
		this.djStream=djStream;
	}
	public ClubCalendarCommand  (DateTime startingCalendarSchedule, DateTime endingCalendarSchedule,
			List<DJStream> djStream ){
		this.startingCalendarSchedule=startingCalendarSchedule;
		this.endingCalendarSchedule=endingCalendarSchedule;
		this.listdjStream=djStream;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((djStream == null) ? 0 : djStream.hashCode());
		result = prime
				* result
				+ ((endingCalendarSchedule == null) ? 0
						: endingCalendarSchedule.hashCode());
		result = prime
				* result
				+ ((startingCalendarSchedule == null) ? 0
						: startingCalendarSchedule.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClubCalendarCommand other = (ClubCalendarCommand) obj;
		if (djStream == null) {
			if (other.djStream != null)
				return false;
		} else if (!djStream.equals(other.djStream))
			return false;
		if (endingCalendarSchedule == null) {
			if (other.endingCalendarSchedule != null)
				return false;
		} else if (!endingCalendarSchedule.equals(other.endingCalendarSchedule))
			return false;
		if (startingCalendarSchedule == null) {
			if (other.startingCalendarSchedule != null)
				return false;
		} else if (!startingCalendarSchedule
				.equals(other.startingCalendarSchedule))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClubCalendarCommand [startingCalendarSchedule="
				+ startingCalendarSchedule + ", endingCalendarSchedule="
				+ endingCalendarSchedule + "]";
	}
	
	
}
