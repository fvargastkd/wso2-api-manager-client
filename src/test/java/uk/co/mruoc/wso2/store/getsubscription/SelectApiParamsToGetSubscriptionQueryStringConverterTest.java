package uk.co.mruoc.wso2.store.getsubscription;

import org.junit.Test;
import uk.co.mruoc.wso2.SelectApiParams;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SelectApiParamsToGetSubscriptionQueryStringConverterTest {

    private static final String PREFIX = "?action=getSubscriptionByAPI";
    private static final String NAME = "api-name";
    private static final String VERSION = "v1";
    private static final String PROVIDER = "admin";

    private final SelectApiParams params = mock(SelectApiParams.class);

    private final SelectApiParamsToGetSubscriptionQueryStringConverter converter = new SelectApiParamsToGetSubscriptionQueryStringConverter();

    @Test
    public void shouldStartWithPrefix() {
        String result = converter.convert(params);

        assertThat(result).startsWith(PREFIX);
    }

    @Test
    public void shouldConvertName() {
        given(params.getApiName()).willReturn(NAME);

        String result = converter.convert(params);

        assertThat(result).contains("&apiName=" + NAME);
    }

    @Test
    public void shouldConvertVersion() {
        given(params.getApiVersion()).willReturn(VERSION);

        String result = converter.convert(params);

        assertThat(result).contains("&apiVersion=" + VERSION);
    }

    @Test
    public void shouldConvertProvider() {
        given(params.getProvider()).willReturn(PROVIDER);

        String result = converter.convert(params);

        assertThat(result).contains("&provider=" + PROVIDER);
    }

}
