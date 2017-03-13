package org.impressivecode.depress.mg.usm.metricprocessor;

import org.impressivecode.depress.its.common.ITSDataType;

public class NumberOfLinksInCommentsMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		Integer numberOfLinksInComments = 0;
		for(String comment : row.getCommentsWithoutClean()) {
			numberOfLinksInComments += comment.split("class=\"external-link\"").length -1;
		}
		return numberOfLinksInComments;
	}

}
