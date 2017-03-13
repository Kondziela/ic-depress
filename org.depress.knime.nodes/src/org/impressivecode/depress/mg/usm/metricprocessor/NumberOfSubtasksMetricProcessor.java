package org.impressivecode.depress.mg.usm.metricprocessor;

import org.impressivecode.depress.its.common.ITSDataType;

public class NumberOfSubtasksMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		return row.getSubtasks().size();
	}

}
