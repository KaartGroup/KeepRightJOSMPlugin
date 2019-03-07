/**
 *
 */
package com.kaartgroup.openqa;

import org.openstreetmap.josm.data.osm.event.AbstractDatasetChangedEvent;
import org.openstreetmap.josm.data.osm.event.DataChangedEvent;
import org.openstreetmap.josm.data.osm.event.DataSetListener;
import org.openstreetmap.josm.data.osm.event.NodeMovedEvent;
import org.openstreetmap.josm.data.osm.event.PrimitivesAddedEvent;
import org.openstreetmap.josm.data.osm.event.PrimitivesRemovedEvent;
import org.openstreetmap.josm.data.osm.event.RelationMembersChangedEvent;
import org.openstreetmap.josm.data.osm.event.TagsChangedEvent;
import org.openstreetmap.josm.data.osm.event.WayNodesChangedEvent;

/**
 * @author Taylor Smock
 *
 */
public class OpenQADataSetListener implements DataSetListener {

	private String CACHE_DIR;

	public OpenQADataSetListener(String CACHE_DIR) {
		this.CACHE_DIR = CACHE_DIR;
	}
	/* (non-Javadoc)
	 * @see org.openstreetmap.josm.data.osm.event.DataSetListener#dataChanged(org.openstreetmap.josm.data.osm.event.DataChangedEvent)
	 */
	@Override
	public void dataChanged(DataChangedEvent arg0) {
		OpenQALayerChangeListener.updateOpenQALayers(CACHE_DIR);
	}

	@Override
	public void otherDatasetChange(AbstractDatasetChangedEvent arg0) {
		// Don't care
	}

	@Override
	public void nodeMoved(NodeMovedEvent arg0) {
		// Don't care
	}

	@Override
	public void primitivesAdded(PrimitivesAddedEvent arg0) {
		// Don't care

	}

	@Override
	public void primitivesRemoved(PrimitivesRemovedEvent arg0) {
		// Don't care

	}

	@Override
	public void relationMembersChanged(RelationMembersChangedEvent arg0) {
		// Don't care

	}

	@Override
	public void tagsChanged(TagsChangedEvent arg0) {
		// Don't care

	}

	@Override
	public void wayNodesChanged(WayNodesChangedEvent arg0) {
		// Don't care

	}

}