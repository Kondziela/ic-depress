package org.impressivecode.depress.its.jira.history;

import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.collection.ListCell;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
/**
 * 
 * @author Artur Kondziela, Capgemini Polska
 * 
 */
public class JiraHistoryAdapterTableFactory {
	public static final String HISTORY = "History";
	
	public static final DataColumnSpec[] COL_SPEC = {
		new DataColumnSpecCreator(HISTORY, ListCell.getCollectionType(StringCell.TYPE)).createSpec()	
	};
	
	public static DataTableSpec createTableSpec() {
		DataTableSpec outputSpec = new DataTableSpec(COL_SPEC);
        return outputSpec;
	}
	
}
