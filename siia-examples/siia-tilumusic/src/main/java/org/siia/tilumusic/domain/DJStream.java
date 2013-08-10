package org.siia.tilumusic.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.util.Assert;
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class DJStream {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((departure == null) ? 0 : departure.hashCode());
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((djCode == null) ? 0 : djCode.hashCode());
		result = prime * result
				+ ((djEventNumber == null) ? 0 : djEventNumber.hashCode());
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
		DJStream other = (DJStream) obj;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (djCode == null) {
			if (other.djCode != null)
				return false;
		} else if (!djCode.equals(other.djCode))
			return false;
		if (djEventNumber == null) {
			if (other.djEventNumber != null)
				return false;
		} else if (!djEventNumber.equals(other.djEventNumber))
			return false;
		return true;
	}
    @XmlAttribute
	private String djEventNumber;
	
    private Date departure;
	@XmlAttribute
    private String djCode;
	
    private String destination;
	
    @XmlAttribute
    private String streamUrl;
    
    @XmlAttribute 
    private String facebookpost;
    
    @XmlAttribute
    private String twitterAccount;
    
    
	
	public String getStreamUrl() {
		return streamUrl;
	}
	public String getFacebookpost() {
		return facebookpost;
	}
	public String getTwitterAccount() {
		return twitterAccount;
	}
	
	public DJStream (String djEventNumber, String facebookpost, String twitterAccount, String streamUrl){
		Assert.hasText(djEventNumber);
		Assert.hasText(facebookpost);
		Assert.hasText(twitterAccount);
		Assert.hasText(streamUrl);
		this.djEventNumber=djEventNumber;
		this.facebookpost=facebookpost;
		this.twitterAccount= twitterAccount;
		this.streamUrl=streamUrl;
	}
	/**
	 * 
	 * @param djEventNumber
	 */
	public DJStream(String djEventNumber) {
		Assert.hasText(djEventNumber);
		this.djEventNumber=djEventNumber;
	}
	/** needed to parse it by Jaxb
	 * 
	 */
	private DJStream(){
		
	}
	
	/**
	 * 
	 * @param date
	 */
	public void setScheduledDeparture(Date date) {
		// TODO Auto-generated method stub
		Assert.notNull( date);
		this.departure=date;
	}
	/**
	 * 
	 * @param string
	 */
	public void setDJCode(String djCode) {
		// TODO Auto-generated method stub
		Assert.hasText(djCode);
		this.djCode=djCode;
	}
	/**
	 * 
	 * @param string
	 */
	public void setDestination(String destination) {
		Assert.hasText(destination);
		this.destination=destination;
		
	}

	public String getDjEventNumber() {
		return djEventNumber;
	}
	public Date getDeparture() {
		return departure;
	}
	public String getDjCode() {
		return djCode;
	}
	public String getDestination() {
		return destination;
	}
}
