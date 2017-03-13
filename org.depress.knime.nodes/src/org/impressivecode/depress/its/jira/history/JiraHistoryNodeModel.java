package org.impressivecode.depress.its.jira.history;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.impressivecode.depress.common.Cells;
import org.impressivecode.depress.common.TableCellReader;
import org.impressivecode.depress.its.common.ITSAdapterTableFactory;
import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.common.ITSInputTransformer;
import org.impressivecode.depress.mg.usm.UserStoryMetricAdapterTableFactory;
import org.impressivecode.depress.mg.usm.UserStoryMetricNodeModel.CellFactory;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfAssignesPersonInHistoryMetricProcessor;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfAttachmentsMetricProcessor;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfCodeListingInCommentsMetricProcessor;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfCommentsMetricProcessor;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfEditorMetricProcessor;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfLinksInCommentsMetricProcessor;
import org.impressivecode.depress.mg.usm.metricprocessor.NumberOfSubtasksMetricProcessor;
import org.knime.base.data.append.column.AppendedCellFactory;
import org.knime.base.data.append.column.AppendedColumnTable;
import org.knime.base.node.io.filereader.DataCellFactory;
import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTable;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.container.DataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;

import com.google.common.base.Preconditions;

public class JiraHistoryNodeModel extends NodeModel{

	protected JiraHistoryNodeModel() {
		super(1,1);
	}
	
	@Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData, final ExecutionContext exec)
            throws Exception {

        AppendedColumnTable table = new AppendedColumnTable(inData[0], cellFactory(inData[0]), JiraHistoryAdapterTableFactory.COL_SPEC);

        return new BufferedDataTable[] { preapreTable(table, exec) };
    }

    private CellFactory cellFactory(final BufferedDataTable inData) {
        return new CellFactory();
    }

    private BufferedDataTable preapreTable(final AppendedColumnTable table, final ExecutionContext exec)
            throws CanceledExecutionException {
        return exec.createBufferedDataTable(table, exec);
    }

    @Override
    protected void reset() {
        // NOOP
    }

    @Override
    protected DataTableSpec[] configure(final DataTableSpec[] inSpecs) throws InvalidSettingsException {
        Preconditions.checkArgument(inSpecs.length == 1);
        validate(inSpecs[0]);

        final DataTableSpec dts = AppendedColumnTable.getTableSpec(inSpecs[0], JiraHistoryAdapterTableFactory.COL_SPEC);

        return new DataTableSpec[] { dts };
    }

    private void validate(final DataTableSpec spec) throws InvalidSettingsException {
        checkNotNull(spec, "DataTableSpec hat to be set");
        new ITSInputTransformer().setMinimalSpec(new DataTableSpec(ITSAdapterTableFactory.LINK)).setInputSpec(spec).validate();
    }

    @Override
    protected void saveSettingsTo(final NodeSettingsWO settings) {
        // Do nothing
    }

    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings) throws InvalidSettingsException {
        // Do nothing
    }

    @Override
    protected void validateSettings(final NodeSettingsRO settings) throws InvalidSettingsException {
        // Do nothing
    }

    @Override
    protected void loadInternals(final File internDir, final ExecutionMonitor exec) throws IOException,
    CanceledExecutionException {
        // NOOP
    }

    @Override
    protected void saveInternals(final File internDir, final ExecutionMonitor exec) throws IOException,
    CanceledExecutionException {
        // NOOP
    }

    public class CellFactory implements AppendedCellFactory {
    	
    	private IssueIdWithLinkData readIssueIdWithLinkData(DataRow row) {
    		IssueIdWithLinkData data = new IssueIdWithLinkData();
        	
            DataColumnSpec[] inputSpec = { ITSAdapterTableFactory.ISSUE_ID_COLSPEC, ITSAdapterTableFactory.LINK_COLSPEC };
            
            TableCellReader reader = new TableCellReader(new DataTableSpec(inputSpec), row);
            data.setIssueId(reader.stringOptional(ITSAdapterTableFactory.ISSUE_ID));
            data.setLink(reader.stringOptional(ITSAdapterTableFactory.LINK));
            return data;
    	}

        @Override
        public DataCell[] getAppendedCell(final DataRow row) {
                        
        	ITSDataType data = new ITSInputTransformer()
            		.setInputSpec(ITSAdapterTableFactory.createDataColumnSpec())
            		.transformRow(row);
        	
            List<String> history = (List<String>) new JiraHistoryDownloadHistory().downloadHistory(data);
            
            return new DataCell[] { 
            	Cells.stringListOrMissingCell(history)
            };            
        }
    }
	
}
