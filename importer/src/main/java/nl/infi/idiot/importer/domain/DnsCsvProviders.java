package nl.infi.idiot.importer.domain;


public class DnsCsvProviders {
    public static DnsCsvProviderName getByName(String name) {
        return DnsCsvProviderName.valueOf(name);
    }

    public enum DnsCsvProviderName {
        InternedServices,
    }
}
