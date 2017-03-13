package org.impressivecode.depress.mg.usm.metricprocessor;

import java.util.Date;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.mg.usm.HistoryDateService;

public class NumberOfCommentsDuringMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		Integer numberOfCommentsDuringStart = 0;
		Date start = HistoryDateService.dateOfBeginWorking(row);
		Date end = HistoryDateService.dateOfEndWorking(row);
		for (Date date : row.getCommentsDates()) {
			if (date.after(start) && date.before(end)) {
				numberOfCommentsDuringStart++;
			}
		}
		return numberOfCommentsDuringStart;
	}

}
