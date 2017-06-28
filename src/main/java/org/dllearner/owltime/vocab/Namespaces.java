package org.dllearner.owltime.vocab;

public enum Namespaces {
    TIME("time", "http://www.w3.org/2006/time#"),
    GREG("greg", "http://www.w3.org/ns/time/gregorian#");
    
    private final String prefix;
    private final String ns;
    
    Namespaces(String prefix, String ns) {
        this.prefix = prefix;
        this.ns = ns;
    }
    
    public String getPrefixName() {
        return prefix;
    }
    
    public String getPrefixIRI() {
        return ns;
    }
}
