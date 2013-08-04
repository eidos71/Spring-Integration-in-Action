package test.org.siia.tilumusic;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.springframework.integration.test.matcher.HeaderMatcher.hasAllHeaders;
import static org.springframework.integration.test.matcher.HeaderMatcher.hasCorrelationId;
import static org.springframework.integration.test.matcher.HeaderMatcher.hasHeader;
import static org.springframework.integration.test.matcher.HeaderMatcher.hasHeaderKey;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.MessageHeaders;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




@ContextConfiguration("classpath:bookingdjevent.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDJeventBooking {

	@Autowired
	@Qualifier("input")
	MessageChannel inputChannel;

	@Autowired
	@Qualifier("output")
	PollableChannel outputChannel;

	private final BookDjEventCommand testBookDjCommand =
			new BookDjEventCommand("SFO", "ORD");
	
	private TestDJeventBooking getOuterType() {
		return TestDJeventBooking.this;
	}
	private Message<?> testMessage() {
		return MessageBuilder.withPayload(testBookDjCommand).build();
	}
	@Test
	public void test() {
		inputChannel.send(testMessage());
		Message<?> output = outputChannel.receive();
		assertThat((BookDjEventCommand) output.getHeaders().get("command"), is(testBookDjCommand));
	}
	@Test
	// with header matchers
	public void outputHasOriginalCommandHeaderUsingHeaderMatcher() {
		inputChannel.send(testMessage());
		Message<?> message = outputChannel.receive();
		
		assertThat(message, hasHeaderKey("command"));
		assertThat(message, hasHeader("command", notNullValue()));
		assertThat(message, hasHeader("command", is(BookDjEventCommand.class)));
		assertThat(message, hasHeader("command", testBookDjCommand));
	}
	@Test
	public void bookingDjeventExample() {
		BookDjEventCommand testBookFlightCommand =
				new BookDjEventCommand("SFO", "ORD");
		Message<?> testMessage =
				MessageBuilder.withPayload(testBookFlightCommand)
					.setCorrelationId("ABC")
					.build();
		inputChannel.send(testMessage);
		Message<?> reply = outputChannel.receive();
		assertThat(reply, hasHeaderKey("command"));
		assertThat(reply, hasHeader("command", notNullValue()));
		assertThat(reply, hasHeader("command", is(BookDjEventCommand.class)));
		assertThat(reply, hasHeader("command", testBookDjCommand));
		assertThat(reply, hasCorrelationId("ABC"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("command", testBookFlightCommand);
		map.put(MessageHeaders.CORRELATION_ID, "ABC");
		assertThat(reply, hasAllHeaders(map));
	}
	
	@Test
	public void correlationIdHeaderMatches() {
		Message<?> message = MessageBuilder.withPayload("test").setCorrelationId("ABC-123").build();
		assertThat(message, hasCorrelationId("ABC-123"));
	}

	@Test
	public void headerMapMatches() {
		Message<?> message = MessageBuilder.withPayload("test")
				.setHeader("foo", 123)
				.setHeader("bar", false)
				.build();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("foo", 123);
		map.put("bar", false);
		assertThat(message, hasAllHeaders(map));
	}
	
	/**
	 *  Inner class
	 * @author eidos71
	 *
	 */
	public class BookDjEventCommand {

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BookDjEventCommand other = (BookDjEventCommand) obj;
			if (!getOuterType().equals(other.getOuterType()))
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
			return true;
		}

		private final String djCode;
		private final String destination;

		// just an example... would have other fields as well
		public BookDjEventCommand(String djCode, String destination) {
			this.djCode = djCode;
			this.destination = destination;
		}

		public String getDjCode() {
			return djCode;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((destination == null) ? 0 : destination.hashCode());
			result = prime * result
					+ ((djCode == null) ? 0 : djCode.hashCode());
			return result;
		}

		public String getDestination() {
			return destination;
		}

		private TestDJeventBooking getOuterType() {
			return TestDJeventBooking.this;
		}
	}
}
