package org.impressivecode.depress.mg.usm;

import java.util.Date;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;

public class HistoryDateService {

	// TODO[AKO]: check what when reopen
	
	private static final String IN_PROGRESS = "In Progress";
	private static final String STATUS = "status";
	private static final String DONE = "done";
	
	public static Date dateOfBeginWorking(ITSDataType row) {
		for(JiraOnlineIssueChangeRowItem item : UserStoryParserService.parseJiraChangedHistory(row.getHistory())) {
			if (item.getField().equalsIgnoreCase(STATUS)) {
				if (item.getChangedTo().equalsIgnoreCase(IN_PROGRESS)) {
					return item.getTimestamp();
				}
			}
		}
		return new Date();
	}
	
	public static Date dateOfEndWorking(ITSDataType row) {
		for(JiraOnlineIssueChangeRowItem item : UserStoryParserService.parseJiraChangedHistory(row.getHistory())) {
			if (item.getField().equalsIgnoreCase(STATUS)) {
				if (item.getChangedTo().equalsIgnoreCase(DONE)) {
					return item.getTimestamp();
				}
			}
		}
		return new Date();
	}
	
}
