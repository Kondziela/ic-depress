package org.impressivecode.depress.mg.usm.metricprocessor;

import java.util.Date;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.mg.usm.HistoryDateService;

public class NumberOfCommentsBeforeStartMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		Integer numberOfCommentsBeforeStart = 0;
		Date start = HistoryDateService.dateOfBeginWorking(row);
		for (Date date : row.getCommentsDates()) {
			if (date.before(start)) {
				numberOfCommentsBeforeStart++;
			}
		}
		return numberOfCommentsBeforeStart;
	}

}
