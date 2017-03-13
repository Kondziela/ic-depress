package org.impressivecode.depress.mg.usm.metricprocessor;

import org.impressivecode.depress.its.common.ITSDataType;

/**
 * 
 * @author Artur Kondziela, Capgemini Polska
 * 
 */

public interface UserStoryMetricProcessor {
	
	Object computeMetric(final ITSDataType row);

}
