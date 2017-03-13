package org.impressivecode.depress.mg.usm.metricprocessor;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.impressivecode.depress.mg.usm.UserStoryParserService;

public class NumberOfPriorityChangeMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		Integer numberOfPriorityChange = 0;
		for(JiraOnlineIssueChangeRowItem item : UserStoryParserService.parseJiraChangedHistory(row.getHistory())) {
			if (item.getField().equalsIgnoreCase("Priority")) {
				numberOfPriorityChange++;
			}
		}
		return numberOfPriorityChange;
	}

}
