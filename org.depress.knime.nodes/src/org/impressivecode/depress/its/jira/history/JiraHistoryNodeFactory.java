package org.impressivecode.depress.its.jira.history;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * 
 * @author Artur Kondziela, Capgemini Polska
 * 
 */
public class JiraHistoryNodeFactory extends NodeFactory<JiraHistoryNodeModel>{

	@Override
	public JiraHistoryNodeModel createNodeModel() {
		return new JiraHistoryNodeModel();
	}

	@Override
	protected int getNrNodeViews() {
		return 0;
	}

	@Override
	public NodeView<JiraHistoryNodeModel> createNodeView(int viewIndex, JiraHistoryNodeModel nodeModel) {
		throw new IllegalStateException("View not supported");
	}

	@Override
	protected boolean hasDialog() {
		return true;
	}

	@Override
	protected NodeDialogPane createNodeDialogPane() {
		return new JiraHistoryNodeDialog();
	}

}
