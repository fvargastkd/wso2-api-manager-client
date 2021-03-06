package uk.co.mruoc.wso2.publisher.updateapi;

import org.junit.Test;
import uk.co.mruoc.wso2.publisher.updateapi.UpdateApiParams;
import uk.co.mruoc.wso2.publisher.updateapi.UpdateApiParamsToQueryStringConverter;
import uk.co.mruoc.wso2.publisher.updateapi.UpdateApiUrlBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class UpdateApiUrlBuilderTest {

    private static final String HOST_URL = "https://localhost:8443";
    private static final String RESOURCE = "/publisher/site/blocks/item-add/ajax/add.jag";
    private static final String QUERY_STRING = "?queryString=value";

    private final UpdateApiParamsToQueryStringConverter queryStringConverter = mock(UpdateApiParamsToQueryStringConverter.class);
    private final UpdateApiUrlBuilder builder = new UpdateApiUrlBuilder(HOST_URL, queryStringConverter);

    @Test
    public void shouldBuildUrl() {
        UpdateApiParams params = mock(UpdateApiParams.class);
        given(queryStringConverter.convert(params)).willReturn(QUERY_STRING);

        String url = builder.build(params);

        assertThat(url).isEqualTo(HOST_URL + RESOURCE + QUERY_STRING);
    }

}
