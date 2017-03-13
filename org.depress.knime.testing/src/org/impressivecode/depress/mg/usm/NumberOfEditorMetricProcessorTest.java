package org.impressivecode.depress.mg.usm;

import java.util.ArrayList;
import java.util.List;

import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfEditorMetricProcessor;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class NumberOfEditorMetricProcessorTest {

	@Test
	public void shouldCountNumberOfEditors() {
		// given
		JiraOnlineIssueChangeRowItem item1 = new JiraOnlineIssueChangeRowItem();
		item1.setAuthor("Author 1");
		
		JiraOnlineIssueChangeRowItem item2 = new JiraOnlineIssueChangeRowItem();
		item2.setAuthor("Author 1");
		
		JiraOnlineIssueChangeRowItem item3 = new JiraOnlineIssueChangeRowItem();
		item3.setAuthor("Author 2");
		
		List<JiraOnlineIssueChangeRowItem> changes = new ArrayList<>();
		changes.add(item1);
		changes.add(item2);
		changes.add(item3);
		
		ITSDataType row = new ITSDataType();
//		row.setChangeRowItems(changes);
		
		// when
        Integer numberOfEditors = (Integer) new NumberOfEditorMetricProcessor().computeMetric(row);

        // then
        assertThat(numberOfEditors).isEqualTo(2);
	}
	
}
