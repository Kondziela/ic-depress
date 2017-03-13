package org.impressivecode.depress.mg.usm;

import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.collection.ListCell;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
/**
 * 
 * @author Artur Kondziela, Capgemini Polska
 * 
 */

public class UserStoryMetricAdapterTableFactory {
	public static final String COMMENTS_COUNT = "Comments Count";
	public static final String ATTACHMENTS_COUNT = "Attachments Count";
	public static final String SUBTASKS_COUNT = "Number of subtasks";
	public static final String CODE_LISTINGS_IN_COMMENTS = "Code listings in comments";
	public static final String LINKS_IN_COMMENTS = "Links in coments";
	public static final String NUMBER_OF_ASSIGNED_PERSON = "Assigned person";
	public static final String NUMBER_OF_EDITORS = "Editors";
	public static final String NUMBER_OF_DESCRIPTION_CHANGE = "Description changes";
	public static final String NUMBER_OF_PRIORITY_CHANGE = "Priority changes";
	public static final String NUMBER_OF_STATUS_CHANGE = "Status changes";
	public static final String NUMBER_OF_DESCRIPTION_CHANGE_AFTER_START = "AS Description changes";
	public static final String NUMBER_OF_COMMENTS_BEFORE_START = "Comments before start";
    public static final String NUMBER_OF_COMMENTS_DURING = "Comments during";
    public static final String NUMBER_OF_COMMENTS_AFTER_END = "Comments after end";
    public static final String NUMBER_OF_BACK_TO_WORKING = "Number of back to working";
	public static final String DURATION_US = "Duration User Story";
	public static final String TIME_FROM_CREATION_TO_BEGIN = "Creation -> Start";

	
	 public static final DataColumnSpec[] COL_SPEC = {
			 new DataColumnSpecCreator(COMMENTS_COUNT, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(ATTACHMENTS_COUNT, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(SUBTASKS_COUNT, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(CODE_LISTINGS_IN_COMMENTS, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(LINKS_IN_COMMENTS, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_ASSIGNED_PERSON, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_EDITORS, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_DESCRIPTION_CHANGE, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_PRIORITY_CHANGE, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_STATUS_CHANGE, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_DESCRIPTION_CHANGE_AFTER_START, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_COMMENTS_BEFORE_START, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_COMMENTS_DURING, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_COMMENTS_AFTER_END, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(NUMBER_OF_BACK_TO_WORKING, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(DURATION_US, IntCell.TYPE).createSpec(),
			 new DataColumnSpecCreator(TIME_FROM_CREATION_TO_BEGIN, IntCell.TYPE).createSpec()
	 };
}
