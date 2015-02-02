package com.adobe.dam;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.metadata.ExtractedMetadata;
import com.day.cq.dam.commons.handler.AbstractAssetHandler;

@Component
@Service
@Properties({ @Property(name = org.osgi.framework.Constants.SERVICE_RANKING, intValue = 100) })
public class ExtendedAssetHandler extends AbstractAssetHandler {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	public String[] getMimeTypes() {
		return new String[] { "image/jpeg" };
	}

	public ExtractedMetadata extractMetadata(com.day.cq.dam.api.Asset asset) {
		ExtractedMetadata extractedMetadata = new ExtractedMetadata();
		extractedMetadata.setMetaDataProperty("Title", "Text File");
		extractedMetadata.setMetaDataProperty("NewMetadata", "New Metadata");
		setMimetype(extractedMetadata, asset);
		return extractedMetadata;
	}

}
