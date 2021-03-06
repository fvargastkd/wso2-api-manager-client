package uk.co.mruoc.wso2.publisher.addapi;

import org.junit.Test;
import uk.co.mruoc.wso2.publisher.addapi.AddApiParams;
import uk.co.mruoc.wso2.publisher.addapi.AddApiParamsToQueryStringConverter;
import uk.co.mruoc.wso2.publisher.addapi.AddApiUrlBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AddApiUrlBuilderTest {

    private static final String HOST_URL = "https://localhost:8443";
    private static final String RESOURCE = "/publisher/site/blocks/item-add/ajax/add.jag";
    private static final String QUERY_STRING = "?queryString=value";

    private final AddApiParamsToQueryStringConverter queryStringConverter = mock(AddApiParamsToQueryStringConverter.class);
    private final AddApiUrlBuilder builder = new AddApiUrlBuilder(HOST_URL, queryStringConverter);

    @Test
    public void shouldBuildUrl() {
        AddApiParams params = mock(AddApiParams.class);
        given(queryStringConverter.convert(params)).willReturn(QUERY_STRING);

        String url = builder.build(params);

        assertThat(url).isEqualTo(HOST_URL + RESOURCE + QUERY_STRING);
    }

}
