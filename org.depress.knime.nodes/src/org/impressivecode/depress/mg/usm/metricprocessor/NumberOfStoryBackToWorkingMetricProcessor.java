package org.impressivecode.depress.mg.usm.metricprocessor;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.impressivecode.depress.mg.usm.UserStoryParserService;

public class NumberOfStoryBackToWorkingMetricProcessor implements UserStoryMetricProcessor {

	private final String done = "done";
	private final String pullRequest = "Pull Request";
	private final String status = "status";
	
	@Override
	public Object computeMetric(ITSDataType row) {
		Integer numberOfStatusBackToWorking = 0;
		for(JiraOnlineIssueChangeRowItem item : UserStoryParserService.parseJiraChangedHistory(row.getHistory())) {
			if (item.getField().equalsIgnoreCase(status)) {
				if (item.getChangedFrom().equalsIgnoreCase(done)) {
					numberOfStatusBackToWorking++;
				}
				if (item.getChangedFrom().equalsIgnoreCase(pullRequest) && !item.getChangedTo().equalsIgnoreCase(done)) {
					numberOfStatusBackToWorking++;
				}
			}
		}
		return numberOfStatusBackToWorking;
	}

}
