package nl.infi.idiot.api.dns.records;

import nl.infi.idiot.core.DnsProviders.DnsProviderName;
import nl.infi.idiot.rest.DNSRestApi;
import nl.infi.idiot.rest.DNSRestApiFactory;
import nl.infi.idiot.rest.RestApiConfig;
import nl.infi.idiot.rest.RestConfigValidator;
import org.springframework.stereotype.Service;

@Service
public class RecordsServiceSimple implements RecordsService {
    public DNSRestApi getRestApi(DnsProviderName providerName, RestApiConfig config) throws Exception {
        if (isRestApiConfigValid(providerName, config)) {
            throw new Exception(String.format("Config for %s is not valid", providerName));
        }

        return DNSRestApiFactory.create(providerName, config);
    }

    private boolean isRestApiConfigValid(DnsProviderName providerName, RestApiConfig config) {
        switch (providerName) {
            case Cloudflare:
                return RestConfigValidator.cloudflareConfigIsValid(config);
        }
        return false;
    }
}
