package org.impressivecode.depress.mg.usm.metricprocessor;

import java.util.ArrayList;
import java.util.List;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.impressivecode.depress.mg.usm.UserStoryParserService;

public class NumberOfEditorMetricProcessor implements UserStoryMetricProcessor {

	@Override
	public Object computeMetric(ITSDataType row) {
		List<String> editors = new ArrayList<>();
		for(JiraOnlineIssueChangeRowItem item : UserStoryParserService.parseJiraChangedHistory(row.getHistory())) {
			if (editors.indexOf(item.getAuthor()) == -1) {
				editors.add(item.getAuthor());
			}
		}
		return editors.size();
	}

}
