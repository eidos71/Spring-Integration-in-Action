package org.siia.tilumusic.domain.bindings;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;

public class JodaDateTimeAdapter  extends XmlAdapter<Calendar, DateTime>{

	  @Override
	    public DateTime unmarshal(Calendar cal) throws Exception {
	        return new DateTime(cal.getTime(), ISOChronology.getInstanceUTC());
	    }

	    @Override
	    public Calendar marshal(DateTime dt) throws Exception {
	        GregorianCalendar cal = new GregorianCalendar();
	        cal.setTimeInMillis(dt.getMillis());
	        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
	        return cal;
	    }

}
