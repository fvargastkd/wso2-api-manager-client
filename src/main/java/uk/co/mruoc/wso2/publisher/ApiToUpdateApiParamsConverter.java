package uk.co.mruoc.wso2.publisher;

import uk.co.mruoc.wso2.publisher.getapi.Api;
import uk.co.mruoc.wso2.publisher.updateapi.DefaultUpdateApiParams;

public class ApiToUpdateApiParamsConverter {

    public DefaultUpdateApiParams convert(Api api) {
        DefaultUpdateApiParams params = new DefaultUpdateApiParams();
        params.setApiName(api.getName());
        params.setApiVersion(api.getVersion());
        params.setContext(api.getContext());
        params.setProvider(api.getProvider());
        params.setRoles(api.getRoles());
        params.setTags(api.getTags());
        params.setTiers(api.getTiers());
        params.setHttpChecked(api.isHttpChecked());
        params.setHttpsChecked(api.isHttpsChecked());
        params.setEndpointType(api.getEndpointType());
        params.setEndpointUsername(api.getEndpointUsername());
        params.setEndpointPassword(api.getEndpointPassword());
        params.setVisibility(api.getVisibility());
        params.setEndpointConfig(api.getEndpointConfig());
        params.setThumbnailImagePath(api.getThumbnailImageUrl());
        return params;
    }

}
