package org.dllearner.owltime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

import org.dllearner.owltime.vocab.Gregorian;
import org.dllearner.owltime.vocab.OWLTime;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.TurtleDocumentFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.owlapi.vocab.OWLFacet;
import org.semanticweb.owlapi.vocab.XSDVocabulary;

import com.google.common.collect.Sets;

import uk.ac.manchester.cs.owl.owlapi.OWLDatatypeImpl;

public class OWLTimeOntology {
    private static OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
    private static OWLDataFactory df = manager.getOWLDataFactory();

    // classes
    public static final OWLClass generalDateTimeDescription = df.getOWLClass(
            OWLTime.TIME_GENERAL_DATE_TIME_DESCRIPTION.getIRI());
    public static final OWLClass dateTimeDescription = df.getOWLClass(OWLTime.TIME_DATE_TIME_DESCRIPTION.getIRI());
    public static final OWLClass dateTimeInterval = df.getOWLClass(OWLTime.TIME_DATE_TIME_INTERVAL.getIRI());
    public static final OWLClass properInterval = df.getOWLClass(OWLTime.TIME_PROPER_INTERVAL.getIRI());
    public static final OWLClass dayOfWeek = df.getOWLClass(OWLTime.TIME_DAY_OF_WEEK.getIRI());
    public static final OWLClass duration = df.getOWLClass(OWLTime.TIME_DURATION.getIRI());
    public static final OWLClass temporalDuration = df.getOWLClass(OWLTime.TIME_TEMPORAL_DURATION.getIRI());
    public static final OWLClass durationDescription = df.getOWLClass(OWLTime.TIME_DURATION_DESCRIPTION.getIRI());
    public static final OWLClass generalDurationDescription = df.getOWLClass(
            OWLTime.TIME_GENERAL_DURATION_DESCRIPTION.getIRI());
    public static final OWLClass temporalPosition = df.getOWLClass(OWLTime.TIME_TEMPORAL_POSITION.getIRI());
    public static final OWLClass instant = df.getOWLClass(OWLTime.TIME_INSTANT.getIRI());
    public static final OWLClass temporalEntity = df.getOWLClass(OWLTime.TIME_TEMPORAL_ENTITY.getIRI());
    public static final OWLClass interval = df.getOWLClass(OWLTime.TIME_INTERVAL.getIRI());
    public static final OWLClass monthOfYear = df.getOWLClass(OWLTime.TIME_MONTH_OF_YEAR.getIRI());
    public static final OWLClass temporalUnit = df.getOWLClass(OWLTime.TIME_TEMPORAL_UNIT.getIRI());
    public static final OWLClass timePosition = df.getOWLClass(OWLTime.TIME_TIME_POSITION.getIRI());
    public static final OWLClass timeZone = df.getOWLClass(OWLTime.TIME_TIME_ZONE.getIRI());
    public static final OWLClass trs = df.getOWLClass(OWLTime.TIME_TRS.getIRI());

    // object properties
    public static final OWLObjectProperty hasTRS = df.getOWLObjectProperty(OWLTime.TIME_HAS_TRS.getIRI());
    public static final OWLObjectProperty unitType = df.getOWLObjectProperty(OWLTime.TIME_UNIT_TYPE.getIRI());
    public static final OWLObjectProperty timeZonePredicate = df.getOWLObjectProperty(
            OWLTime.TIME_TIME_ZONE_PREDICATE.getIRI());
    public static final OWLObjectProperty after = df.getOWLObjectProperty(OWLTime.TIME_AFTER.getIRI());
    public static final OWLObjectProperty before = df.getOWLObjectProperty(OWLTime.TIME_BEFORE.getIRI());
    public static final OWLObjectProperty dayOfWeekPredicate = df.getOWLObjectProperty(
            OWLTime.TIME_DAY_OF_WEEK_PREDICATE.getIRI());
    public static final OWLObjectProperty hasBeginning = df.getOWLObjectProperty(OWLTime.TIME_HAS_BEGINNING.getIRI());
    public static final OWLObjectProperty hasDateTimeDescription = df.getOWLObjectProperty(
            OWLTime.TIME_HAS_DATE_TIME_DESCRIPTION.getIRI());
    public static final OWLObjectProperty hasDuration = df.getOWLObjectProperty(OWLTime.TIME_HAS_DURATION.getIRI());
    public static final OWLObjectProperty hasTemporalDuration = df.getOWLObjectProperty(
            OWLTime.TIME_HAS_TEMPORAL_DURATION.getIRI());
    public static final OWLObjectProperty hasDurationDescription = df.getOWLObjectProperty(
            OWLTime.TIME_HAS_DURATION_DESCRIPTION.getIRI());
    public static final OWLObjectProperty hasEnd = df.getOWLObjectProperty(OWLTime.TIME_HAS_END.getIRI());
    public static final OWLObjectProperty hasTime = df.getOWLObjectProperty(OWLTime.TIME_HAS_TIME.getIRI());
    public static final OWLObjectProperty inDateTime = df.getOWLObjectProperty(OWLTime.TIME_IN_DATE_TIME.getIRI());
    public static final OWLObjectProperty inTemporalPosition = df.getOWLObjectProperty(
            OWLTime.TIME_IN_TEMPORAL_POSITION.getIRI());
    public static final OWLObjectProperty inside = df.getOWLObjectProperty(OWLTime.TIME_INSIDE.getIRI());
    public static final OWLObjectProperty intervalAfter = df.getOWLObjectProperty(OWLTime.TIME_INTERVAL_AFTER.getIRI());
    public static final OWLObjectProperty intervalDisjoint = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_DISJOINT.getIRI());
    public static final OWLObjectProperty intervalBefore = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_BEFORE.getIRI());
    public static final OWLObjectProperty intervalContains = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_CONTAINS.getIRI());
    public static final OWLObjectProperty intervalDuring = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_DURING.getIRI());
    public static final OWLObjectProperty intervalEquals = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_EQUALS.getIRI());
    public static final OWLObjectProperty intervalIn = df.getOWLObjectProperty(OWLTime.TIME_INTERVAL_IN.getIRI());
    public static final OWLObjectProperty intervalFinishedBy = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_FINISHED_BY.getIRI());
    public static final OWLObjectProperty intervalFinishes = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_FINISHES.getIRI());
    public static final OWLObjectProperty intervalMeets = df.getOWLObjectProperty(OWLTime.TIME_INTERVAL_MEETS.getIRI());
    public static final OWLObjectProperty intervalMetBy = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_MET_BY.getIRI());
    public static final OWLObjectProperty intervalOverlappedBy = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_OVERLAPPED_BY.getIRI());
    public static final OWLObjectProperty intervalOverlaps = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_OVERLAPS.getIRI());
    public static final OWLObjectProperty intervalStartedBy = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_STARTEDBY.getIRI());
    public static final OWLObjectProperty intervalStarts = df.getOWLObjectProperty(
            OWLTime.TIME_INTERVAL_STARTS.getIRI());
    public static final OWLObjectProperty inTimePosition = df.getOWLObjectProperty(
            OWLTime.TIME_IN_TIME_POSITION.getIRI());
    public static final OWLObjectProperty monthOfYearPredicate = df.getOWLObjectProperty(
            OWLTime.TIME_MONTH_OF_YEAR_PREDICATE.getIRI());

    // data properties
    public static final OWLDataProperty year = df.getOWLDataProperty(OWLTime.TIME_YEAR.getIRI());
    public static final OWLDataProperty month = df.getOWLDataProperty(OWLTime.TIME_MONTH.getIRI());
    public static final OWLDataProperty day = df.getOWLDataProperty(OWLTime.TIME_DAY.getIRI());
    public static final OWLDataProperty numericDuration = df.getOWLDataProperty(OWLTime.TIME_NUMERIC_DURATION.getIRI());
    public static final OWLDataProperty years = df.getOWLDataProperty(OWLTime.TIME_YEARS.getIRI());
    public static final OWLDataProperty months = df.getOWLDataProperty(OWLTime.TIME_MONTHS.getIRI());
    public static final OWLDataProperty weeks = df.getOWLDataProperty(OWLTime.TIME_WEEKS.getIRI());
    public static final OWLDataProperty days = df.getOWLDataProperty(OWLTime.TIME_DAYS.getIRI());
    public static final OWLDataProperty hours = df.getOWLDataProperty(OWLTime.TIME_HOURS.getIRI());
    public static final OWLDataProperty minutes = df.getOWLDataProperty(OWLTime.TIME_MINUTES.getIRI());
    public static final OWLDataProperty seconds = df.getOWLDataProperty(OWLTime.TIME_SECONDS.getIRI());
    public static final OWLDataProperty hour = df.getOWLDataProperty(OWLTime.TIME_HOUR.getIRI());
    public static final OWLDataProperty minute = df.getOWLDataProperty(OWLTime.TIME_MINUTE.getIRI());
    public static final OWLDataProperty second = df.getOWLDataProperty(OWLTime.TIME_SECOND.getIRI());
    public static final OWLDataProperty week = df.getOWLDataProperty(OWLTime.TIME_WEEK.getIRI());
    public static final OWLDataProperty dayOfYear = df.getOWLDataProperty(OWLTime.TIME_DAY_OF_YEAR.getIRI());
    public static final OWLDataProperty numericPosition = df.getOWLDataProperty(OWLTime.TIME_NUMERIC_POSITION.getIRI());
    public static final OWLDataProperty nominalPosition = df.getOWLDataProperty(OWLTime.TIME_NOMINAL_POSITION.getIRI());
    public static final OWLDataProperty hasXSDDuration = df.getOWLDataProperty(OWLTime.TIME_HAS_XSD_DURATION.getIRI());
    public static final OWLDataProperty inXSDDate = df.getOWLDataProperty(OWLTime.TIME_IN_XSD_DATE.getIRI());
    @Deprecated
    public static final OWLDataProperty inXSDDateTime = df.getOWLDataProperty(OWLTime.TIME_IN_XSD_DATE_TIME.getIRI());
    public static final OWLDataProperty inXSDDateTimeStamp = df.getOWLDataProperty(
            OWLTime.TIME_IN_XSD_DATE_TIME_STAMP.getIRI());
    public static final OWLDataProperty inXSDgYear = df.getOWLDataProperty(OWLTime.TIME_IN_XSD_G_YEAR.getIRI());
    public static final OWLDataProperty inXSDgYearMonth = df.getOWLDataProperty(
            OWLTime.TIME_IN_XSD_G_YEAR_MONTH.getIRI());
    @Deprecated
    public static final OWLDataProperty xsdDateTime = df.getOWLDataProperty(OWLTime.TIME_XSD_DATE_TIME.getIRI());

    // datatypes
    public static final OWLDatatype generalDay = df.getOWLDatatype(OWLTime.TIME_GENERAL_DAY.getIRI());
    public static final OWLDatatype generalMonth = df.getOWLDatatype(OWLTime.TIME_GENERAL_MONTH.getIRI());
    public static final OWLDatatype generalYear = df.getOWLDatatype(OWLTime.TIME_GENERAL_YEAR.getIRI());

    // individuals
    private static final OWLIndividual gregorianCalendar = df.getOWLNamedIndividual(
            IRI.create("http://www.opengis.net/def/uom/ISO-8601/0/Gregorian"));
    public static final OWLIndividual unitMonth = df.getOWLNamedIndividual(OWLTime.TIME_UNIT_MONTH.getIRI());
    public static final OWLIndividual friday = df.getOWLNamedIndividual(OWLTime.TIME_FRIDAY.getIRI());
    public static final OWLIndividual monday = df.getOWLNamedIndividual(OWLTime.TIME_MONDAY.getIRI());
    public static final OWLIndividual saturday = df.getOWLNamedIndividual(OWLTime.TIME_SATURDAY.getIRI());
    public static final OWLIndividual sunday = df.getOWLNamedIndividual(OWLTime.TIME_SUNDAY.getIRI());
    public static final OWLIndividual thursday = df.getOWLNamedIndividual(OWLTime.TIME_THURSDAY.getIRI());
    public static final OWLIndividual tuesday = df.getOWLNamedIndividual(OWLTime.TIME_TUESDAY.getIRI());
    public static final OWLIndividual wednesday = df.getOWLNamedIndividual(OWLTime.TIME_WEDNESDAY.getIRI());
    public static final OWLIndividual april = df.getOWLNamedIndividual(Gregorian.GREG_APRIL.getIRI());
    public static final OWLIndividual august = df.getOWLNamedIndividual(Gregorian.GREG_AUGUST.getIRI());
    public static final OWLIndividual december = df.getOWLNamedIndividual(Gregorian.GREG_DECEMBER.getIRI());
    public static final OWLIndividual february = df.getOWLNamedIndividual(Gregorian.GREG_FEBRUARY.getIRI());
    public static final OWLIndividual january = df.getOWLNamedIndividual(Gregorian.GREG_JANUARY.getIRI());
    public static final OWLIndividual july = df.getOWLNamedIndividual(Gregorian.GREG_JULY.getIRI());
    public static final OWLIndividual june = df.getOWLNamedIndividual(Gregorian.GREG_JUNE.getIRI());
    public static final OWLIndividual march = df.getOWLNamedIndividual(Gregorian.GREG_MARCH.getIRI());
    public static final OWLIndividual may = df.getOWLNamedIndividual(Gregorian.GREG_MAY.getIRI());
    public static final OWLIndividual november = df.getOWLNamedIndividual(Gregorian.GREG_NOVEMBER.getIRI());
    public static final OWLIndividual october = df.getOWLNamedIndividual(Gregorian.GREG_October.getIRI());
    public static final OWLIndividual september = df.getOWLNamedIndividual(Gregorian.GREG_SEPTEMBER.getIRI());
    public static final OWLIndividual unitDay = df.getOWLNamedIndividual(OWLTime.TIME_UNIT_DAY.getIRI());
    public static final OWLIndividual unitHour = df.getOWLNamedIndividual(OWLTime.TIME_UNIT_HOUR.getIRI());
    public static final OWLIndividual unitMinute = df.getOWLNamedIndividual(OWLTime.TIME_UNIT_MINUTE.getIRI());
    public static final OWLIndividual unitSecond = df.getOWLNamedIndividual(OWLTime.TIME_UNIT_SECOND.getIRI());
    public static final OWLIndividual unitWeek = df.getOWLNamedIndividual(OWLTime.TIME_UNIT_WEEK.getIRI());
    public static final OWLIndividual unitYear = df.getOWLNamedIndividual(OWLTime.TIME_UNIT_YEAR.getIRI());

    /**
     * https://www.w3.org/TR/owl-time/#time:DateTimeDescription
     *
     * 4.1.1 Date-time description
     *
     * Class:       time:DateTimeDescription
     * Definition:  Description of date and time structured with separate values for the various elements of a
     *              calendar-clock system. The temporal reference system is fixed to Gregorian Calendar, and the range
     *              of year, month, day properties restricted to corresponding XML Schema types xsd:gYear, xsd:gMonth
     *              and xsd:gDay, respectively.
     * Subclass of: time:GeneralDateTimeDescription
     * Subclass of: time:hasTRS value <http://www.opengis.net/def/uom/ISO-8601/0/Gregorian>
     * Subclass of: time:year only xsd:gYear
     * Subclass of: time:month only xsd:gMonth
     * Subclass of: time:day only xsd:gDay
     */
    public static Set<OWLAxiom> getDateTimeDescriptionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: time:GeneralDateTimeDescription
        axioms.add(df.getOWLSubClassOfAxiom(dateTimeDescription, generalDateTimeDescription));

        // Subclass of: time:hasTRS value <http://www.opengis.net/def/uom/ISO-8601/0/Gregorian>
        OWLObjectHasValue hasValueGregorian = df.getOWLObjectHasValue(hasTRS, gregorianCalendar);
        axioms.add(df.getOWLSubClassOfAxiom(dateTimeDescription, hasValueGregorian));

        // Subclass of: time:year only xsd:gYear
        OWLDataAllValuesFrom yearOnlyGYear = df.getOWLDataAllValuesFrom(year, df.getOWLDatatype(XSDVocabulary.G_YEAR.getIRI()));
        axioms.add(df.getOWLSubClassOfAxiom(dateTimeDescription, yearOnlyGYear));

        // Subclass of: time:month only xsd:gMonth
        OWLDataAllValuesFrom monthOnlyGMonth = df.getOWLDataAllValuesFrom(month, df.getOWLDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLSubClassOfAxiom(dateTimeDescription, monthOnlyGMonth));

        // Subclass of: time:day only xsd:gDay
        OWLDataAllValuesFrom dayOnlyGDay = df.getOWLDataAllValuesFrom(day, df.getOWLDatatype(XSDVocabulary.G_DAY.getIRI()));
        axioms.add(df.getOWLSubClassOfAxiom(dateTimeDescription, dayOnlyGDay));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:DateTimeInterval
     *
     * 4.1.2 Date-time interval
     *
     * Class:       time:DateTimeInterval
     * Definition:  time:DateTimeInterval is a subclass of time:ProperInterval, defined using the multi-element
     *              time:DateTimeDescription.
     * Subclass of: time:ProperInterval
     *
     * The class :DateTimeInterval is a subclass of :ProperInterval. It enables compact representation of an interval
     * corresponding to a single element in a date-time description (i.e. a specified year, month, week, day, hour,
     * minute, second). The property :hasDateTimeDescription describes the interval.
     * Note
     *
     * :DateTimeInterval can only be used for an interval whose limits coincide with a date-time element aligned to the
     * calendar and timezone indicated. For example, while both have a duration of one day, the 24-hour interval
     * beginning at midnight at the beginning of 8 May in Central Europe can be expressed as a :DateTimeInterval, but
     * the 24-hour interval starting at 1:30pm cannot.
     */
    public static Set<OWLAxiom> getDateTimeIntervalAxioms() {
       Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

       // Subclass of: time:ProperInterval
       axioms.add(df.getOWLSubClassOfAxiom(dateTimeInterval, properInterval));

       return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:DayOfWeek
     *
     * 4.1.3 Day of week
     *
     * Class:       time:DayOfWeek
     * Definition:  The day of week
     * Instance of: owl:Class
     *
     * Seven individual members of :DayOfWeek are included in the ontology, corresponding to the seven days used in the
     * Gregorian calendar, and using the English names :Sunday, :Monday, :Tuesday, :Wednesday, :Thursday, :Friday,
     * :Saturday.
     *
     * Note
     * Membership of the class :DayOfWeek is open, to allow for alternative week lengths and different day names.
     */
    public static Set<OWLAxiom> getDayOfWeekAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLDeclarationAxiom(dayOfWeek));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:Duration
     *
     * 4.1.4 Duration
     *
     * Class:       time:Duration
     * Definition:  Duration of a temporal extent expressed as a decimal number scaled by a temporal unit
     * Subclass of: :TemporalDuration
     * Subclass of: time:numericDuration exactly 1
     * Subclass of: time:unitType exactly 1
     */
    public static Set<OWLAxiom> getDurationAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: :TemporalDuration
        axioms.add(df.getOWLSubClassOfAxiom(duration, temporalDuration));

        // Subclass of: time:numericDuration exactly 1
        OWLDataExactCardinality exectly1NumericDuration = df.getOWLDataExactCardinality(1, numericDuration);
        axioms.add(df.getOWLSubClassOfAxiom(duration, exectly1NumericDuration));

        // Subclass of: time:unitType exactly 1
        OWLObjectExactCardinality exactly1UnitType = df.getOWLObjectExactCardinality(1, unitType);
        axioms.add(df.getOWLSubClassOfAxiom(duration, exactly1UnitType));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:DurationDescription
     *
     * 4.1.5 Duration description
     *
     * Class:       time:DurationDescription
     * Definition:  Description of temporal extent structured with separate values for the various elements of a
     *              calendar-clock system. The temporal reference system is fixed to Gregorian Calendar, and the range
     *              of each of the numeric properties is restricted to xsd:decimal
     * Subclass of: time:GeneralDurationDescription
     * Subclass of: time:hasTRS value <http://www.opengis.net/def/uom/ISO-8601/0/Gregorian>
     * Subclass of: time:years only xsd:decimal
     * Subclass of: time:months only xsd:decimal
     * Subclass of: time:weeks only xsd:decimal
     * Subclass of: time:days only xsd:decimal
     * Subclass of: time:hours only xsd:decimal
     * Subclass of: time:minutes only xsd:decimal
     * Subclass of: time:seconds only xsd:decimal
     *
     * Note
     * In the Gregorian calendar the length of the month is not fixed. Therefore, a value like "2.5 months" cannot be exactly compared with a similar duration expressed in terms of weeks or days.
     */
    public static Set<OWLAxiom> getDurationDescriptionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: time:GeneralDurationDescription
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, generalDurationDescription));

        // Subclass of: time:hasTRS value <http://www.opengis.net/def/uom/ISO-8601/0/Gregorian>
        OWLObjectHasValue hasValueGregorian = df.getOWLObjectHasValue(hasTRS, gregorianCalendar);
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, hasValueGregorian));

        // Subclass of: time:years only xsd:decimal
        OWLDatatype decimal = new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI());
        OWLDataAllValuesFrom yearsOnlyDecimal = df.getOWLDataAllValuesFrom(years, decimal);
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, yearsOnlyDecimal));

        // Subclass of: time:months only xsd:decimal
        OWLDataAllValuesFrom monthsOnlyDecimal = df.getOWLDataAllValuesFrom(months, decimal);
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, monthsOnlyDecimal));

        // Subclass of: time:weeks only xsd:decimal
        OWLDataAllValuesFrom weeksOnlyDecimal = df.getOWLDataAllValuesFrom(weeks, decimal);
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, weeksOnlyDecimal));

        // Subclass of: time:days only xsd:decimal
        OWLDataAllValuesFrom daysOnlyDecimal = df.getOWLDataAllValuesFrom(days, decimal);
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, daysOnlyDecimal));

        // Subclass of: time:hours only xsd:decimal
        OWLDataAllValuesFrom hoursOnlyDecimal = df.getOWLDataAllValuesFrom(hours, decimal);
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, hoursOnlyDecimal));

        // Subclass of: time:minutes only xsd:decimal
        OWLDataAllValuesFrom minutesOnlyDecimal = df.getOWLDataAllValuesFrom(minutes, decimal);
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, minutesOnlyDecimal));

        // Subclass of: time:seconds only xsd:decimal
        OWLDataAllValuesFrom secondsOnlyDecimal = df.getOWLDataAllValuesFrom(seconds, decimal);
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, secondsOnlyDecimal));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:GeneralDateTimeDescription
     *
     * 4.1.6 Generalized date-time description
     *
     * Class:       time:GeneralDateTimeDescription
     * Definition:  Description of date and time structured with separate values for the various elements of a
     *              calendar-clock system
     * Subclass of: :TemporalPosition
     * Subclass of: time:timeZone max 1
     * Subclass of: time:unitType exactly 1
     * Subclass of: time:year max 1
     * Subclass of: time:month max 1
     * Subclass of: time:day max 1
     * Subclass of: time:hour max 1
     * Subclass of: time:minute max 1
     * Subclass of: time:second max 1
     * Subclass of: time:week max 1
     * Subclass of: time:dayOfYear max 1
     * Subclass of: time:dayOfWeek max 1
     * Subclass of: time:monthOfYear max 1
     *
     * Two properties :timeZone, and :unitType, along with :hasTRS provide for reference information concerning the
     * reference system and precision of temporal position values.
     *
     * Six datatype properties :year, :month, :day, :hour, :minute, :second, together with :timeZone support the
     * description of components of a temporal position in a calendar-clock system. These correspond with the
     * 'seven property model' described in ISO 8601 [iso8601] and XML Schema Definition Language Part 2:
     * Datatypes [xmlschema11-2], except that the calendar is not specified in advance, but is provided through the
     * value of the :hasTRS property (defined above).
     *
     * Some combinations of properties are redundant. For example, within a specified :year if :dayOfYear is provided
     * then :day and :month can be computed, and vice versa. Individual values SHOULD be consistent with each other and
     * the calendar, indicated through the value of the :hasTRS property.
     *
     * Two additional properties :week and :dayOfYear allow for the the numeric value of the week or day relative to
     * the year. The property :dayOfWeek provides the name of the day, and the property :monthOfYear provides the name
     * of the month.
     */
    public static Set<OWLAxiom> getGeneralDateTimeDescriptionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: :TemporalPosition
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, temporalPosition));

        // Subclass of: time:timeZone max 1
        OWLObjectMaxCardinality max1TimeZone = df.getOWLObjectMaxCardinality(1, timeZonePredicate);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1TimeZone));

        // Subclass of: time:unitType exactly 1
        OWLObjectExactCardinality exactly1UnitType = df.getOWLObjectExactCardinality(1, unitType);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, exactly1UnitType));

        // Subclass of: time:year max 1
        OWLDataMaxCardinality max1Year = df.getOWLDataMaxCardinality(1, year);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1Year));

        // Subclass of: time:month max 1
        OWLDataMaxCardinality max1Month = df.getOWLDataMaxCardinality(1, month);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1Month));

        // Subclass of: time:day max 1
        OWLDataMaxCardinality max1Day = df.getOWLDataMaxCardinality(1, day);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1Day));

        // Subclass of: time:hour max 1
        OWLDataMaxCardinality max1Hour = df.getOWLDataMaxCardinality(1, hour);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1Hour));

        // Subclass of: time:minute max 1
        OWLDataMaxCardinality max1Minute = df.getOWLDataMaxCardinality(1, minute);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1Minute));

        // Subclass of: time:second max 1
        OWLDataMaxCardinality max1Second = df.getOWLDataMaxCardinality(1, second);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1Second));

        // Subclass of: time:week max 1
        OWLDataMaxCardinality max1Week = df.getOWLDataMaxCardinality(1, week);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1Week));

        // Subclass of: time:dayOfYear max 1
        OWLDataMaxCardinality max1DayOfYear = df.getOWLDataMaxCardinality(1, dayOfYear);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1DayOfYear));

        // Subclass of: time:dayOfWeek max 1
        OWLObjectMaxCardinality max1DayOfWeek = df.getOWLObjectMaxCardinality(1, dayOfWeekPredicate);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1DayOfWeek));

        // Subclass of: time:monthOfYear max 1
        OWLObjectMaxCardinality max1MonthOfYear = df.getOWLObjectMaxCardinality(1, monthOfYearPredicate);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1MonthOfYear));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:GeneralDurationDescription
     *
     * 4.1.7 Generalized duration description
     *
     * Class:       time:GeneralDurationDescription
     * Definition:  Description of temporal extent structured with separate values for the various elements of a
     *              calendar-clock system.
     * Subclass of: :TemporalDuration
     * Subclass of: time:hasTRS exactly 1
     * Subclass of: time:years max 1
     * Subclass of: time:months max 1
     * Subclass of: time:weeks max 1
     * Subclass of: time:days max 1
     * Subclass of: time:hours max 1
     * Subclass of: time:minutes max 1
     * Subclass of: time:seconds max 1
     *
     * Seven datatype properties :years, :months, :weeks, :days, :hours, :minutes, and :seconds support the descriptio
     * of components of a temporal extent in a calendar-clock system.
     *
     * The property time:hasTRS indicates the temporal reference system applicable for the duration components.
     *
     * Note
     * The extent of a time duration expressed as a GeneralDurationDescription depends on the Temporal Reference
     * System. In some calendars the length of the week or month is not constant within the year. Therefore, a value
     * like "2.5 months" may not necessarily be exactly compared with a similar duration expressed in terms of weeks or
     * days. When non-earth-based calendars are considered even more care must be taken in comparing durations.
     */
    public static Set<OWLAxiom> getGeneralDurationDescriptionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: :TemporalDuration
        axioms.add(df.getOWLSubClassOfAxiom(generalDurationDescription, temporalDuration));

        // Subclass of: time:hasTRS exactly 1
        OWLObjectExactCardinality hasExactly1TRS = df.getOWLObjectExactCardinality(1, hasTRS);
        axioms.add(df.getOWLSubClassOfAxiom(generalDurationDescription, hasExactly1TRS));

        // Subclass of: time:years max 1
        OWLDataMaxCardinality max1Years = df.getOWLDataMaxCardinality(1, years);
        axioms.add(df.getOWLSubClassOfAxiom(generalDurationDescription, max1Years));

        // Subclass of: time:months max 1
        OWLDataMaxCardinality max1Months = df.getOWLDataMaxCardinality(1, months);
        axioms.add(df.getOWLSubClassOfAxiom(generalDurationDescription, max1Months));

        // Subclass of: time:weeks max 1
        OWLDataMaxCardinality max1Weeks = df.getOWLDataMaxCardinality(1, weeks);
        axioms.add(df.getOWLSubClassOfAxiom(generalDurationDescription, max1Weeks));

        // Subclass of: time:days max 1
        OWLDataMaxCardinality max1Days = df.getOWLDataMaxCardinality(1, days);
        axioms.add(df.getOWLSubClassOfAxiom(generalDurationDescription, max1Days));

        // Subclass of: time:hours max 1
        OWLDataMaxCardinality max1Hours = df.getOWLDataMaxCardinality(1, hours);
        axioms.add(df.getOWLSubClassOfAxiom(generalDurationDescription, max1Hours));

        // Subclass of: time:minutes max 1
        OWLDataMaxCardinality max1Minutes = df.getOWLDataMaxCardinality(1, minutes);
        axioms.add(df.getOWLSubClassOfAxiom(generalDurationDescription, max1Minutes));

        // Subclass of: time:seconds max 1
        OWLDataMaxCardinality max1Seconds = df.getOWLDataMaxCardinality(1, seconds);
        axioms.add(df.getOWLSubClassOfAxiom(generalDurationDescription, max1Seconds));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:Instant
     *
     * 4.1.8 Time instant
     *
     * Class:       time:Instant
     * Definition:  A temporal entity with zero extent or duration
     * Subclass of: time:TemporalEntity
     *
     * Seven properties, :inXSDDate, :inXSDDateTime (deprecated), :inXSDDateTimeStamp, :inXSDgYear, :inXSDgYearMonth,
     * :inTimePosition, and :inDateTime provide alternative ways to describe the temporal position of an :Instant.
     */
    public static Set<OWLAxiom> getInstantAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: time:TemporalEntity
        axioms.add(df.getOWLSubClassOfAxiom(instant, temporalEntity));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:Interval
     *
     * 4.1.9 Time interval
     *
     * Class:       time:Interval
     * Definition:  A temporal entity with an extent or duration
     * Subclass of: time:TemporalEntity
     *
     * One property :inside links to an :Instant that falls inside the :Interval.
     */
    public static Set<OWLAxiom> getIntervalAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: time:TemporalEntity
        axioms.add(df.getOWLSubClassOfAxiom(interval, temporalEntity));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:MonthOfYear
     *
     * 4.1.10 Month of year
     *
     * Class:  time:MonthOfYear
     * Definition:     The month of the year
     * Subclass of:    time:DateTimeDescription
     * Subclass of:    time:year exactly 0
     * Subclass of:    time:month exactly 1
     * Subclass of:    time:week exactly 0
     * Subclass of:    time:day exactly 0
     * Subclass of:    time:hour exactly 0
     * Subclass of:    time:minute exactly 0
     * Subclass of:    time:second exactly 0
     * Subclass of:    time:unitType value time:unitMonth
     * Editorial note:     Feature at risk - added in 2017 revision, and not yet widely used.
     *
     * Twelve individual members of :MonthOfYear are provided in a separate namespace, corresponding to the twelve
     * months used in the Gregorian calendar greg:January, greg:February, greg:March, greg:April, greg:May, greg:June,
     * greg:July, greg:August, greg:September, greg:October, greg:November, greg:December. Each month is defined by
     * setting the value of time:month to the corresponding value.
     *
     * Note
     * Membership of the class :MonthOfYear is open, to allow for alternative annual calendars and different month
     * names.
     */
    public static Set<OWLAxiom> getMonthOfYearAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of:    time:DateTimeDescription
        axioms.add(df.getOWLSubClassOfAxiom(monthOfYear, dateTimeDescription));

        // Subclass of:    time:year exactly 0
        OWLDataExactCardinality exactly0Year = df.getOWLDataExactCardinality(0, year);
        axioms.add(df.getOWLSubClassOfAxiom(monthOfYear, exactly0Year));

        // Subclass of:    time:month exactly 1
        OWLDataExactCardinality exactly1Month = df.getOWLDataExactCardinality(1, month);
        axioms.add(df.getOWLSubClassOfAxiom(monthOfYear, exactly1Month));

        // Subclass of:    time:week exactly 0
        OWLDataExactCardinality exactly0Week = df.getOWLDataExactCardinality(0, week);
        axioms.add(df.getOWLSubClassOfAxiom(monthOfYear, exactly0Week));

        // Subclass of:    time:day exactly 0
        OWLDataExactCardinality exactly0Day = df.getOWLDataExactCardinality(0, day);
        axioms.add(df.getOWLSubClassOfAxiom(monthOfYear, exactly0Day));

        // Subclass of:    time:hour exactly 0
        OWLDataExactCardinality exactly0Hour = df.getOWLDataExactCardinality(0, hour);
        axioms.add(df.getOWLSubClassOfAxiom(monthOfYear, exactly0Hour));

        // Subclass of:    time:minute exactly 0
        OWLDataExactCardinality exactly0Minute = df.getOWLDataExactCardinality(0, minute);
        axioms.add(df.getOWLSubClassOfAxiom(monthOfYear, exactly0Minute));

        // Subclass of:    time:second exactly 0
        OWLDataExactCardinality exactly0Second = df.getOWLDataExactCardinality(0, second);
        axioms.add(df.getOWLSubClassOfAxiom(monthOfYear, exactly0Second));

        // Subclass of:    time:unitType value time:unitMonth
        OWLObjectHasValue unitTypeHasValueUnitMonth = df.getOWLObjectHasValue(unitType, unitMonth);
        axioms.add(df.getOWLSubClassOfAxiom(monthOfYear, unitTypeHasValueUnitMonth));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:ProperInterval
     *
     * 4.1.11 Proper interval
     *
     * Class:         time:ProperInterval
     * Definition:    A temporal entity with non-zero extent or duration, i.e. for which the value of the beginning and
     *                end are different
     * Subclass of:   time:Interval
     * Disjoint with: time:Instant
     *
     * Fifteen properties :intervalBefore, :intervalAfter, :intervalMeets, :intervalMetBy, :intervalOverlaps,
     * :intervalOverlappedBy, :intervalStarts, :intervalStartedBy, :intervalDuring, :intervalContains,
     * :intervalFinishes, :intervalFinishedBy, :intervalEquals :intervalDisjoint :intervalIn support the set of
     * interval relations defined by Allen [al-84] and Allen and Ferguson [af-97].
     */
    public static Set<OWLAxiom> getProperIntervalAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of:   time:Interval
        axioms.add(df.getOWLSubClassOfAxiom(properInterval, interval));

        // Disjoint with: time:Instant
        axioms.add(df.getOWLDisjointClassesAxiom(Sets.newHashSet(properInterval, instant)));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:TemporalDuration
     *
     * 4.1.12 Temporal duration
     *
     * Class:       time:TemporalDuration
     * Definition:  Time extent; duration of a time interval separate from its particular start position
     * Instance of: owl:Class
     */
    public static Set<OWLAxiom> getTemporalDurationAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLDeclarationAxiom(temporalDuration));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:TemporalEntity
     *
     * 4.1.13 Temporal entity
     *
     * Class:       time:TemporalEntity
     * Definition:  A temporal interval or instant.
     * Instance of: owl:Class
     * Union of:    time:Instant , time:Interval
     *
     * Two properties, :before, :after, support ordering relationships between two :TemporalEntitys.
     *
     * The properties :hasBeginning, :hasEnd and :hasTemporalDuration (or its sub-properties), support the description
     * of the bounds and extent of a :TemporalEntity.
     */
    public static Set<OWLAxiom> getTemporalEntityAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        OWLClassExpression unionOfInstantAndInterval = df.getOWLObjectUnionOf(instant, interval);
        axioms.add(df.getOWLEquivalentClassesAxiom(temporalEntity, unionOfInstantAndInterval));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:TemporalPosition
     *
     * 4.1.14 Temporal position
     *
     * Class:       time:TemporalPosition
     * Definition:  A position on a time-line
     * Instance of: owl:Class
     * Subclass of: time:hasTRS exactly 1
     *
     * The property time:hasTRS indicates the temporal reference system.
     */
    public static Set<OWLAxiom> getTemporalPositionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of:    time:hasTRS exactly 1
        OWLObjectExactCardinality hasExactly1TRS = df.getOWLObjectExactCardinality(1, hasTRS);
        axioms.add(df.getOWLSubClassOfAxiom(temporalPosition, hasExactly1TRS));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:TemporalUnit
     *
     * 4.1.15 Temporal unit
     *
     * Class:       time:TemporalUnit
     * Definition:  A standard duration, which provides the scale factor for a time extent, or the granularity or
     *              precision for a time position.
     * Subclass of: time:TemporalDuration
     *
     * Seven individual members of :TemporalUnit are included in the ontology, corresponding to the elements of the
     * standard calendar-clock: :unitYear, :unitMonth, :unitWeek, :unitDay, :unitHour, :unitMinute and :unitSecond.
     *
     * Note
     * Membership of the class TemporalUnit is open, to allow for other temporal units used in some technical
     * applications (e.g. millions of years, Baha'i month).
     */
    public static Set<OWLAxiom> getTemporalUnitAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: time:TemporalDuration
        axioms.add(df.getOWLSubClassOfAxiom(temporalUnit, temporalDuration));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:TimePosition
     *
     * 4.1.16 Time position
     *
     * Class:       time:TimePosition
     * Definition:  A temporal position described using either a (nominal) value from an ordinal reference system, or a
     *              (numeric) value in a temporal coordinate system.
     * Subclass of: :TemporalPosition
     * Subclass of: ( time:numericPosition exactly 1 ) or ( time:nominalPosition exactly 1 )
     *
     * Two properties :nominalPosition and :numericPosition support the alternative descriptions of position or extent.
     * One of these is expected to be present.
     *
     * The temporal ordinal reference system should be provided as the value of the :hasTRS property
     *
     * The temporal coordinate system should be provided as the value of the :hasTRS property
     */
    public static Set<OWLAxiom> getTimePositionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: :TemporalPosition
        axioms.add(df.getOWLSubClassOfAxiom(timePosition, temporalPosition));

        // Subclass of: ( time:numericPosition exactly 1 ) or ( time:nominalPosition exactly 1 )
        OWLDataExactCardinality exactly1NumericPosition = df.getOWLDataExactCardinality(1, numericPosition);
        OWLDataExactCardinality exactly1NominalPosition = df.getOWLDataExactCardinality(1, nominalPosition);
        OWLObjectUnionOf exactly1NumericPositionOrExactly1NominalPosition = df.getOWLObjectUnionOf(exactly1NumericPosition, exactly1NominalPosition);
        axioms.add(df.getOWLSubClassOfAxiom(timePosition, exactly1NumericPositionOrExactly1NominalPosition));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:TimeZone
     *
     * 4.1.17 Time-zone
     *
     * Class:       time:TimeZone
     * Definition:  A Time Zone specifies the amount by which the local time is offset from UTC. A time zone is usually
     *              denoted geographically (e.g. Australian Eastern Daylight Time), with a constant value in a given
     *              region. The region where it applies and the offset from UTC are specified by a locally recognised
     *              governing authority.
     * Instance of: owl:Class
     *
     * No specific properties are provided for the class :TimeZone, the definition of which is beyond the scope of this
     * ontology. The class specified here is a stub, effectively the superclass of all time zone classes.
     *
     * Note
     * An ontology for time zone descriptions was described in [owl-time-20060927] and provided as RDF in a separate
     * namespace tzont:. However, that ontology was incomplete in scope, and the example datasets were selective.
     * Furthermore, since the use of a class from an external ontology as the range of an ObjectProperty in OWL-Time
     * creates a dependency, reference to the time zone class has been replaced with the 'stub' class in the normative
     * part of this version of OWL-Time.
     *
     * Note
     * A designated timezone is associated with a geographic region. However, for a particular region the offset from
     * UTC often varies seasonally, and the dates of the changes may vary from year to year. The timezone designation
     * usually changes for the different seasons (e.g. Australian Eastern Standard Time vs. Australian Eastern Daylight
     * Time). Furthermore, the offset for a timezone may change over longer timescales, though its designation might
     * not.
     *
     * Detailed guidance about working with time zones is given in [timezone].
     */
    public static Set<OWLAxiom> getTimeZoneAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLDeclarationAxiom(timeZone));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:TRS
     *
     * 4.1.18 Temporal reference system
     *
     * Class:       time:TRS
     * Definition:  A temporal reference system, such as a temporal coordinate system (with an origin, direction, and
     *              scale), a calendar-clock combination, or a (possibly hierarchical) ordinal system.
     * Instance of: owl:Class
     *
     * No specific properties are provided for the class :TRS, the definition of which is beyond the scope of this
     * ontology. The class specified here is a stub, effectively the superclass of all temporal reference system types.
     *
     * Note that an ordinal temporal reference system, such as the geologic timescale, may be represented directly,
     * using this ontology, as a set of :ProperIntervals, along with enough inter-relationships to support the
     * necessary ordering relationships. See example below of Geologic Timescale.
     *
     * Note
     * A taxonomy of temporal reference systems is provided in ISO 19108:2002 [iso19108], including (a) calendar +
     * clock systems; (b) temporal coordinate systems (i.e. numeric offset from an epoch); (c) temporal ordinal
     * reference systems (i.e. ordered sequence of named intervals, not necessarily of equal duration).
     */
    public static Set<OWLAxiom> getTRSAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLDeclarationAxiom(trs));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:after
     *
     * 4.2.1 after
     *
     * Property:         time:after
     * Definition:       Gives directionality to time. If a temporal entity T1 is after another temporal entity T2,
     *                   then the beginning of T1 is after the end of T2.
     * Instance of:      owl:ObjectProperty
     * Domain:           time:TemporalEntity
     * Range:            time:TemporalEntity
     * Inverse Property: time:before
     */
    public static Set<OWLAxiom> getAfterAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:           time:TemporalEntity
        axioms.add(df.getOWLObjectPropertyDomainAxiom(after, temporalEntity));

        // Range:            time:TemporalEntity
        axioms.add(df.getOWLObjectPropertyRangeAxiom(after, temporalEntity));

        // Inverse Property: time:before
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(after, before));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:before
     *
     * 4.2.2 before
     *
     * Property:         time:before
     * Definition:       Gives directionality to time. If a temporal entity T1 is before another temporal entity T2,
     *                   then the end of T1 is before the beginning of T2. Thus, before can be considered to be basic
     *                   to instants and derived for intervals.
     * Instance of:      owl:ObjectProperty
     * Domain:           time:TemporalEntity
     * Range:            time:TemporalEntity
     * Inverse Property: time:after
     *
     * FIXME: The original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also states that before is transitive
     */
    public static Set<OWLAxiom> getBeforeAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:           time:TemporalEntity
        axioms.add(df.getOWLObjectPropertyDomainAxiom(before, temporalEntity));

        // Range:            time:TemporalEntity
        axioms.add(df.getOWLObjectPropertyRangeAxiom(before, temporalEntity));

        // Inverse Property: time:after
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(before, after));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:day
     *
     * 4.2.3 day
     *
     * Property:    time:day
     * Definition:  Day position in a calendar-clock system. The range of this property is not specified, so can be
     *              replaced by any specific representation of a calendar day from any calendar.
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDateTimeDescription
     */
    public static Set<OWLAxiom> getDayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(day, generalDateTimeDescription));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:dayOfWeek
     *
     * 4.2.4 day of week
     *
     * Property:    time:dayOfWeek
     * Definition:  The day of week, whose value is a member of the class time:DayOfWeek
     * Instance of: owl:ObjectProperty
     * Domain:      time:GeneralDateTimeDescription
     * Range:       time:DayOfWeek
     */
    public static Set<OWLAxiom> getDayOfWeekPredicateAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLObjectPropertyDomainAxiom(dayOfWeekPredicate, generalDateTimeDescription));

        // Range:       time:DayOfWeek
        axioms.add(df.getOWLObjectPropertyRangeAxiom(dayOfWeekPredicate, dayOfWeek));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:dayOfYear
     *
     * 4.2.5 day of year
     *
     * Property:    time:dayOfYear
     * Definition:  The number of the day within the year
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDateTimeDescription
     * Range:       xsd:nonNegativeInteger
     */
    public static Set<OWLAxiom> getDayOfYearAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(dayOfYear, generalDateTimeDescription));

        // Range:       xsd:nonNegativeInteger
        axioms.add(df.getOWLDataPropertyRangeAxiom(
                dayOfYear, new OWLDatatypeImpl(XSDVocabulary.NON_NEGATIVE_INTEGER.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:days
     *
     * 4.2.6 days duration
     *
     * Property:    time:days
     * Definition:  length of, or element of the length of, a temporal extent expressed in days
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDurationDescription
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getDaysAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDurationDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(days, generalDurationDescription));

        // Range:       xsd:decimal
        axioms.add(df.getOWLDataPropertyRangeAxiom(days, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hasBeginning
     *
     * 4.2.7 has beginning
     *
     * Property:    time:hasBeginning
     * Definition:  Beginning of a temporal entity.
     * Instance of: owl:ObjectProperty
     * Domain:      time:TemporalEntity
     * Range:       time:Instant
     *
     * FIXME: Original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains SubPropertyOf: has time
     */
    public static Set<OWLAxiom> getHasBeginningAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:TemporalEntity
        axioms.add(df.getOWLObjectPropertyDomainAxiom(hasBeginning, temporalEntity));

        // Range:       time:Instant
        axioms.add(df.getOWLObjectPropertyRangeAxiom(hasBeginning, instant));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hasDateTimeDescription
     *
     * 4.2.8 has date-time description
     *
     * Property:    time:hasDateTimeDescription
     * Definition:  Position and extent of time:DateTimeInterval expressed as a structured value. The beginning and
     *              end of the interval coincide with the limits of the shortest element in the description.
     * Instance of: owl:ObjectProperty
     * Domain:      time:DateTimeInterval
     * Range:       time:GeneralDateTimeDescription
     */
    public static Set<OWLAxiom> getHasDateTimeDescriptionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:DateTimeInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(hasDateTimeDescription, dateTimeInterval));

        // Range:       time:GeneralDateTimeDescription
        axioms.add(df.getOWLObjectPropertyRangeAxiom(hasDateTimeDescription, generalDateTimeDescription));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hasDuration
     *
     * 4.2.9 has duration
     *
     * Property:       time:hasDuration
     * Definition:     Duration of a temporal entity, expressed as a scaled value or nominal value
     * Instance of:    owl:ObjectProperty
     * Subproperty of: time:hasTemporalDuration
     * Range:          time:Duration
     */
    public static Set<OWLAxiom> getHasDurationAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subproperty of: time:hasTemporalDuration
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(hasDuration, hasTemporalDuration));
        // Range:          time:Duration
        axioms.add(df.getOWLObjectPropertyRangeAxiom(hasDuration, duration));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hasDurationDescription
     *
     * 4.2.10 has duration description
     *
     * Property:       time:hasDurationDescription
     * Definition:     Duration of a temporal entity, expressed using a structured description
     * Instance of:    owl:ObjectProperty
     * Subproperty of: time:hasTemporalDuration
     * Range:          time:DurationDescription
     */
    public static Set<OWLAxiom> getHasDurationDescriptionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subproperty of: time:hasTemporalDuration
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(hasDurationDescription, hasTemporalDuration));

        // Range:          time:DurationDescription
        // FIXME: The original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl contains Range: Generalized duration description instead
        axioms.add(df.getOWLObjectPropertyRangeAxiom(hasDurationDescription, durationDescription));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hasEnd
     *
     * 4.2.11 has end
     *
     * Property:    time:hasEnd
     * Definition:  End of a temporal entity.
     * Instance of: owl:ObjectProperty
     * Domain:      time:TemporalEntity
     * Range:       time:Instant
     *
     * FIXME: Original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains SubPropertyOf: has time
     */
    public static Set<OWLAxiom> getHasEndAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:TemporalEntity
        axioms.add(df.getOWLObjectPropertyDomainAxiom(hasEnd, temporalEntity));

        // Range:       time:Instant
        axioms.add(df.getOWLObjectPropertyRangeAxiom(hasEnd, instant));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hasTemporalDuration
     *
     * 4.2.12 has temporal duration
     *
     * Property:    time:hasTemporalDuration
     * Definition:  Duration of a temporal entity
     * Instance of: owl:ObjectProperty
     * Domain:      time:TemporalEntity
     * Range:       time:TemporalDuration
     */
    public static Set<OWLAxiom> getHasTemporalDurationAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:TemporalEntity
        axioms.add(df.getOWLObjectPropertyDomainAxiom(hasTemporalDuration, temporalEntity));

        // Range:       time:TemporalDuration
        axioms.add(df.getOWLObjectPropertyRangeAxiom(hasTemporalDuration, temporalDuration));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hasTime
     *
     * 4.2.13 has time
     *
     * Property:       time:hasTime
     * Definition:     Supports the association of a temporal entity (instant or interval) to any thing.
     * Instance of:    owl:ObjectProperty
     * Range:          time:TemporalEntity
     * Editorial note: Feature at risk - added in 2017 revision, and not yet widely used.
     */
    public static Set<OWLAxiom> getHasTimeAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Range:          time:TemporalEntity
        axioms.add(df.getOWLObjectPropertyRangeAxiom(hasTime, temporalEntity));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hasTRS
     *
     * 4.2.14 temporal reference system used
     *
     * Property:    time:hasTRS
     * Definition:  The temporal reference system used by a temporal position or extent description.
     * Instance of: owl:ObjectProperty
     * Instance of: owl:FunctionalProperty
     * Domain:      time:TemporalPosition or time:GeneralDurationDescription
     * Range:       time:TRS
     */
    public static Set<OWLAxiom> getHasTRSAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Instance of: owl:FunctionalProperty
        axioms.add(df.getOWLFunctionalObjectPropertyAxiom(hasTRS));

        // Domain:      time:TemporalPosition or time:GeneralDurationDescription
        OWLClassExpression temporalPositionOrGeneralDurationDescription =
                df.getOWLObjectUnionOf(temporalPosition, generalDurationDescription);
        axioms.add(df.getOWLObjectPropertyDomainAxiom(hasTRS, temporalPositionOrGeneralDurationDescription));

        // Range:       time:TRS
        axioms.add(df.getOWLObjectPropertyRangeAxiom(hasTRS, trs));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hasXSDDuration
     *
     * 4.2.15 has XSD duration
     *
     * Property:       time:hasXSDDuration
     * Definition:     Extent of a temporal entity, expressed using xsd:duration
     * Instance of:    owl:DatatypeProperty
     * Domain:         time:TemporalEntity
     * Range:          xsd:duration
     * Editorial note: Feature at risk - added in 2017 revision, and not yet widely used.
     */
    public static Set<OWLAxiom> getHasXSDDurationAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:         time:TemporalEntity
        axioms.add(df.getOWLDataPropertyDomainAxiom(hasXSDDuration, temporalEntity));

        // Range:          xsd:duration
        axioms.add(
                df.getOWLDataPropertyRangeAxiom(hasXSDDuration, new OWLDatatypeImpl(XSDVocabulary.DURATION.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hour
     *
     * 4.2.16 hour
     *
     * Property:    time:hour
     * Definition:  Hour position in a calendar-clock system
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDateTimeDescription
     * Range:       xsd:nonNegativeInteger
     */
    public static Set<OWLAxiom> getHourAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(hour, generalDateTimeDescription));

        // Range:       xsd:nonNegativeInteger
        axioms.add(
                df.getOWLDataPropertyRangeAxiom(hour, new OWLDatatypeImpl(XSDVocabulary.NON_NEGATIVE_INTEGER.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:hours
     *
     * 4.2.17 hours duration
     *
     * Property:    time:hours
     * Definition:  length of, or element of the length of, a temporal extent expressed in hours
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDurationDescription
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getHoursAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDurationDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(hours, generalDurationDescription));

        // Range:       xsd:decimal
        axioms.add(df.getOWLDataPropertyRangeAxiom(hours, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:inDateTime
     *
     * 4.2.18 in date-time description
     *
     * Property:       time:inDateTime
     * Definition:     Position of an instant, expressed using a structured description
     * Instance of:    owl:ObjectProperty
     * Subproperty of: time:inTemporalPosition
     * Domain:         time:Instant
     * Range:          time:GeneralDateTimeDescription
     */
    public static Set<OWLAxiom> getInDateTimeAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subproperty of: time:inTemporalPosition
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(inDateTime, inTemporalPosition));

        // Domain:         time:Instant
        axioms.add(df.getOWLObjectPropertyDomainAxiom(inDateTime, instant));

        // Range:          time:GeneralDateTimeDescription
        axioms.add(df.getOWLObjectPropertyRangeAxiom(inDateTime, generalDateTimeDescription));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:inside
     *
     * 4.2.19 has time instant inside
     *
     * Property:    time:inside
     * Definition:  An instant that falls inside the interval. It is not intended to include beginnings and ends of
     *              intervals.
     * Instance of: owl:ObjectProperty
     * Domain:      time:Interval
     * Range:       time:Instant
     */
    public static Set<OWLAxiom> getInsideAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:Interval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(inside, interval));

        // Range:       time:Instant
        axioms.add(df.getOWLObjectPropertyRangeAxiom(inside, instant));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:inTemporalPosition
     *
     * 4.2.20 temporal position
     *
     * Property:   time:inTemporalPosition
     * Definition:     Position of a time instant
     * Instance of:    owl:ObjectProperty
     * Domain:     time:Instant
     * Range:  time:TemporalPosition
     */
    public static Set<OWLAxiom> getInTemporalPositionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:     time:Instant
        axioms.add(df.getOWLObjectPropertyDomainAxiom(inTemporalPosition, instant));

        // Range:  time:TemporalPosition
        axioms.add(df.getOWLObjectPropertyRangeAxiom(inTemporalPosition, temporalPosition));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalAfter
     *
     * 4.2.21 interval after
     *
     * Property:       time:intervalAfter
     * Definition:     If a proper interval T1 is intervalAfter another proper interval T2, then the beginning of T1
     *                 is after the end of T2.
     * Instance of:    owl:ObjectProperty
     * Domain:         time:ProperInterval
     * Range:          time:ProperInterval
     * SubProperty of: time:after
     * SubProperty of: time:intervalDisjoint
     * Inverse of:     time:intervalBefore
     */
    public static Set<OWLAxiom> getIntervalAfterAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:         time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalAfter, properInterval));

        // Range:          time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalAfter, properInterval));

        // SubProperty of: time:after
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(intervalAfter, after));

        // SubProperty of: time:intervalDisjoint
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(intervalAfter, intervalDisjoint));

        // Inverse of:     time:intervalBefore
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalAfter, intervalBefore));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalBefore
     *
     * 4.2.22 interval before
     *
     * Property:       time:intervalBefore
     * Definition:     If a proper interval T1 is intervalBefore another proper interval T2, then the end of T1 is
     *                 before the beginning of T2.
     * Instance of:    owl:ObjectProperty
     * Domain:         time:ProperInterval
     * Range:          time:ProperInterval
     * SubProperty of: time:before
     * SubProperty of: time:intervalDisjoint
     * Inverse of:     time:intervalAfter
     */
    public static Set<OWLAxiom> getIntervalBeforeAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:         time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalBefore, properInterval));

        // Range:          time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalBefore, properInterval));

        // SubProperty of: time:before
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(intervalBefore, before));

        // SubProperty of: time:intervalDisjoint
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(intervalBefore, intervalDisjoint));

        // Inverse of:     time:intervalAfter
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalAfter, intervalBefore));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalContains
     *
     * 4.2.23 interval contains
     *
     * Property:    time:intervalContains
     * Definition:  If a proper interval T1 is intervalContains another proper interval T2, then the beginning of T1 is
     *              before the beginning of T2, and the end of T1 is after the end of T2.
     * Instance of: owl:ObjectProperty
     * Domain:      time:ProperInterval
     * Range:       time:ProperInterval
     * Inverse of:  time:intervalDuring
     */
    public static Set<OWLAxiom> getIntervalContainsAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalContains, properInterval));

        // Range:       time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalContains, properInterval));

        // Inverse of:  time:intervalDuring
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalContains, intervalDuring));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalDisjoint
     *
     * 4.2.24 interval disjoint
     *
     * Property:    time:intervalDisjoint
     * Definition:  If a proper interval T1 is intervalDisjoint another proper interval T2, then the beginning of T1
     *              is after the end of T2, or the end of T1 is before the beginning of T2, i.e. the intervals do not
     *              overlap in any way, but their ordering relationship is not known.
     * Instance of: owl:ObjectProperty
     * Domain:      time:ProperInterval
     * Range:       time:ProperInterval
     */
    public static Set<OWLAxiom> getIntervalDisjointAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalDisjoint, properInterval));

        // Range:       time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalDisjoint, properInterval));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalDuring
     *
     * 4.2.25 interval during
     *
     * Property:    time:intervalDuring
     * Definition:  If a proper interval T1 is intervalDuring another proper interval T2, then the beginning of T1 is
     *              after the beginning of T2, and the end of T1 is before the end of T2.
     * Instance of: owl:ObjectProperty
     * Domain:      time:ProperInterval
     * Range:       time:ProperInterval
     * Inverse of:  time:intervalContains
     *
     * FIXME: original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains SubPropertyOf: interval in
     */
    public static Set<OWLAxiom> getIntervalDuringAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalDuring, properInterval));

        // Range:       time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalDuring, properInterval));

        // Inverse of:  time:intervalContains
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalDuring, intervalContains));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalEquals
     *
     * 4.2.26 interval equals
     *
     * Property:      time:intervalEquals
     * Definition:    If a proper interval T1 is intervalEquals another proper interval T2, then the beginning of T1 is
     *                coincident with the beginning of T2, and the end of T1 is coincident with the end of T2.
     * Instance of:   owl:ObjectProperty
     * Domain:        time:ProperInterval
     * Range:         time:ProperInterval
     * Disjoint with: time:intervalIn
     */
    public static Set<OWLAxiom> getIntervalEqualsAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:        time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalEquals, properInterval));

        // Range:         time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalEquals, properInterval));

        // Disjoint with: time:intervalIn
        axioms.add(df.getOWLDisjointObjectPropertiesAxiom(intervalEquals, intervalIn));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalFinishedBy
     *
     * 4.2.27 interval finished by
     *
     * Property:    time:intervalFinishedBy
     * Definition:  If a proper interval T1 is intervalFinishedBy another proper interval T2, then the beginning of T1
     *              is before the beginning of T2, and the end of T1 is coincident with the end of T2.
     * Instance of: owl:ObjectProperty
     * Domain:      time:ProperInterval
     * Range:       time:ProperInterval
     * Inverse of:  time:intervalFinishes
     */
    public static Set<OWLAxiom> getIntervalFinishedByAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalFinishedBy, properInterval));

        // Range:       time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalFinishedBy, properInterval));

        // Inverse of:  time:intervalFinishes
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalFinishedBy, intervalFinishes));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalFinishes
     *
     * 4.2.28 interval finishes
     *
     * Property:       time:intervalFinishes
     * Definition:     If a proper interval T1 is intervalFinishes another proper interval T2, then the beginning of
     *                 T1 is after the beginning of T2, and the end of T1 is coincident with the end of T2.
     * Instance of:    owl:ObjectProperty
     * Domain:         time:ProperInterval
     * Range:          time:ProperInterval
     * SubProperty of: time:intervalIn
     * Inverse of:     time:intervalFinishedBy
     */
    public static Set<OWLAxiom> getIntervalFinishesAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:         time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalFinishes, properInterval));

        // Range:          time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalFinishes, properInterval));

        // SubProperty of: time:intervalIn
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(intervalFinishes, intervalIn));

        // Inverse of:     time:intervalFinishedBy
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalFinishes, intervalFinishedBy));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalIn
     *
     * 4.2.29 interval in
     *
     * Property:      time:intervalIn
     * Definition:    If a proper interval T1 is intervalIn another proper interval T2, then the beginning of T1 is
     *                after the beginning of T2 or is coincident with the beginning of T2, and the end of T1 is before
     *                the end of T2 or is coincident with the end of T2, except that end of T1 may not be coincident
     *                with the end of T2 if the beginning of T1 is coincident with the beginning of T2.
     * Instance of:   owl:ObjectProperty
     * Domain:        time:ProperInterval
     * Range:         time:ProperInterval
     * Disjoint with: time:intervalEquals
     */
    public static Set<OWLAxiom> getIntervalInAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:        time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalIn, properInterval));

        // Range:         time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalIn, properInterval));

        // Disjoint with: time:intervalEquals
        axioms.add(df.getOWLDisjointObjectPropertiesAxiom(intervalIn, intervalEquals));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalMeets
     *
     * 4.2.30 interval meets
     *
     * Property:    time:intervalMeets
     * Definition:  If a proper interval T1 is intervalMeets another proper interval T2, then the end of T1 is
     *              coincident with the beginning of T2.
     * Instance of: owl:ObjectProperty
     * Domain:      time:ProperInterval
     * Range:       time:ProperInterval
     * Inverse of:  time:intervalMetBy
     */
    public static Set<OWLAxiom> getIntervalMeetsAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalMeets, properInterval));

        // Range:       time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalMeets, properInterval));

        // Inverse of:  time:intervalMetBy
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalMeets, intervalMetBy));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalMetBy
     *
     * 4.2.31 interval met by
     *
     * Property:    time:intervalMetBy
     * Definition:  If a proper interval T1 is intervalMetBy another proper interval T2, then the beginning of T1 is
     *              coincident with the end of T2.
     * Instance of: owl:ObjectProperty
     * Domain:      time:ProperInterval
     * Range:       time:ProperInterval
     * Inverse of:  time:intervalMeets
     */
    public static Set<OWLAxiom> getIntervalMetByAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalMetBy, properInterval));

        // Range:       time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalMetBy, properInterval));

        // Inverse of:  time:intervalMeets
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalMetBy, intervalMeets));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalOverlappedBy
     *
     * 4.2.32 interval overlapped by
     *
     * Property:    time:intervalOverlappedBy
     * Definition:  If a proper interval T1 is intervalOverlappedBy another proper interval T2, then the beginning of
     *              T1 is after the beginning of T2, the beginning of T1 is before the end of T2, and the end of T1 is
     *              after the end of T2.
     * Instance of: owl:ObjectProperty
     * Domain:      time:ProperInterval
     * Range:       time:ProperInterval
     * Inverse of:  time:intervalOverlaps
     */
    public static Set<OWLAxiom> getIntervalOverlappedByAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalOverlappedBy, properInterval));

        // Range:       time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalOverlappedBy, properInterval));

        // Inverse of:  time:intervalOverlaps
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalOverlappedBy, intervalOverlaps));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalOverlaps
     *
     * 4.2.33 interval overlaps
     *
     * Property:    time:intervalOverlaps
     * Definition:  If a proper interval T1 is intervalOverlaps another proper interval T2, then the beginning of T1 is
     *              before the beginning of T2, the end of T1 is after the beginning of T2, and the end of T1 is before
     *              the end of T2.
     * Instance of: owl:ObjectProperty
     * Domain:      time:ProperInterval
     * Range:       time:ProperInterval
     * Inverse of:  time:intervalOverlappedBy
     */
    public static Set<OWLAxiom> getIntervalOverlapsAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalOverlaps, properInterval));

        // Range:       time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalOverlaps, properInterval));

        // Inverse of:  time:intervalOverlappedBy
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalOverlaps, intervalOverlappedBy));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalStartedBy
     *
     * 4.2.34 interval started by
     *
     * Property:    time:intervalStartedBy
     * Definition:  If a proper interval T1 is intervalStarted another proper interval T2, then the beginning of T1 is
     *              coincident with the beginning of T2, and the end of T1 is after the end of T2.
     * Instance of: owl:ObjectProperty
     * Domain:      time:ProperInterval
     * Range:       time:ProperInterval
     * Inverse of:  time:intervalStarts
     */
    public static Set<OWLAxiom> getIntervalStartedByAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalStartedBy, properInterval));

        // Range:       time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalStartedBy, properInterval));

        // Inverse of:  time:intervalStarts
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalStartedBy, intervalStarts));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:intervalStarts
     *
     * 4.2.35 interval starts
     *
     * Property:       time:intervalStarts
     * Definition:     If a proper interval T1 is intervalStarts another proper interval T2, then the beginning of T1
     *                 is coincident with the beginning of T2, and the end of T1 is before the end of T2.
     * Instance of:    owl:ObjectProperty
     * Domain:         time:ProperInterval
     * Range:          time:ProperInterval
     * SubProperty of: time:intervalIn
     * Inverse of:     time:intervalStartedBy
     */
    public static Set<OWLAxiom> getIntervalStartsAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:         time:ProperInterval
        axioms.add(df.getOWLObjectPropertyDomainAxiom(intervalStarts, properInterval));

        // Range:          time:ProperInterval
        axioms.add(df.getOWLObjectPropertyRangeAxiom(intervalStarts, properInterval));

        // SubProperty of: time:intervalIn
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(intervalStarts, intervalIn));

        // Inverse of:     time:intervalStartedBy
        axioms.add(df.getOWLInverseObjectPropertiesAxiom(intervalStarts, intervalStartedBy));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:inTimePosition
     *
     * 4.2.36 time position
     *
     * Property:       time:inTimePosition
     * Definition:     Position of an instant, expressed as a temporal coordinate or nominal value
     * Instance of:    owl:ObjectProperty
     * Domain:         time:Instant
     * Range:          time:TimePosition
     * Subproperty of: time:inTemporalPosition
     */
    public static Set<OWLAxiom> getInTimePositionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:         time:Instant
        axioms.add(df.getOWLObjectPropertyDomainAxiom(inTimePosition, instant));

        // Range:          time:TimePosition
        axioms.add(df.getOWLObjectPropertyRangeAxiom(inTimePosition, timePosition));

        // Subproperty of: time:inTemporalPosition
        axioms.add(df.getOWLSubObjectPropertyOfAxiom(inTimePosition, inTemporalPosition));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:inXSDDate
     *
     * 4.2.37 in XSD date
     *
     * Property:    time:inXSDDate
     * Definition:  Position of an instant, expressed using xsd:date
     * Instance of: owl:DatatypeProperty
     * Domain:      time:Instant
     * Range:       xsd:date
     */
    public static Set<OWLAxiom> getInXSDDateAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:Instant
        axioms.add(df.getOWLDataPropertyDomainAxiom(inXSDDate, instant));

        // Range:       xsd:date
        axioms.add(df.getOWLDataPropertyRangeAxiom(inXSDDate, new OWLDatatypeImpl(XSDVocabulary.DATE.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:inXSDDateTime
     *
     * 4.2.38 in XSD date-time
     *
     * Property:    time:inXSDDateTime
     * Definition:  Position of an instant, expressed using xsd:dateTime
     * Instance of: owl:DatatypeProperty
     * Instance of: owl:DeprecatedProperty
     * Domain:      time:Instant
     * Range:       xsd:dateTime
     * Deprecated:  true
     *
     * Note
     * The property :inXSDDateTime is replaced by :inXSDDateTimeStamp which makes the time-zone field mandatory.
     */
    public static Set<OWLAxiom> getInXSDDateTimeAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Instance of: owl:DeprecatedProperty
        axioms.add(df.getDeprecatedOWLAnnotationAssertionAxiom(inXSDDateTime.getIRI()));

        // Domain:      time:Instant
        axioms.add(df.getOWLDataPropertyDomainAxiom(inXSDDateTime, instant));
        // Range:       xsd:dateTime
        axioms.add(
                df.getOWLDataPropertyRangeAxiom(inXSDDateTime, new OWLDatatypeImpl(XSDVocabulary.DATE_TIME.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:inXSDDateTimeStamp
     *
     * 4.2.39 in XSD date-time-stamp
     *
     * Property:    time:inXSDDateTimeStamp
     * Definition:  Position of an instant, expressed using xsd:dateTimeStamp, in which the time-zone field is
     *              mandatory
     * Instance of: owl:DatatypeProperty
     * Domain:      time:Instant
     * Range:       xsd:dateTimeStamp
     */
    public static Set<OWLAxiom> getInXSDDateTimeStampAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:Instant
        axioms.add(df.getOWLDataPropertyDomainAxiom(inXSDDateTimeStamp, instant));
        // Range:       xsd:dateTimeStamp
        axioms.add(df.getOWLDataPropertyRangeAxiom(
                inXSDDateTimeStamp, new OWLDatatypeImpl(XSDVocabulary.DATE_TIME_STAMP.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:inXSDgYear
     *
     * 4.2.40 in XSD gYear
     *
     * Property:    time:inXSDgYear
     * Definition:  Position of an instant, expressed using xsd:gYear
     * Instance of: owl:DatatypeProperty
     * Domain:      time:Instant
     * Range:       xsd:gYear
     */
    public static Set<OWLAxiom> getInXSDgYearAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:Instant
        axioms.add(df.getOWLDataPropertyDomainAxiom(inXSDgYear, instant));

        // Range:       xsd:gYear
        axioms.add(df.getOWLDataPropertyRangeAxiom(inXSDgYear, new OWLDatatypeImpl(XSDVocabulary.G_YEAR.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:inXSDgYearMonth
     *
     * 4.2.41 in XSD gYearMonth
     *
     * Property:    time:inXSDgYearMonth
     * Definition:  Position of an instant, expressed using xsd:gYearMonth
     * Instance of: owl:DatatypeProperty
     * Domain:      time:Instant
     * Range:       xsd:gYearMonth
     */
    public static Set<OWLAxiom> getInXSDgYearMonthAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:Instant
        axioms.add(df.getOWLDataPropertyDomainAxiom(inXSDgYearMonth, instant));

        // Range:       xsd:gYearMonth
        axioms.add(df.getOWLDataPropertyRangeAxiom(
                inXSDgYearMonth, new OWLDatatypeImpl(XSDVocabulary.G_YEAR_MONTH.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:minute
     *
     * 4.2.42 minute
     *
     * Property:    time:minute
     * Definition:  Minute position in a calendar-clock system
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDateTimeDescription
     * Range:       xsd:nonNegativeInteger
     */
    public static Set<OWLAxiom> getMinuteAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(minute, generalDateTimeDescription));

        // Range:       xsd:nonNegativeInteger
        axioms.add(df.getOWLDataPropertyRangeAxiom(
                minute, new OWLDatatypeImpl(XSDVocabulary.NON_NEGATIVE_INTEGER.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:minutes
     *
     * 4.2.43 minutes duration
     *
     * Property:    time:minutes
     * Definition:  length of, or element of the length of, a temporal extent expressed in minutes
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDurationDescription
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getMinutesAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDurationDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(minutes, generalDurationDescription));

        // Range:       xsd:decimal
        axioms.add(df.getOWLDataPropertyRangeAxiom(minutes, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:month
     *
     * 4.2.44 month
     *
     * Property:    time:month
     * Definition:  Month position in a calendar-clock system. The range of this property is not specified, so can be
     *              replaced by any specific representation of a calendar month from any calendar.
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDateTimeDescription
     */
    public static Set<OWLAxiom> getMonthAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(month, generalDateTimeDescription));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:monthOfYear
     *
     * 4.2.45 month of year
     *
     * Property:       time:monthOfYear
     * Definition:     The month of the year, whose value is a member of the class time:MonthOfYear
     * Instance of:    owl:ObjectProperty
     * Domain:         time:GeneralDateTimeDescription
     * Range:          time:MonthOfYear
     * Editorial note: Feature at risk - added in 2017 revision, and not yet widely used.
     */
    public static Set<OWLAxiom> getMonthOfYearPredicateAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:         time:GeneralDateTimeDescription
        axioms.add(df.getOWLObjectPropertyDomainAxiom(monthOfYearPredicate, generalDateTimeDescription));

        // Range:          time:MonthOfYear
        axioms.add(df.getOWLObjectPropertyRangeAxiom(monthOfYearPredicate, monthOfYear));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:months
     *
     * 4.2.46 months duration
     *
     * Property:    time:months
     * Definition:  length of, or element of the length of, a temporal extent expressed in months
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDurationDescription
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getMonthsAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDurationDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(months, generalDurationDescription));

        // Range:       xsd:decimal
        axioms.add(df.getOWLDataPropertyRangeAxiom(months, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:nominalPosition
     *
     * 4.2.47 name of temporal position
     *
     * Property:    time:nominalPosition
     * Definition:  The (nominal) value indicating temporal position in an ordinal reference system
     * Instance of: owl:DatatypeProperty
     * Domain:      time:TimePosition
     * Range:       xsd:string
     */
    public static Set<OWLAxiom> getNominalPositionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:TimePosition
        axioms.add(df.getOWLDataPropertyDomainAxiom(nominalPosition, timePosition));

        // Range:       xsd:string
        axioms.add(
                df.getOWLDataPropertyRangeAxiom(nominalPosition, new OWLDatatypeImpl(XSDVocabulary.STRING.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:numericDuration
     *
     * 4.2.48 numeric value of temporal duration
     *
     * Property:    time:numericDuration
     * Definition:  Value of a temporal extent expressed as a number scaled by a temporal unit
     * Instance of: owl:DatatypeProperty
     * Domain:      time:Duration
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getNumericDurationAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:Duration
        axioms.add(df.getOWLDataPropertyDomainAxiom(numericDuration, duration));

        // Range:       xsd:decimal
        axioms.add(
                df.getOWLDataPropertyRangeAxiom(numericDuration, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:numericPosition
     *
     * 4.2.49 numeric value of temporal position
     *
     * Property:    time:numericPosition
     * Definition:  The (numeric) value indicating position within a temporal coordinate system
     * Instance of: owl:DatatypeProperty
     * Domain:      time:TimePosition
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getNumericPositionAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:TimePosition
        axioms.add(df.getOWLDataPropertyDomainAxiom(numericPosition, timePosition));

        // Range:       xsd:decimal
        axioms.add(
                df.getOWLDataPropertyRangeAxiom(numericPosition, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:second
     *
     * 4.2.50 second
     *
     * Property:    time:second
     * Definition:  Second position in a calendar-clock system.
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDateTimeDescription
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getSecondAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(second, generalDateTimeDescription));

        // Range:       xsd:decimal
        axioms.add(df.getOWLDataPropertyRangeAxiom(second, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:seconds
     *
     * 4.2.51 seconds duration
     *
     * Property:    time:seconds
     * Definition:  length of, or element of the length of, a temporal extent expressed in seconds
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDurationDescription
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getSecondsAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDurationDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(seconds, generalDurationDescription));

        // Range:       xsd:decimal
        axioms.add(df.getOWLDataPropertyRangeAxiom(seconds, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:timeZone
     *
     * 4.2.52 in time zone
     *
     * Property:    time:timeZone
     * Definition:  The time zone for clock elements in the temporal position
     * Instance of: owl:ObjectProperty
     * Domain:      time:GeneralDateTimeDescription
     * Range:       time:TimeZone
     *
     * Note
     * IANA maintains a database of timezones. These are well maintained and generally considered authoritative, but
     * individual items are not available at individual URIs, so cannot be used directly within data expressed using
     * OWL-Time.
     *
     * DBPedia provides a set of resources corresponding to the IANA timezones, with a URI for each
     * (e.g. http://dbpedia.org/resource/Australia/Eucla). The World Clock service also provides a list of time zones
     * with the description of each available as an individual webpage with a convenient individual URI
     * (e.g. https://www.timeanddate.com/time/zones/acwst). These or other, similar, resources might be used as a
     * value of the time:timeZone property.
     */
    public static Set<OWLAxiom> getTimeZonePredicateAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLObjectPropertyDomainAxiom(timeZonePredicate, generalDateTimeDescription));

        // Range:       time:TimeZone
        axioms.add(df.getOWLObjectPropertyRangeAxiom(timeZonePredicate, timeZone));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:unitType
     *
     * 4.2.53 temporal unit type
     *
     * Property:    time:unitType
     * Definition:  The temporal unit which provides the precision of a date-time value or scale of a temporal extent
     * Instance of: owl:ObjectProperty
     * Domain:      time:GeneralDateTimeDescription or time:Duration
     * Range:       time:TemporalUnit
     */
    public static Set<OWLAxiom> getUnitTypeAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription or time:Duration
        OWLClassExpression generalDateTimeDescriptionOrDuration =
                df.getOWLObjectUnionOf(generalDateTimeDescription, duration);
        axioms.add(df.getOWLObjectPropertyDomainAxiom(unitType, generalDateTimeDescriptionOrDuration));

        // Range:       time:TemporalUnit
        axioms.add(df.getOWLObjectPropertyRangeAxiom(unitType, temporalUnit));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:week
     *
     * 4.2.54 week
     *
     * Property:    time:week
     * Definition:  Week number within the year.
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDateTimeDescription
     * Range:       xsd:nonNegativeInteger
     *
     * Note
     * Weeks are numbered differently depending on the calendar in use and the local language or cultural conventions
     * (locale). ISO-8601 specifies that the first week of the year includes at least four days, and that Monday is the
     * first day of the week. In that system, week 1 is the week that contains the first Thursday in the year.
     */
    public static Set<OWLAxiom> getWeekAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(week, generalDateTimeDescription));

        // Range:       xsd:nonNegativeInteger
        axioms.add(df.getOWLDataPropertyRangeAxiom(week, new OWLDatatypeImpl(XSDVocabulary.NON_NEGATIVE_INTEGER.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:weeks
     *
     * 4.2.55 weeks duration
     *
     * Property:    :weeks
     * Definition:  length of, or element of the length of, a temporal extent expressed in weeks
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDurationDescription
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getWeeksAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDurationDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(weeks, generalDurationDescription));

        // Range:       xsd:decimal
        axioms.add(df.getOWLDataPropertyRangeAxiom(weeks, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:xsdDateTime
     *
     * 4.2.56 has XSD date-time
     *
     * Property:    time:xsdDateTime
     * Definition:  Value of time:DateTimeInterval expressed as a compact value. The beginning and end of the interval
     *              coincide with the limits of the smallest non-zero element of the value.
     * Instance of: owl:DatatypeProperty
     * Instance of: owl:DeprecatedProperty
     * Domain:      time:DateTimeInterval
     * Range:       xsd:dateTime
     * Deprecated:  true
     *
     * Note
     * Using xsd:dateTime in this place means that the duration of the interval is implicit: it corresponds to the
     * length of the smallest non-zero element of the date-time literal. However, this rule cannot be used for
     * intervals whose duration is more than one rank smaller than the starting time - e.g. the first minute or second
     * of a day, the first hour of a month, or the first day of a year. In these cases the desired interval cannot be
     * distinguished from the interval corresponding to the next rank up. Because of this essential ambiguity, use of
     * this property is not recommended and it is deprecated.
     */
    public static Set<OWLAxiom> getXSDDateTimeAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Instance of: owl:DeprecatedProperty
        axioms.add(df.getDeprecatedOWLAnnotationAssertionAxiom(xsdDateTime.getIRI()));

        // Domain:      time:DateTimeInterval
        axioms.add(df.getOWLDataPropertyDomainAxiom(xsdDateTime, dateTimeInterval));

        // Range:       xsd:dateTime
        axioms.add(df.getOWLDataPropertyRangeAxiom(xsdDateTime, new OWLDatatypeImpl(XSDVocabulary.DATE_TIME.getIRI())));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:year
     *
     * 4.2.57 year
     *
     * Property:    time:year
     * Definition:  Year position in a calendar-clock system. The range of this property is not specified, so can be
     *              replaced by any specific representation of a calendar year from any calendar.
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDateTimeDescription
     */
    public static Set<OWLAxiom> getYearAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDateTimeDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(year, generalDateTimeDescription));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:years
     *
     * 4.2.58 years duration
     *
     * Property:    time:years
     * Definition:  length of, or element of the length of, a temporal extent expressed in years
     * Instance of: owl:DatatypeProperty
     * Domain:      time:GeneralDurationDescription
     * Range:       xsd:decimal
     */
    public static Set<OWLAxiom> getYearsAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Domain:      time:GeneralDurationDescription
        axioms.add(df.getOWLDataPropertyDomainAxiom(years, generalDurationDescription));

        // Range:       xsd:decimal
        axioms.add(df.getOWLDataPropertyRangeAxiom(years, new OWLDatatypeImpl(XSDVocabulary.DECIMAL.getIRI())));

        return axioms;
    }


    /**
     * https://www.w3.org/TR/owl-time/#time:generalDay
     *
     * 4.3.1 generalDay
     *
     * Class:       time:generalDay
     * Definition:  Day of month - formulated as a text string with a pattern constraint to reproduce the same lexical
     *              form as xsd:gDay, except that values up to 99 are permitted, in order to support calendars with
     *              more than 31 days in a month. Note that the value-space is not defined, so a generic OWL2 processor
     *              cannot compute ordering relationships of values of this type.
     * Instance of: rdfs:Datatype
     * Subclass of: owl:onDatatype xsd:string ;
     *                owl:withRestrictions (
     *                  [
     *                    xsd:pattern "---(0[1-9]|[1-9][0-9])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?"^^xsd:string ;
     *                  ]
     *                )
     */
    public static Set<OWLAxiom> getGeneralDayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: owl:onDatatype xsd:string ;
        //                owl:withRestrictions (
        //                  [
        //                    xsd:pattern "---(0[1-9]|[1-9][0-9])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?"^^xsd:string ;
        //                  ]
        //                )
        OWLFacetRestriction fr = df.getOWLFacetRestriction(
                OWLFacet.PATTERN,
                df.getOWLLiteral(
                        "---(0[1-9]|[1-9][0-9])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?",
                        OWL2Datatype.XSD_STRING));
        OWLDatatypeRestriction dtr = df.getOWLDatatypeRestriction(
                new OWLDatatypeImpl(XSDVocabulary.STRING.getIRI()),
                Sets.newHashSet(fr));
        axioms.add(df.getOWLDatatypeDefinitionAxiom(generalDay, dtr));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:generalMonth
     *
     * 4.3.2 generalMonth
     *
     * Class:  time:generalMonth
     * Definition:  Month of year - formulated as a text string with a pattern constraint to reproduce the same lexical
     *              form as xsd:gMonth, except that values up to 20 are permitted, in order to support calendars with
     *              more than 12 months in the year. Note that the value-space is not defined, so a generic OWL2
     *              processor cannot compute ordering relationships of values of this type.
     * Instance of: rdfs:Datatype
     * Subclass of: owl:onDatatype xsd:string ;
     *                owl:withRestrictions (
     *                  [
     *                    xsd:pattern "--(0[1-9]|1[0-9]|20)(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?"^^xsd:string ;
     *                  ]
     *                )
     */
    public static Set<OWLAxiom> getGeneralMonthAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: owl:onDatatype xsd:string ;
        //                owl:withRestrictions (
        //                  [
        //                    xsd:pattern "--(0[1-9]|1[0-9]|20)(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?"^^xsd:string ;
        //                  ]
        //                )
        OWLFacetRestriction fr = df.getOWLFacetRestriction(
                OWLFacet.PATTERN,
                df.getOWLLiteral(
                        "--(0[1-9]|1[0-9]|20)(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?",
                        OWL2Datatype.XSD_STRING));
        OWLDatatypeRestriction dtr = df.getOWLDatatypeRestriction(
                new OWLDatatypeImpl(XSDVocabulary.STRING.getIRI()),
                Sets.newHashSet(fr));
        axioms.add(df.getOWLDatatypeDefinitionAxiom(generalMonth, dtr));

        return axioms;
    }

    /**
     * https://www.w3.org/TR/owl-time/#time:generalYear
     *
     * 4.3.3 generalYear
     *
     * Class:  time:generalYear
     * Definition:  Year number - formulated as a text string with a pattern constraint to reproduce the same lexical
     *              form as xsd:gYear, but not restricted to values from the Gregorian calendar. Note that the
     *              value-space is not defined, so a generic OWL2 processor cannot compute ordering relationships of
     *              values of this type.
     * Instance of: rdfs:Datatype
     * Subclass of: owl:onDatatype xsd:string ;
     *                owl:withRestrictions (
     *                  [
     *                    xsd:pattern "-?([1-9][0-9]{3,}|0[0-9]{3})(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?"^^xsd:string ;
     *                  ]
     *                )
     */
    public static Set<OWLAxiom> getGeneralYearAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // Subclass of: owl:onDatatype xsd:string ;
        //                owl:withRestrictions (
        //                  [
        //                    xsd:pattern "-?([1-9][0-9]{3,}|0[0-9]{3})(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?"^^xsd:string ;
        //                  ]
        //                )
        OWLFacetRestriction fr = df.getOWLFacetRestriction(
                OWLFacet.PATTERN,
                df.getOWLLiteral(
                        "-?([1-9][0-9]{3,}|0[0-9]{3})(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?",
                        OWL2Datatype.XSD_STRING));
        OWLDatatypeRestriction dtr = df.getOWLDatatypeRestriction(
                new OWLDatatypeImpl(XSDVocabulary.STRING.getIRI()),
                Sets.newHashSet(fr));
        axioms.add(df.getOWLDatatypeDefinitionAxiom(generalYear, dtr));

        return axioms;
    }

    public static Set<OWLAxiom> getFridayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:Friday a time:DayOfWeek
        axioms.add(df.getOWLClassAssertionAxiom(dayOfWeek, friday));

        return axioms;
    }

    public static Set<OWLAxiom> getMondayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:Monday a time:DayOfWeek
        axioms.add(df.getOWLClassAssertionAxiom(dayOfWeek, monday));
        return axioms;
    }

    public static Set<OWLAxiom> getSaturdayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:Saturday a time:DayOfWeek
        axioms.add(df.getOWLClassAssertionAxiom(dayOfWeek, saturday));

        return axioms;
    }

    public static Set<OWLAxiom> getSundayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:Sunday a time:DayOfWeek
        axioms.add(df.getOWLClassAssertionAxiom(dayOfWeek, sunday));

        return axioms;
    }

    public static Set<OWLAxiom> getThursdayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:Thursday a time:DayOfWeek
        axioms.add(df.getOWLClassAssertionAxiom(dayOfWeek, thursday));

        return axioms;
    }

    public static Set<OWLAxiom> getTuesdayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:Tuesday a time:DayOfWeek
        axioms.add(df.getOWLClassAssertionAxiom(dayOfWeek, tuesday));

        return axioms;
    }

    public static Set<OWLAxiom> getWednesdayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:Wednesday a time:DayOfWeek
        axioms.add(df.getOWLClassAssertionAxiom(dayOfWeek, wednesday));

        return axioms;
    }

    public static Set<OWLAxiom> getAprilAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:April a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, april));

        return axioms;
    }

    public static Set<OWLAxiom> getAugustAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:August a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, august));

        return axioms;
    }

    public static Set<OWLAxiom> getDecemberAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:December a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, december));

        return axioms;
    }

    public static Set<OWLAxiom> getFebruaryAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:February a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, february));

        return axioms;
    }

    public static Set<OWLAxiom> getJanuaryAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:January a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, january));

        return axioms;
    }

    public static Set<OWLAxiom> getJulyAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg: a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, july));

        return axioms;
    }

    public static Set<OWLAxiom> getJuneAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:June a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, june));

        return axioms;
    }

    public static Set<OWLAxiom> getMarchAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:March a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, march));

        return axioms;
    }

    public static Set<OWLAxiom> getMayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:May a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, may));

        return axioms;
    }

    public static Set<OWLAxiom> getNovemberAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:November a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, november));

        return axioms;
    }

    public static Set<OWLAxiom> getOctoberAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:October a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, october));

        return axioms;
    }

    public static Set<OWLAxiom> getSeptemberAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // greg:September a time:MonthOfYear
        axioms.add(df.getOWLClassAssertionAxiom(monthOfYear, september));

        return axioms;
    }

    /**
     * FIXME: The original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains the following axioms:
     *   :days "1"^^xsd:decimal ;
     *   :hours "0"^^xsd:decimal ;
     *   :minutes "0"^^xsd:decimal ;
     *   :months "0"^^xsd:decimal ;
     *   :seconds "0"^^xsd:decimal ;
     *   :weeks "0"^^xsd:decimal ;
     *   :years "0"^^xsd:decimal ;
     */
    public static Set<OWLAxiom> getUnitDayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:unitDay a time:TemporalUnit
        axioms.add(df.getOWLClassAssertionAxiom(temporalUnit, unitDay));

        return axioms;
    }

    /**
     * FIXME: The original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains the following axioms:
     *   :days "0"^^xsd:decimal ;
     *   :hours "1"^^xsd:decimal ;
     *   :minutes "0"^^xsd:decimal ;
     *   :months "0"^^xsd:decimal ;
     *   :seconds "0"^^xsd:decimal ;
     *   :weeks "0"^^xsd:decimal ;
     *   :years "0"^^xsd:decimal ;
     */
    public static Set<OWLAxiom> getUnitHourAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:unitHour a time:TemporalUnit
        axioms.add(df.getOWLClassAssertionAxiom(temporalUnit, unitHour));

        return axioms;
    }

    /**
     * FIXME: The original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains the following axioms:
     *   :days "0"^^xsd:decimal ;
     *   :hours "0"^^xsd:decimal ;
     *   :minutes "1"^^xsd:decimal ;
     *   :months "0"^^xsd:decimal ;
     *   :seconds "0"^^xsd:decimal ;
     *   :weeks "0"^^xsd:decimal ;
     *   :years "0"^^xsd:decimal ;
     */
    public static Set<OWLAxiom> getUnitMinuteAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:unitMinute a time:TemporalUnit
        axioms.add(df.getOWLClassAssertionAxiom(temporalUnit, unitMinute));

        return axioms;
    }

    /**
     * FIXME: The original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains the following axioms:
     *   :days "0"^^xsd:decimal ;
     *   :hours "0"^^xsd:decimal ;
     *   :minutes "0"^^xsd:decimal ;
     *   :months "1"^^xsd:decimal ;
     *   :seconds "0"^^xsd:decimal ;
     *   :weeks "0"^^xsd:decimal ;
     *   :years "0"^^xsd:decimal ;
     */
    public static Set<OWLAxiom> getUnitMonthAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:unitMonth a time:TemporalUnit
        axioms.add(df.getOWLClassAssertionAxiom(temporalUnit, unitMonth));

        return axioms;
    }

    /**
     * FIXME: The original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains the following axioms:
     *   :days "0"^^xsd:decimal ;
     *   :hours "0"^^xsd:decimal ;
     *   :minutes "0"^^xsd:decimal ;
     *   :months "0"^^xsd:decimal ;
     *   :seconds "1"^^xsd:decimal ;
     *   :weeks "0"^^xsd:decimal ;
     *   :years "0"^^xsd:decimal ;
     */
    public static Set<OWLAxiom> getUnitSecondAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:unitSecond a time:TemporalUnit
        axioms.add(df.getOWLClassAssertionAxiom(temporalUnit, unitSecond));

        return axioms;
    }

    /**
     * FIXME: The original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains the following axioms:
     *     :days "0"^^xsd:decimal ;
     *     :hours "0"^^xsd:decimal ;
     *     :minutes "0"^^xsd:decimal ;
     *     :months "0"^^xsd:decimal ;
     *     :seconds "0"^^xsd:decimal ;
     *     :weeks "1"^^xsd:decimal ;
     *     :years "0"^^xsd:decimal ;
     */
    public static Set<OWLAxiom> getUnitWeekAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:unitWeek a time:TemporalUnit
        axioms.add(df.getOWLClassAssertionAxiom(temporalUnit, unitWeek));

        return axioms;
    }

    /**
     * FIXME: The original ontology at https://raw.githubusercontent.com/w3c/sdw/gh-pages/time/rdf/time.ttl also contains the following axioms:
     *   :days "0"^^xsd:decimal ;
     *   :hours "0"^^xsd:decimal ;
     *   :minutes "0"^^xsd:decimal ;
     *   :months "0"^^xsd:decimal ;
     *   :seconds "0"^^xsd:decimal ;
     *   :weeks "0"^^xsd:decimal ;
     *   :years "1"^^xsd:decimal ;
     */
    public static Set<OWLAxiom> getUnitYearAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        // time:unitYear a time:TemporalUnit
        axioms.add(df.getOWLClassAssertionAxiom(temporalUnit, unitYear));

        return axioms;
    }
    /*

     */
    public static Set<OWLAxiom> getTimeOntologyAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.addAll(getDateTimeDescriptionAxioms());
        axioms.addAll(getDateTimeIntervalAxioms());
        axioms.addAll(getDayOfWeekAxioms());
        axioms.addAll(getDurationAxioms());
        axioms.addAll(getDurationDescriptionAxioms());
        axioms.addAll(getGeneralDateTimeDescriptionAxioms());
        axioms.addAll(getGeneralDurationDescriptionAxioms());
        axioms.addAll(getInstantAxioms());
        axioms.addAll(getIntervalAxioms());
        axioms.addAll(getMonthOfYearAxioms());
        axioms.addAll(getProperIntervalAxioms());
        axioms.addAll(getTemporalDurationAxioms());
        axioms.addAll(getTemporalEntityAxioms());
        axioms.addAll(getTemporalPositionAxioms());
        axioms.addAll(getTemporalUnitAxioms());
        axioms.addAll(getTimePositionAxioms());
        axioms.addAll(getTimeZoneAxioms());
        axioms.addAll(getTRSAxioms());

        axioms.addAll(getAfterAxioms());
        axioms.addAll(getBeforeAxioms());
        axioms.addAll(getDayAxioms());
        axioms.addAll(getDayOfWeekPredicateAxioms());
        axioms.addAll(getDayOfYearAxioms());
        axioms.addAll(getDaysAxioms());
        axioms.addAll(getHasBeginningAxioms());
        axioms.addAll(getHasDateTimeDescriptionAxioms());
        axioms.addAll(getHasDurationAxioms());
        axioms.addAll(getHasDurationDescriptionAxioms());
        axioms.addAll(getHasEndAxioms());
        axioms.addAll(getHasTemporalDurationAxioms());
        axioms.addAll(getHasTimeAxioms());
        axioms.addAll(getHasTRSAxioms());
        axioms.addAll(getHasXSDDurationAxioms());
        axioms.addAll(getHourAxioms());
        axioms.addAll(getHoursAxioms());
        axioms.addAll(getInDateTimeAxioms());
        axioms.addAll(getInsideAxioms());
        axioms.addAll(getInTemporalPositionAxioms());
        axioms.addAll(getIntervalAfterAxioms());
        axioms.addAll(getIntervalBeforeAxioms());
        axioms.addAll(getIntervalContainsAxioms());
        axioms.addAll(getIntervalDisjointAxioms());
        axioms.addAll(getIntervalDuringAxioms());
        axioms.addAll(getIntervalEqualsAxioms());
        axioms.addAll(getIntervalFinishedByAxioms());
        axioms.addAll(getIntervalFinishesAxioms());
        axioms.addAll(getIntervalInAxioms());
        axioms.addAll(getIntervalMeetsAxioms());
        axioms.addAll(getIntervalMetByAxioms());
        axioms.addAll(getIntervalOverlappedByAxioms());
        axioms.addAll(getIntervalOverlapsAxioms());
        axioms.addAll(getIntervalStartedByAxioms());
        axioms.addAll(getIntervalStartsAxioms());
        axioms.addAll(getInTimePositionAxioms());
        axioms.addAll(getInXSDDateAxioms());
        axioms.addAll(getInXSDDateTimeAxioms());
        axioms.addAll(getInXSDDateTimeStampAxioms());
        axioms.addAll(getInXSDgYearAxioms());
        axioms.addAll(getInXSDgYearMonthAxioms());
        axioms.addAll(getMinuteAxioms());
        axioms.addAll(getMinutesAxioms());
        axioms.addAll(getMonthAxioms());
        axioms.addAll(getMonthOfYearPredicateAxioms());
        axioms.addAll(getMonthsAxioms());
        axioms.addAll(getNominalPositionAxioms());
        axioms.addAll(getNumericDurationAxioms());
        axioms.addAll(getNumericPositionAxioms());
        axioms.addAll(getSecondAxioms());
        axioms.addAll(getSecondsAxioms());
        axioms.addAll(getTimeZonePredicateAxioms());
        axioms.addAll(getUnitTypeAxioms());
        axioms.addAll(getWeekAxioms());
        axioms.addAll(getWeeksAxioms());
        axioms.addAll(getXSDDateTimeAxioms());
        axioms.addAll(getYearAxioms());
        axioms.addAll(getYearsAxioms());

        axioms.addAll(getGeneralDayAxioms());
        axioms.addAll(getGeneralMonthAxioms());
        axioms.addAll(getGeneralYearAxioms());

        axioms.addAll(getFridayAxioms());
        axioms.addAll(getMondayAxioms());
        axioms.addAll(getSaturdayAxioms());
        axioms.addAll(getSundayAxioms());
        axioms.addAll(getThursdayAxioms());
        axioms.addAll(getTuesdayAxioms());
        axioms.addAll(getWednesdayAxioms());
        axioms.addAll(getAprilAxioms());
        axioms.addAll(getAugustAxioms());
        axioms.addAll(getDecemberAxioms());
        axioms.addAll(getFebruaryAxioms());
        axioms.addAll(getJanuaryAxioms());
        axioms.addAll(getJulyAxioms());
        axioms.addAll(getJuneAxioms());
        axioms.addAll(getMarchAxioms());
        axioms.addAll(getMayAxioms());
        axioms.addAll(getNovemberAxioms());
        axioms.addAll(getOctoberAxioms());
        axioms.addAll(getSeptemberAxioms());
        axioms.addAll(getUnitDayAxioms());
        axioms.addAll(getUnitHourAxioms());
        axioms.addAll(getUnitMinuteAxioms());
        axioms.addAll(getUnitMonthAxioms());
        axioms.addAll(getUnitSecondAxioms());
        axioms.addAll(getUnitWeekAxioms());
        axioms.addAll(getUnitYearAxioms());
        // TODO: Add individual axioms

        return axioms;
    }

    public static OWLOntology getTimeOntology() throws OWLOntologyCreationException {
        OWLOntology ont = manager.createOntology();

        manager.addAxioms(ont, getTimeOntologyAxioms());

        return ont;
    }

    public static void main(String[] args) {
        String filePath = "/tmp/owl-time.owl";
        OWLOntology ont = null;
        try {
            ont = getTimeOntology();
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        };
        try {
//            manager.saveOntology(ont, new ManchesterSyntaxDocumentFormat(), new FileOutputStream(new File(filePath)));
//            manager.saveOntology(ont, new RDFXMLDocumentFormat(), new FileOutputStream(new File(filePath)));
            manager.saveOntology(ont, new TurtleDocumentFormat(), new FileOutputStream(new File(filePath)));
        } catch (OWLOntologyStorageException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
