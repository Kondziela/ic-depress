package org.impressivecode.depress.mg.usm.metricprocessor;

import java.util.ArrayList;
import java.util.List;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.impressivecode.depress.mg.usm.UserStoryParserService;

public class NumberOfAssignesPersonInHistoryMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		List<String> assignedPersons = new ArrayList<>();
		for(JiraOnlineIssueChangeRowItem issue : UserStoryParserService.parseJiraChangedHistory(row.getHistory())) {
			if (issue.getField().equals("assignee")) {
				String assigendPerson = issue.getChangedTo();
				if (assigendPerson != null) {
					if (assignedPersons.indexOf(assigendPerson) == -1) {
						assignedPersons.add(assigendPerson);
					}
				}
			}
		}
		return assignedPersons.size();
	}

}
