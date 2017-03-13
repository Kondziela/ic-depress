package org.impressivecode.depress.mg.usm.metricprocessor;

import org.impressivecode.depress.its.common.ITSDataType;
/**
 * 
 * @author Artur Kondziela, Capgemini Polska
 * 
 */
public class NumberOfAttachmentsMetricProcessor implements UserStoryMetricProcessor {
	
	@Override
	public Object computeMetric(final ITSDataType row) {
		return row.getAttachments().size();
	}

}
