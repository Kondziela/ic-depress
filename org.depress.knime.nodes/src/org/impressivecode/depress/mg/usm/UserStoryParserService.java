package org.impressivecode.depress.mg.usm;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;

public class UserStoryParserService {
	
	public static JiraOnlineIssueChangeRowItem parseJiraIssueFromString(String issueString) {
		JsonReader jsonReader = Json.createReader(new StringReader(issueString));
		JsonObject issue = jsonReader.readObject();
		jsonReader.close();
		return new JiraOnlineIssueChangeRowItem(issue);
	}
	
	public static List<JiraOnlineIssueChangeRowItem> parseJiraChangedHistory(List<String> changedHistory) {
		List<JiraOnlineIssueChangeRowItem> issues = new ArrayList<>();
		for(String issue : changedHistory) {
			issues.add(UserStoryParserService.parseJiraIssueFromString(issue));
		}
		return issues;
	}

}
