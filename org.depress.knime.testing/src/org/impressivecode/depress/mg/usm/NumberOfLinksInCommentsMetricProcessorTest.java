package org.impressivecode.depress.mg.usm;

import java.util.Arrays;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfLinksInCommentsMetricProcessor;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class NumberOfLinksInCommentsMetricProcessorTest {

	@Test
	public void shouldNotCrashWhenNonComments() {
		// given
				ITSDataType data = new ITSDataType();
				
				// when
				Integer numberOfLinksInComments = (Integer) new NumberOfLinksInCommentsMetricProcessor().computeMetric(data);
				
				// then
				assertThat(numberOfLinksInComments).isEqualTo(0);
	}
	
	@Test
	public void shouldCountNumberOfLInks() {
		// given
		ITSDataType data = new ITSDataType();
		data.setCommentsWithoutClean(Arrays.asList(
				"This is a link <a class=\"external-link\">link.link</a>",
				"this is not link something.something",
				"Another link <a class=\"external-link\">http://link.link</a>"));
		
		// when
		Integer numberOfLinksInComments = (Integer) new NumberOfLinksInCommentsMetricProcessor().computeMetric(data);
		
		// then
		assertThat(numberOfLinksInComments).isEqualTo(2);
		
	}
	
}
