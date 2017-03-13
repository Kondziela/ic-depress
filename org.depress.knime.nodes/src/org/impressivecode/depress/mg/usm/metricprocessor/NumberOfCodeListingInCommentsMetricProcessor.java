package org.impressivecode.depress.mg.usm.metricprocessor;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.xmlbeans.impl.jam.JSourcePosition;
import org.codehaus.plexus.util.StringUtils;
import org.impressivecode.depress.its.common.ITSDataType;

public class NumberOfCodeListingInCommentsMetricProcessor implements UserStoryMetricProcessor{
	
	@Override
	public Object computeMetric(ITSDataType row) {
		Integer numberOfCodeListings = 0;
		// TODO[AKO]: check if pre value is correct
		for(String comment : row.getCommentsWithoutClean()) {
			numberOfCodeListings += numberOfJavaListings(comment);
		}
		return numberOfCodeListings;
	}
	
	private Integer numberOfJavaListings(String comment) {
		return comment.split("<pre class=\"code-java\">").length -1;
	}

}
