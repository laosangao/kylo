/**
 * 
 */
package com.thinkbiganalytics.nifi.processors.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.processor.AbstractProcessor;
import org.apache.nifi.processor.ProcessContext;
import org.apache.nifi.processor.ProcessorInitializationContext;
import org.apache.nifi.processor.Relationship;

import com.thinkbiganalytics.controller.MetadataProviderService;

/**
 *
 * @author Sean Felten
 */
public abstract class FeedProcessor extends AbstractProcessor {
    
    public static final String FEED_ID_PROP = "feed.id";
    public static final String DATASET_TYPE_PROP = "dataset.type";
    public static final String SRC_DATASET_ID_PROP = "src.dataset.id";
    public static final String DEST_DATASET_ID_PROP = "dest.dataset.id";
    public static final String OPERATON_ID_PROP = "operation.id";
    
    public static final PropertyDescriptor METADATA_SERVICE = new PropertyDescriptor.Builder()
            .name("Metadata Provider Service")
            .description("Specified Service supplying the implemtentions of the various metadata providers")
            .required(true)
            .identifiesControllerService(MetadataProviderService.class)
            .build();


    protected MetadataProviderService getProviderService(ProcessContext context) {
        return context.getProperty(METADATA_SERVICE).asControllerService(MetadataProviderService.class);
    }

    private Set<Relationship> relationships;
    private List<PropertyDescriptor> properties;

    @Override
    protected void init(final ProcessorInitializationContext context) {
        final Set<Relationship> relationships = new HashSet<>();
        addRelationships(relationships);
        this.relationships = Collections.unmodifiableSet(relationships);

        final List<PropertyDescriptor> properties = new ArrayList<>();
        addProperties(properties);
        this.properties = Collections.unmodifiableList(properties);
    }

    @Override
    public Set<Relationship> getRelationships() {
        return relationships;
    }

    @Override
    protected List<PropertyDescriptor> getSupportedPropertyDescriptors() {
        return properties;
    }

    protected void addProperties(List<PropertyDescriptor> props) {
        props.add(METADATA_SERVICE);
    }
    
    protected void addRelationships(Set<Relationship> relationships2) {
    }
}
