package org.dllearner.owltime.vocab;

import org.semanticweb.owlapi.model.HasIRI;
import org.semanticweb.owlapi.model.HasPrefixedName;
import org.semanticweb.owlapi.model.HasShortForm;
import org.semanticweb.owlapi.model.IRI;

public enum OWLTime implements HasShortForm, HasIRI, HasPrefixedName {
    /* Classes */
    /** http://www.w3.org/2006/time#TemporalEntity */             TIME_TEMPORAL_ENTITY(Namespaces.TIME, "TemporalEntity"),
    /** http://www.w3.org/2006/time#Instant */                    TIME_INSTANT(Namespaces.TIME, "Instant"),
    /** http://www.w3.org/2006/time#Interval */                   TIME_INTERVAL(Namespaces.TIME, "Interval"),
    /** http://www.w3.org/2006/time#ProperInterval */             TIME_PROPER_INTERVAL(Namespaces.TIME, "ProperInterval"),
    /** http://www.w3.org/2006/time#DateTimeInterval */           TIME_DATE_TIME_INTERVAL(Namespaces.TIME, "DateTimeInterval"),
    /** http://www.w3.org/2006/time#TemporalPosition */           TIME_TEMPORAL_POSITION(Namespaces.TIME, "TemporalPosition"),
    /** http://www.w3.org/2006/time#TimePosition */               TIME_TIME_POSITION(Namespaces.TIME, "TimePosition"),
    /** http://www.w3.org/2006/time#GeneralDateTimeDescription */ TIME_GENERAL_DATE_TIME_DESCRIPTION(Namespaces.TIME, "GeneralDateTimeDescription"),
    /** http://www.w3.org/2006/time#DateTimeDescription */        TIME_DATE_TIME_DESCRIPTION(Namespaces.TIME, "DateTimeDescription"),
    /** http://www.w3.org/2006/time#MonthOfYear */                TIME_MONTH_OF_YEAR(Namespaces.TIME, "MonthOfYear"),
    /** http://www.w3.org/2006/time#TemporalDuration */           TIME_TEMPORAL_DURATION(Namespaces.TIME, "TemporalDuration"),
    /** http://www.w3.org/2006/time#Duration */                   TIME_DURATION(Namespaces.TIME, "Duration"),
    /** http://www.w3.org/2006/time#GeneralDurationDescription */ TIME_GENERAL_DURATION_DESCRIPTION(Namespaces.TIME, "GeneralDurationDescription"),
    /** http://www.w3.org/2006/time#DurationDescription */        TIME_DURATION_DESCRIPTION(Namespaces.TIME, "DurationDescription"),
    /** http://www.w3.org/2006/time#TemporalUnit */               TIME_TEMPORAL_UNIT(Namespaces.TIME, "TemporalUnit"),
    /** http://www.w3.org/2006/time#TRS */                        TIME_TRS(Namespaces.TIME, "TRS"),
    /** http://www.w3.org/2006/time#TimeZone */                   TIME_TIME_ZONE(Namespaces.TIME, "TimeZone"),
    /** http://www.w3.org/2006/time#DayOfWeek */                  TIME_DAY_OF_WEEK(Namespaces.TIME, "DayOfWeek"),
    
    /* Properties */
    /** http://www.w3.org/2006/time#hasTime */                    TIME_HAS_TIME(Namespaces.TIME, "hasTime"),
    /** http://www.w3.org/2006/time#hasBeginning */               TIME_HAS_BEGINNING(Namespaces.TIME, "hasBeginning"),
    /** http://www.w3.org/2006/time#hasEnd */                     TIME_HAS_END(Namespaces.TIME, "hasEnd"),
    /** http://www.w3.org/2006/time#hasTemporalDuration */        TIME_HAS_TEMPORAL_DURATION(Namespaces.TIME, "hasTemporalDuration"),
    /** http://www.w3.org/2006/time#hasDuration */                TIME_HAS_DURATION(Namespaces.TIME, "hasDuration"),
    /** http://www.w3.org/2006/time#hasDurationDescription */     TIME_HAS_DURATION_DESCRIPTION(Namespaces.TIME, "hasDurationDescription"),
    /** http://www.w3.org/2006/time#hasXSDDuration */             TIME_HAS_XSD_DURATION(Namespaces.TIME, "hasXSDDuration"),
    /** http://www.w3.org/2006/time#before */                     TIME_BEFORE(Namespaces.TIME, "before"),
    /** http://www.w3.org/2006/time#after */                      TIME_AFTER(Namespaces.TIME, "after"),
    /** http://www.w3.org/2006/time#inside */                     TIME_INSIDE(Namespaces.TIME, "inside"),
    /** http://www.w3.org/2006/time#intervalEquals */             TIME_INTERVAL_EQUALS(Namespaces.TIME, "intervalEquals"),
    /** http://www.w3.org/2006/time#intervalDisjoint */           TIME_INTERVAL_DISJOINT(Namespaces.TIME, "intervalDisjoint"),
    /** http://www.w3.org/2006/time#intervalAfter */              TIME_INTERVAL_AFTER(Namespaces.TIME, "intervalAfter"),
    /** http://www.w3.org/2006/time#intervalBefore */             TIME_INTERVAL_BEFORE(Namespaces.TIME, "intervalBefore"),
    /** http://www.w3.org/2006/time#intervalMeets */              TIME_INTERVAL_MEETS(Namespaces.TIME, "intervalMeets"),
    /** http://www.w3.org/2006/time#intervalMetBy */              TIME_INTERVAL_MET_BY(Namespaces.TIME, "intervalMetBy"),
    /** http://www.w3.org/2006/time#intervalOverlaps */           TIME_INTERVAL_OVERLAPS(Namespaces.TIME, "intervalOverlaps"),
    /** http://www.w3.org/2006/time#intervalOverlappedBy */       TIME_INTERVAL_OVERLAPPED_BY(Namespaces.TIME, "intervalOverlappedBy"),
    /** http://www.w3.org/2006/time#intervalStarts */             TIME_INTERVAL_STARTS(Namespaces.TIME, "intervalStarts"),
    /** http://www.w3.org/2006/time#intervalStartedBy */          TIME_INTERVAL_STARTEDBY(Namespaces.TIME, "intervalStartedBy"),
    /** http://www.w3.org/2006/time#intervalFinishes */           TIME_INTERVAL_FINISHES(Namespaces.TIME, "intervalFinishes"),
    /** http://www.w3.org/2006/time#intervalFinishedBy */         TIME_INTERVAL_FINISHED_BY(Namespaces.TIME, "intervalFinishedBy"),
    /** http://www.w3.org/2006/time#intervalContains */           TIME_INTERVAL_CONTAINS(Namespaces.TIME, "intervalContains"),
    /** http://www.w3.org/2006/time#intervalDuring */             TIME_INTERVAL_DURING(Namespaces.TIME, "intervalDuring"),
    /** http://www.w3.org/2006/time#intervalIn */                 TIME_INTERVAL_IN(Namespaces.TIME, "intervalIn"),
    /** http://www.w3.org/2006/time#hasDateTimeDescription */     TIME_HAS_DATE_TIME_DESCRIPTION(Namespaces.TIME, "hasDateTimeDescription"),
    /** http://www.w3.org/2006/time#xsdDateTime (deprecated) */   TIME_XSD_DATE_TIME(Namespaces.TIME, "xsdDateTime"),
    /** http://www.w3.org/2006/time#inTemporalPosition */         TIME_IN_TEMPORAL_POSITION(Namespaces.TIME, "inTemporalPosition"),
    /** http://www.w3.org/2006/time#inTimePosition */             TIME_IN_TIME_POSITION(Namespaces.TIME, "inTimePosition"),
    /** http://www.w3.org/2006/time#inDateTime */                 TIME_IN_DATE_TIME(Namespaces.TIME, "inDateTime"),
    /** http://www.w3.org/2006/time#inXSDDate */                  TIME_IN_XSD_DATE(Namespaces.TIME, "inXSDDate"),
    /** http://www.w3.org/2006/time#inXSDDateTime (deprecated) */ TIME_IN_XSD_DATE_TIME(Namespaces.TIME, "inXSDDateTime"),
    /** http://www.w3.org/2006/time#inXSDDateTimeStamp */         TIME_IN_XSD_DATE_TIME_STAMP(Namespaces.TIME, "inXSDDateTimeStamp"),
    /** http://www.w3.org/2006/time#inXSDgYearMonth */            TIME_IN_XSD_G_YEAR_MONTH(Namespaces.TIME, "inXSDgYearMonth"),
    /** http://www.w3.org/2006/time#inXSDgYear */                 TIME_IN_XSD_G_YEAR(Namespaces.TIME, "inXSDgYear"),
    /** http://www.w3.org/2006/time#numericDuration */            TIME_NUMERIC_DURATION(Namespaces.TIME, "numericDuration"),
    /** http://www.w3.org/2006/time#unitType */                   TIME_UNIT_TYPE(Namespaces.TIME, "unitType"),
    /** http://www.w3.org/2006/time#years */                      TIME_YEARS(Namespaces.TIME, "years"),
    /** http://www.w3.org/2006/time#months */                     TIME_MONTHS(Namespaces.TIME, "months"),
    /** http://www.w3.org/2006/time#weeks */                      TIME_WEEKS(Namespaces.TIME, "weeks"),
    /** http://www.w3.org/2006/time#days */                       TIME_DAYS(Namespaces.TIME, "days"),
    /** http://www.w3.org/2006/time#hours */                      TIME_HOURS(Namespaces.TIME, "hours"),
    /** http://www.w3.org/2006/time#minutes */                    TIME_MINUTES(Namespaces.TIME, "minutes"),
    /** http://www.w3.org/2006/time#seconds */                    TIME_SECONDS(Namespaces.TIME, "seconds"),
    /** http://www.w3.org/2006/time#numericPosition */            TIME_NUMERIC_POSITION(Namespaces.TIME, "numericPosition"),
    /** http://www.w3.org/2006/time#nominalPosition */            TIME_NOMINAL_POSITION(Namespaces.TIME, "nominalPosition"),
    /** http://www.w3.org/2006/time#timeZone */                   TIME_TIME_ZONE_PREDICATE(Namespaces.TIME, "timeZone"),
    /** http://www.w3.org/2006/time#year */                       TIME_YEAR(Namespaces.TIME, "year"),
    /** http://www.w3.org/2006/time#month */                      TIME_MONTH(Namespaces.TIME, "month"),
    /** http://www.w3.org/2006/time#day */                        TIME_DAY(Namespaces.TIME, "day"),
    /** http://www.w3.org/2006/time#hour */                       TIME_HOUR(Namespaces.TIME, "hour"),
    /** http://www.w3.org/2006/time#minute */                     TIME_MINUTE(Namespaces.TIME, "minute"),
    /** http://www.w3.org/2006/time#second */                     TIME_SECOND(Namespaces.TIME, "second"),
    /** http://www.w3.org/2006/time#week */                       TIME_WEEK(Namespaces.TIME, "week"),
    /** http://www.w3.org/2006/time#dayOfYear */                  TIME_DAY_OF_YEAR(Namespaces.TIME, "dayOfYear"),
    /** http://www.w3.org/2006/time#dayOfWeek */                  TIME_DAY_OF_WEEK_PREDICATE(Namespaces.TIME, "dayOfWeek"),
    /** http://www.w3.org/2006/time#monthOfYear */                TIME_MONTH_OF_YEAR_PREDICATE(Namespaces.TIME, "monthOfYear"),
    /** http://www.w3.org/2006/time#hasTRS */                     TIME_HAS_TRS(Namespaces.TIME, "hasTRS"),

    /* Datatypes */
    /** http://www.w3.org/2006/time#generalDay */   TIME_GENERAL_DAY(Namespaces.TIME, "generalDay"),
    /** http://www.w3.org/2006/time#generalMonth */ TIME_GENERAL_MONTH(Namespaces.TIME, "generalMonth"),
    /** http://www.w3.org/2006/time#generalYear */  TIME_GENERAL_YEAR(Namespaces.TIME, "generalYear"),
    
    /*Individuals */
    /** http://www.w3.org/2006/time#Friday */     TIME_FRIDAY(Namespaces.TIME, "Friday"),
    /** http://www.w3.org/2006/time#Monday */     TIME_MONDAY(Namespaces.TIME, "Monday"),
    /** http://www.w3.org/2006/time#Saturday */   TIME_SATURDAY(Namespaces.TIME, "Saturday"),
    /** http://www.w3.org/2006/time#Sunday */     TIME_SUNDAY(Namespaces.TIME, "Sunday"),
    /** http://www.w3.org/2006/time#Thursday */   TIME_THURSDAY(Namespaces.TIME, "Thursday"),
    /** http://www.w3.org/2006/time#Tuesday */    TIME_TUESDAY(Namespaces.TIME, "Tuesday"),
    /** http://www.w3.org/2006/time#Wednesday */  TIME_WEDNESDAY(Namespaces.TIME, "Wednesday"),
    /** http://www.w3.org/2006/time#unitDay */    TIME_UNIT_DAY(Namespaces.TIME, "unitDay"),
    /** http://www.w3.org/2006/time#unitHour */   TIME_UNIT_HOUR(Namespaces.TIME, "unitHour"),
    /** http://www.w3.org/2006/time#unitMinute */ TIME_UNIT_MINUTE(Namespaces.TIME, "unitMinute"),
    /** http://www.w3.org/2006/time#unitMonth */  TIME_UNIT_MONTH(Namespaces.TIME, "unitMonth"),
    /** http://www.w3.org/2006/time#unitSecond */ TIME_UNIT_SECOND(Namespaces.TIME, "unitSecond"),
    /** http://www.w3.org/2006/time#unitWeek */   TIME_UNIT_WEEK(Namespaces.TIME, "unitWeek"),
    /** http://www.w3.org/2006/time#unitYear */   TIME_UNIT_YEAR(Namespaces.TIME, "unitYear");

    private final IRI iri;
    private final Namespaces namespace;
    private final String shortName;
    private final String prefixedName;
    
    OWLTime(Namespaces namespace, String shortName) {
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
