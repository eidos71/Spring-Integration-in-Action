package org.siia.tilumusic.binding;

import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.junit.Before;
import org.junit.Test;
import org.siia.tilumusic.domain.DJStream;
import org.siia.tilumusic.domain.clubs.ClubCalendar;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import static org.custommonkey.xmlunit.XMLAssert.*;

public class TestMarshallClubSchedule {

    final String clubCalendarMarshalled = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?>" +
            "<clubCalendar><startingCalendarSchedule>1970-01-02T00:00:00Z</startingCalendarSchedule>" +
            "<endingCalendarSchedule>1970-01-03T00:00:00Z</endingCalendarSchedule>" +
            "<djStream djEventNumber='HazardStream'/>" +
            "</clubCalendar>";

    Jaxb2Marshaller marshaller;
    @Before
    public void setUp() {
        this.marshaller = new Jaxb2Marshaller();
        this.marshaller.setClassesToBeBound(new Class[]{ClubCalendar.class});
    }
    @Test
    public void testMarshallingLeg() throws Exception{
        long day = 24 * 60 * 60 * 1000;
        ClubCalendar leg = new ClubCalendar(new DateTime(day, ISOChronology.getInstanceUTC()), new DateTime(day * 2, ISOChronology.getInstanceUTC()),
                new DJStream("HazardStream") );
        System.out.println(leg.getDjStream().getDjEventNumber().toString() );
        StringWriter writer = new StringWriter();
        StreamResult res = new StreamResult(writer);
        marshaller.marshal(leg, res);
        System.out.println(writer.getBuffer().toString() );
        assertXMLEqual("ClubCalendar marshalling incorrect", clubCalendarMarshalled, writer.getBuffer().toString());
    }

}
