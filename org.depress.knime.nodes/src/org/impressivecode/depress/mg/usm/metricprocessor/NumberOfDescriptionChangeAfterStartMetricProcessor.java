package org.impressivecode.depress.mg.usm.metricprocessor;

import java.util.Date;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.impressivecode.depress.mg.usm.HistoryDateService;
import org.impressivecode.depress.mg.usm.UserStoryParserService;

public class NumberOfDescriptionChangeAfterStartMetricProcessor implements UserStoryMetricProcessor {

	private String description = "description";
	
	@Override
	public Object computeMetric(ITSDataType row) {
		Integer numberOfDescriptionChangeAfterStart = 0;
		Date startDate = HistoryDateService.dateOfBeginWorking(row);
		for(JiraOnlineIssueChangeRowItem issue : UserStoryParserService.parseJiraChangedHistory(row.getHistory())) {
			if (issue.getField().equalsIgnoreCase(description) && issue.getTimestamp().after(startDate)) {
				numberOfDescriptionChangeAfterStart++;
			}
		}
		return numberOfDescriptionChangeAfterStart;
	}

}
