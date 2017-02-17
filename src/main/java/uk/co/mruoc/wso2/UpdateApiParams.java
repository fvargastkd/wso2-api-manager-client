package uk.co.mruoc.wso2;

import java.util.List;

public interface UpdateApiParams extends ApiVisibilityParams, TransportParams, EndpointSecurityParams {

    String getDescription();

    List<String> getTags();

    List<ApiTierAvailability> getTiers();

    String getEndpointConfig();

    String getSwagger();

}
