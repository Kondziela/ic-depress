package org.impressivecode.depress.mg.usm.metricprocessor;

import java.util.Date;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.mg.usm.HistoryDateService;

public class DurationUserStoryMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		Date start = HistoryDateService.dateOfBeginWorking(row);
		Date end = HistoryDateService.dateOfEndWorking(row);
		return new Long(end.getTime() - start.getTime());
	}

}
