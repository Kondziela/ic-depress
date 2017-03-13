package org.impressivecode.depress.mg.usm;

import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

public class UserStoryParserServiceTest {
	
	@Test
	public void shouldConvertOneJiraIssue() {
		// given
		String jiraIssue = "key:KEY1,"
				+ "timestamp:0,"
				+ "author:Artur,"
				+ "field:description,"
				+ "changedFrom:Nothing,"
				+ "changedTo:Something";
		
		// when
		JiraOnlineIssueChangeRowItem issue = UserStoryParserService.parseJiraIssueFromString(jiraIssue);

		assertThat(issue.getKey()).isEqualTo("KEY1");
		assertThat(issue.getTimestamp()).isEqualTo(new Date(new Long(0)));
		assertThat(issue.getAuthor()).isEqualTo("Artur");
		assertThat(issue.getField()).isEqualTo("description");
		assertThat(issue.getChangedFrom()).isEqualTo("Nothing");
		assertThat(issue.getChangedTo()).isEqualTo("Something");
	}

}
