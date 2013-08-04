package org.siia.tilumusic.domain;

import java.util.Date;
import java.util.Map;

import org.w3c.dom.Document;

public class BookDjEvent {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((band == null) ? 0 : band.hashCode());
		result = prime * result
				+ ((djEventCode == null) ? 0 : djEventCode.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result
				+ ((scheduledEvent == null) ? 0 : scheduledEvent.hashCode());
		result = prime * result
				+ ((spectator == null) ? 0 : spectator.hashCode());
		result = prime * result
				+ ((travelmode == null) ? 0 : travelmode.hashCode());
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
		BookDjEvent other = (BookDjEvent) obj;
		if (band == null) {
			if (other.band != null)
				return false;
		} else if (!band.equals(other.band))
			return false;
		if (djEventCode == null) {
			if (other.djEventCode != null)
				return false;
		} else if (!djEventCode.equals(other.djEventCode))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (scheduledEvent == null) {
			if (other.scheduledEvent != null)
				return false;
		} else if (!scheduledEvent.equals(other.scheduledEvent))
			return false;
		if (spectator == null) {
			if (other.spectator != null)
				return false;
		} else if (!spectator.equals(other.spectator))
			return false;
		if (travelmode == null) {
			if (other.travelmode != null)
				return false;
		} else if (!travelmode.equals(other.travelmode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookDjEvent [djEventCode=" + djEventCode + ", scheduledEvent="
				+ scheduledEvent + ", place=" + place + ", travelmode="
				+ travelmode + ", band=" + band + ", spectator=" + spectator
				+ "]";
	}
	public String getDjEventCode() {
		return djEventCode;
	}
	public void setDjEventCode(String djEventCode) {
		this.djEventCode = djEventCode;
	}
	public Date getScheduledEvent() {
		return scheduledEvent;
	}
	public void setScheduledEvent(Date scheduledEvent) {
		this.scheduledEvent = scheduledEvent;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Travelmode getTravelmode() {
		return travelmode;
	}
	public void setTravelmode(Travelmode travelmode) {
		this.travelmode = travelmode;
	}
	public Map<Seat, Spectator> getSpectator() {
		return spectator;
	}
	public void setSpectator(Map<Seat, Spectator> spectator) {
		this.spectator = spectator;
	}

	private String djEventCode;
	private Date scheduledEvent;
	private String place;
	private Travelmode travelmode;
	private Bands band;
	private Map <Seat, Spectator> spectator; 
}
