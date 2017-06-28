package org.dllearner.owltime.vocab;

import org.semanticweb.owlapi.model.HasIRI;
import org.semanticweb.owlapi.model.HasPrefixedName;
import org.semanticweb.owlapi.model.HasShortForm;
import org.semanticweb.owlapi.model.IRI;

public enum Gregorian implements HasShortForm, HasIRI, HasPrefixedName {
    /* Individuals */
    /** http://www.w3.org/ns/time/gregorian/January */   GREG_JANUARY(Namespaces.GREG, "January"),
    /** http://www.w3.org/ns/time/gregorian/February */  GREG_FEBRUARY(Namespaces.GREG, "February"),
    /** http://www.w3.org/ns/time/gregorian/March */     GREG_MARCH(Namespaces.GREG, "March"),
    /** http://www.w3.org/ns/time/gregorian/April */     GREG_APRIL(Namespaces.GREG, "April"),
    /** http://www.w3.org/ns/time/gregorian/May */       GREG_MAY(Namespaces.GREG, "May"),
    /** http://www.w3.org/ns/time/gregorian/June */      GREG_JUNE(Namespaces.GREG, "June"),
    /** http://www.w3.org/ns/time/gregorian/July */      GREG_JULY(Namespaces.GREG, "July"),
    /** http://www.w3.org/ns/time/gregorian/August */    GREG_AUGUST(Namespaces.GREG, "August"),
    /** http://www.w3.org/ns/time/gregorian/September */ GREG_SEPTEMBER(Namespaces.GREG, "September"),
    /** http://www.w3.org/ns/time/gregorian/October */   GREG_October(Namespaces.GREG, "October"),
    /** http://www.w3.org/ns/time/gregorian/November */  GREG_NOVEMBER(Namespaces.GREG, "November"),
    /** http://www.w3.org/ns/time/gregorian/December */  GREG_DECEMBER(Namespaces.GREG, "December");
    
    private final IRI iri;
    private final Namespaces namespace;
    private final String shortName;
    private final String prefixedName;
    
    Gregorian(Namespaces namespace, String shortName) {
        this.namespace = namespace;
        this.shortName = shortName;
        prefixedName = namespace.getPrefixName() + ":" + shortName;
        iri = IRI.create(namespace.toString(), shortName);
    }
    
    public IRI getIRI() {
        return iri;
    }

    public String getPrefixedName() {
        return prefixedName;
    }
    
    public String getShortForm() {
        return shortName;
    }
    
    public String toString() {
        return iri.toString();
    }
}
