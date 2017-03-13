package org.impressivecode.depress.mg.usm;

import java.util.Arrays;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfCodeListingInCommentsMetricProcessor;
import org.junit.Test;

public class NumberOfCodeListingInCommentsMetricProcessorTest {

	@Test
	public void shouldFIndCodeListings() {
		NumberOfCodeListingInCommentsMetricProcessor codeListingInCommentsMetricProcessor =
				new NumberOfCodeListingInCommentsMetricProcessor();
		
		// given
		ITSDataType itsDataType = new ITSDataType();
		itsDataType.setComments(Arrays.asList("Commen 1 <pre class=\"code-java\">aaa</pre>asdas"));
		
		Integer numberOfCodeListings = (Integer) codeListingInCommentsMetricProcessor.computeMetric(itsDataType);
		System.out.println(numberOfCodeListings);
		assert(codeListingInCommentsMetricProcessor.equals(new Integer(1)));
	}
	
}
