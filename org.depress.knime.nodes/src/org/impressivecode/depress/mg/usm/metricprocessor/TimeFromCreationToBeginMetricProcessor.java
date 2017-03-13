package org.impressivecode.depress.mg.usm.metricprocessor;

import java.util.Date;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.mg.usm.HistoryDateService;

public class TimeFromCreationToBeginMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		Date start = HistoryDateService.dateOfBeginWorking(row);
		Date create = row.getCreated();
		return new Long(start.getTime() - create.getTime());
	}

}
