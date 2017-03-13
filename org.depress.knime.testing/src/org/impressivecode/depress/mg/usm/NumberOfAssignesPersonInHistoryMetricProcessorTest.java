package org.impressivecode.depress.mg.usm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfAssignesPersonInHistoryMetricProcessor;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class NumberOfAssignesPersonInHistoryMetricProcessorTest {

	@Test
	public void shouldCountAssignedPersons() {
		// given
		JiraOnlineIssueChangeRowItem item1 = new JiraOnlineIssueChangeRowItem();
		item1.setField("assignee");
		item1.setChangedTo("User 1");
		
		JiraOnlineIssueChangeRowItem item2 = new JiraOnlineIssueChangeRowItem();
		item2.setField("assignee");
		item2.setChangedTo(null);
		
		JiraOnlineIssueChangeRowItem item3 = new JiraOnlineIssueChangeRowItem();
		item3.setField("assignee");
		item3.setChangedTo("User 1");
		
		JiraOnlineIssueChangeRowItem item4 = new JiraOnlineIssueChangeRowItem();
		item4.setField("assignee");
		item4.setChangedTo("User 2");
		
		List<JiraOnlineIssueChangeRowItem> changedRowItems = new ArrayList<>();
		changedRowItems.add(item1);
		changedRowItems.add(item2);
		changedRowItems.add(item3);
		changedRowItems.add(item4);
		
		ITSDataType row = new ITSDataType();
//		row.setChangeRowItems(changedRowItems.);
		
		// when
		Integer numberOfAssignedPersons = (Integer) new NumberOfAssignesPersonInHistoryMetricProcessor().computeMetric(row);
		
		// then
		assertThat(numberOfAssignedPersons).isEqualTo(2);
	}
	
}
