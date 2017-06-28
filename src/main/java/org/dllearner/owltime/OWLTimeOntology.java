package org.dllearner.owltime;

import java.util.HashSet;
import java.util.Set;

import org.dllearner.owltime.vocab.OWLTime;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
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
    public static final OWLDataProperty dayOfWeekPredicate = df.getOWLDataProperty(
            OWLTime.TIME_DAY_OF_WEEK_PREDICATE.getIRI());
    public static final OWLDataProperty monthOfYearPredicate = df.getOWLDataProperty(
            OWLTime.TIME_MONTH_OF_YEAR_PREDICATE.getIRI());
    public static final OWLDataProperty numericPosition = df.getOWLDataProperty(OWLTime.TIME_NUMERIC_POSITION.getIRI());
    public static final OWLDataProperty nominalPosition = df.getOWLDataProperty(OWLTime.TIME_NOMINAL_POSITION.getIRI());

    // individuals
    private static final OWLIndividual gregorianCalendar = df.getOWLNamedIndividual(
            IRI.create("http://www.opengis.net/def/uom/ISO-8601/0/Gregorian"));
    public static final OWLIndividual unitMonth = df.getOWLNamedIndividual(OWLTime.TIME_UNIT_MONTH.getIRI());

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
        axioms.add(df.getOWLSubClassOfAxiom(durationDescription, generalDateTimeDescription));

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
        OWLDataMaxCardinality max1DayOfWeek = df.getOWLDataMaxCardinality(1, dayOfWeekPredicate);
        axioms.add(df.getOWLSubClassOfAxiom(generalDateTimeDescription, max1DayOfWeek));

        // Subclass of: time:monthOfYear max 1
        OWLDataMaxCardinality max1MonthOfYear = df.getOWLDataMaxCardinality(1, monthOfYearPredicate);
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

        axioms.add(df.getOWLDisjointUnionAxiom(temporalEntity, Sets.newHashSet(instant,  interval)));

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

        // TODO: Add property axioms
        // TODO: Add individual axioms

        return axioms;
    }

    public static OWLOntology getTimeOntology() throws OWLOntologyCreationException {
        OWLOntology ont = manager.createOntology();

        manager.addAxioms(ont, getTimeOntologyAxioms());

        return ont;
    }
}
