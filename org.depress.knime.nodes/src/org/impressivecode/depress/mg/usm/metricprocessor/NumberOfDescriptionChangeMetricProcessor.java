package org.impressivecode.depress.mg.usm.metricprocessor;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.impressivecode.depress.mg.usm.UserStoryParserService;

public class NumberOfDescriptionChangeMetricProcessor implements UserStoryMetricProcessor {

	private String description = "description";
	
	@Override
	public Object computeMetric(ITSDataType row) {
		Integer numberOfDescriptionChange = 0;
		for(JiraOnlineIssueChangeRowItem issue : UserStoryParserService.parseJiraChangedHistory(row.getHistory())) {
			if (issue.getField().equalsIgnoreCase(description)) {
				numberOfDescriptionChange++;
			}
		}
		return numberOfDescriptionChange;
	}

}
