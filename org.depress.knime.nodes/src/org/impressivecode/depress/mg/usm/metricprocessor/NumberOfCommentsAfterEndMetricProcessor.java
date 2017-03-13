package org.impressivecode.depress.mg.usm.metricprocessor;

import java.util.Date;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.mg.usm.HistoryDateService;

public class NumberOfCommentsAfterEndMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		Integer numberOfCommentsAfterStart = 0;
		Date end = HistoryDateService.dateOfEndWorking(row);
		for (Date date : row.getCommentsDates()) {
			if (date.after(end)) {
				numberOfCommentsAfterStart++;
			}
		}
		return numberOfCommentsAfterStart;
	}

}
