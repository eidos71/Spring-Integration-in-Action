package org.siia.tilumusic.binding;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.siia.tilumusic.domain.DJStream;
import org.siia.tilumusic.domain.clubs.ClubCalendarCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.oxm.Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.xml.transform.StringResult;
import org.w3c.dom.Document;
@ContextConfiguration("classpath:org/siia/tilumusic/clubstream/ClubScheduleTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestClubSchedule {
    @Resource(name = "javaClubCalendarCommands")
    MessageChannel clubRequestsChannel;
    @Resource (name="xmlClubQuotes")
    PollableChannel clubQuotesChannel;
    
    ClubCalendarCommand exampleClubcommand ;
    
    @Autowired
    Marshaller marshaller;
    final String clubCalendarMarshalled = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?>"
    		+ "<clubCalendar>"
    		+ "<startingCalendarSchedule>1970-01-02T00:00:00Z</startingCalendarSchedule>"
    		+ "<endingCalendarSchedule>1970-01-03T00:00:00Z</endingCalendarSchedule>"
    		+ "<list-djstream>"
    		+ "<djStream djEventNumber='HazardStream'/><djStream djEventNumber='TishaStream'/><djStream djEventNumber='AlisaStream'/>"
    		+ "</list-djstream>"
    		+ "</clubCalendar>";
    @Before
    public void setUp() {

    	 long day = 24 * 60 * 60 * 1000;
    	  ArrayList <DJStream> a= new ArrayList<DJStream>();
    	   a.add(new DJStream("HazardStream")) ;
    	   a.add(new DJStream("TishaStream")) ;
    	   a.add(new DJStream("AlisaStream")) ;
    	   exampleClubcommand = new ClubCalendarCommand(new DateTime(day, ISOChronology.getInstanceUTC()), new DateTime(day * 2, ISOChronology.getInstanceUTC()),
               a);
    }
	@Test
	public void test() throws Exception {
        this.clubRequestsChannel.send(MessageBuilder.withPayload(exampleClubcommand).build(), 1000);
        Message<?> asXml = this.clubQuotesChannel.receive(5000);
        assertNotNull(asXml);
       String result= xmlDocToString((Document) asXml.getPayload());
        assertXMLEqual("ClubCalendarCommand marshalling incorrect", clubCalendarMarshalled, result);
	}
    public String xmlDocToString(Document doc) throws Exception {
        StringResult res = new StringResult();
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), res);
        return res.getWriter().toString();
    }
}
