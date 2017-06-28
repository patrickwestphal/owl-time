package org.dllearner.owltime;

import java.util.HashSet;
import java.util.Set;

import org.dllearner.owltime.vocab.Gregorian;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.owlapi.vocab.XSDVocabulary;

public class GregorianOntology {
    private static OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
    private static OWLDataFactory df = manager.getOWLDataFactory();

    public static OWLIndividual january = df.getOWLNamedIndividual(Gregorian.GREG_JANUARY.getIRI());
    public static OWLIndividual february = df.getOWLNamedIndividual(Gregorian.GREG_FEBRUARY.getIRI());
    public static OWLIndividual march = df.getOWLNamedIndividual(Gregorian.GREG_MARCH.getIRI());
    public static OWLIndividual april = df.getOWLNamedIndividual(Gregorian.GREG_APRIL.getIRI());
    public static OWLIndividual may = df.getOWLNamedIndividual(Gregorian.GREG_MAY.getIRI());
    public static OWLIndividual june = df.getOWLNamedIndividual(Gregorian.GREG_JUNE.getIRI());
    public static OWLIndividual july = df.getOWLNamedIndividual(Gregorian.GREG_JULY.getIRI());
    public static OWLIndividual august = df.getOWLNamedIndividual(Gregorian.GREG_AUGUST.getIRI());
    public static OWLIndividual september = df.getOWLNamedIndividual(Gregorian.GREG_SEPTEMBER.getIRI());
    public static OWLIndividual october = df.getOWLNamedIndividual(Gregorian.GREG_October.getIRI());
    public static OWLIndividual november = df.getOWLNamedIndividual(Gregorian.GREG_NOVEMBER.getIRI());
    public static OWLIndividual december = df.getOWLNamedIndividual(Gregorian.GREG_DECEMBER.getIRI());

    /**
     * greg:January
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "January" ;
     *   skos:historyNote """A _class_ with the local-name January was present in the 2006 version of OWL-Time.
     * It was presented as an example of how DateTimeDescription could be specialized.
     * In the 2017 version of OWL-Time that class is deprecated, but this individual provided instead, in a separate namespace. """ ;
     *   skos:prefLabel "/=20@L"@ru ;
     *   skos:prefLabel "1^H"@ja ;
     *   skos:prefLabel "1^H"@zh ;
     *   skos:prefLabel "Enero"@es ;
     *   skos:prefLabel "Gennaio"@it ;
     *   skos:prefLabel "JF'J1 (4G1)"@ar ;
     *   skos:prefLabel "Janeiro"@pt ;
     *   skos:prefLabel "Januar"@de ;
     *   skos:prefLabel "Januari"@nl ;
     *   skos:prefLabel "January"@en ;
     *   skos:prefLabel "Janvier"@fr ;
     *   skos:prefLabel "StyczeD"@pl ;
     *   time:month "--01"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getJanuaryAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, january));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("January"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(january.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--01", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, january, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, january, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:February
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "February"@en ;
     *   skos:prefLabel "2月"@ja ;
     *   skos:prefLabel "2月"@zh ;
     *   skos:prefLabel "Febbraio"@it ;
     *   skos:prefLabel "Febrero"@es ;
     *   skos:prefLabel "Februar"@de ;
     *   skos:prefLabel "Februari"@nl ;
     *   skos:prefLabel "February"@en ;
     *   skos:prefLabel "Fevereiro"@pt ;
     *   skos:prefLabel "Février"@fr ;
     *   skos:prefLabel "Luty"@pl ;
     *   skos:prefLabel "Февраль"@ru ;
     *   skos:prefLabel "ﻒﺑﺭﺎﻳﺭ"@ar ;
     *   time:month "--02"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getFebruaryAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, february));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("February"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(february.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--02", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, february, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, february, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:March
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "March"@en ;
     *   skos:prefLabel "3月"@ja ;
     *   skos:prefLabel "3月"@zh ;
     *   skos:prefLabel "Maart"@nl ;
     *   skos:prefLabel "March"@en ;
     *   skos:prefLabel "Mars (mois)"@fr ;
     *   skos:prefLabel "Marzec"@pl ;
     *   skos:prefLabel "Marzo"@es ;
     *   skos:prefLabel "Marzo"@it ;
     *   skos:prefLabel "Março"@pt ;
     *   skos:prefLabel "März"@de ;
     *   skos:prefLabel "Март"@ru ;
     *   skos:prefLabel "ﻡﺍﺮﺳ"@ar ;
     *   time:month "--03"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getMarchAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, march));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("March"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(march.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--03", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, march, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, march, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:April
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "April"@en ;
     *   rdfs:subClassOf [
     *       rdf:type owl:Restriction ;
     *       owl:hasValue time:unitMonth ;
     *       owl:onProperty time:unitType ;
     *   ] ;
     *   skos:prefLabel "4月"@ja ;
     *   skos:prefLabel "4月"@zh ;
     *   skos:prefLabel "Abril"@es ;
     *   skos:prefLabel "Abril"@pt ;
     *   skos:prefLabel "April"@de ;
     *   skos:prefLabel "April"@en ;
     *   skos:prefLabel "April"@nl ;
     *   skos:prefLabel "Aprile"@it ;
     *   skos:prefLabel "Avril"@fr ;
     *   skos:prefLabel "Kwiecień"@pl ;
     *   skos:prefLabel "Апрель"@ru ;
     *   skos:prefLabel "ﺄﺑﺮﻴﻟ"@ar ;
     *   time:month "--04"^^xsd:gMonth ;
     *   time:unitType time:unitMonth .
     */
    public static Set<OWLAxiom> getAprilAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, april));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("April"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(april.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--04", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, april, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, april, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:May
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "May"@en ;
     *   skos:prefLabel "5月"@ja ;
     *   skos:prefLabel "5月"@zh ;
     *   skos:prefLabel "Maggio"@it ;
     *   skos:prefLabel "Mai"@de ;
     *   skos:prefLabel "Mai"@fr ;
     *   skos:prefLabel "Maio"@pt ;
     *   skos:prefLabel "Maj"@pl ;
     *   skos:prefLabel "May"@en ;
     *   skos:prefLabel "Mayo"@es ;
     *   skos:prefLabel "Mei"@nl ;
     *   skos:prefLabel "Май"@ru ;
     *   skos:prefLabel "ﻡﺎﻳﻭ"@ar ;
     *   time:month "--05"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getMayAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, may));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("May"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(may.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--05", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, may, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, may, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:June
     *  rdf:type time:MonthOfYear ;
     *  rdfs:label "June"@en ;
     *  skos:prefLabel "^XN=L"@ru ;
     *  skos:prefLabel "6^H"@ja ;
     *  skos:prefLabel "6^H"@zh ;
     *  skos:prefLabel "Czerwiec"@pl ;
     *  skos:prefLabel "Giugno"@it ;
     *  skos:prefLabel "JHFJH"@ar ;
     *  skos:prefLabel "Juin"@fr ;
     *  skos:prefLabel "June"@en ;
     *  skos:prefLabel "Junho"@pt ;
     *  skos:prefLabel "Juni"@de ;
     *  skos:prefLabel "Juni"@nl ;
     *  skos:prefLabel "Junio"@es ;
     *  time:month "--06"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getJuneAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, june));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("June"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(june.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--06", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, june, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, june, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:July
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "July"@en ;
     *   skos:prefLabel "^XN;L"@ru ;
     *   skos:prefLabel "7^H"@ja ;
     *   skos:prefLabel "7^H"@zh ;
     *   skos:prefLabel "JHDJH"@ar ;
     *   skos:prefLabel "Juillet"@fr ;
     *   skos:prefLabel "Julho"@pt ;
     *   skos:prefLabel "Juli"@de ;
     *   skos:prefLabel "Juli"@nl ;
     *   skos:prefLabel "Julio"@es ;
     *   skos:prefLabel "July"@en ;
     *   skos:prefLabel "Lipiec"@pl ;
     *   skos:prefLabel "Luglio"@it ;
     *   time:month "--07"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getJulyAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, july));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("July"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(july.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--07", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, june, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, july, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:August
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "August"@en ;
     *   skos:prefLabel "8月"@ja ;
     *   skos:prefLabel "8月"@zh ;
     *   skos:prefLabel "Agosto"@es ;
     *   skos:prefLabel "Agosto"@it ;
     *   skos:prefLabel "Agosto"@pt ;
     *   skos:prefLabel "Août"@fr ;
     *   skos:prefLabel "August"@de ;
     *   skos:prefLabel "August"@en ;
     *   skos:prefLabel "Augustus (maand)"@nl ;
     *   skos:prefLabel "Sierpień"@pl ;
     *   skos:prefLabel "Август"@ru ;
     *   skos:prefLabel "ﺄﻐﺴﻄﺳ"@ar ;
     *   time:month "--08"^^xsd:gMonth ;
     *   time:unitType time:unitMonth .
     */
    public static Set<OWLAxiom> getAugustAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, august));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("August"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(august.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--08", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, august, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, august, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:September
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "September"@en ;
     *   skos:prefLabel "9月"@ja ;
     *   skos:prefLabel "9月"@zh ;
     *   skos:prefLabel "September"@de ;
     *   skos:prefLabel "September"@en ;
     *   skos:prefLabel "September"@nl ;
     *   skos:prefLabel "Septembre"@fr ;
     *   skos:prefLabel "Septiembre"@es ;
     *   skos:prefLabel "Setembro"@pt ;
     *   skos:prefLabel "Settembre"@it ;
     *   skos:prefLabel "Wrzesień"@pl ;
     *   skos:prefLabel "Сентябрь"@ru ;
     *   skos:prefLabel "ﺲﺒﺘﻤﺑﺭ"@ar ;
     *   time:month "--09"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getSeptemberAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, september));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("September"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(september.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--09", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, september,gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, september, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:October
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "October"@en ;
     *   skos:prefLabel "10月"@ja ;
     *   skos:prefLabel "10月"@zh ;
     *   skos:prefLabel "October"@en ;
     *   skos:prefLabel "Octobre"@fr ;
     *   skos:prefLabel "Octubre"@es ;
     *   skos:prefLabel "Oktober"@de ;
     *   skos:prefLabel "Oktober"@nl ;
     *   skos:prefLabel "Ottobre"@it ;
     *   skos:prefLabel "Outubro"@pt ;
     *   skos:prefLabel "Październik"@pl ;
     *   skos:prefLabel "Октябрь"@ru ;
     *   skos:prefLabel "ﺄﻜﺗﻮﺑﺭ"@ar ;
     *   time:month "--10"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getOctoberAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, october));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("October"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(october.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--10", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, october, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, october, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:November
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "November"@en ;
     *   skos:prefLabel "11月"@ja ;
     *   skos:prefLabel "11月"@zh ;
     *   skos:prefLabel "Listopad"@pl ;
     *   skos:prefLabel "November"@de ;
     *   skos:prefLabel "November"@en ;
     *   skos:prefLabel "November"@nl ;
     *   skos:prefLabel "Novembre"@fr ;
     *   skos:prefLabel "Novembre"@it ;
     *   skos:prefLabel "Novembro"@pt ;
     *   skos:prefLabel "Noviembre"@es ;
     *   skos:prefLabel "Ноябрь"@ru ;
     *   skos:prefLabel "ﻥﻮﻔﻤﺑﺭ"@ar ;
     *   time:month "--11"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getNovemberAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, november));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("November"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(november.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--11", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, november, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, november, OWLTimeOntology.unitMonth));

        return axioms;
    }

    /**
     * greg:December
     *   rdf:type time:MonthOfYear ;
     *   rdfs:label "December"@en ;
     *   skos:prefLabel "12月"@ja ;
     *   skos:prefLabel "12月"@zh ;
     *   skos:prefLabel "December"@en ;
     *   skos:prefLabel "December"@nl ;
     *   skos:prefLabel "Dezember"@de ;
     *   skos:prefLabel "Dezembro"@pt ;
     *   skos:prefLabel "Dicembre"@it ;
     *   skos:prefLabel "Diciembre"@es ;
     *   skos:prefLabel "Décembre"@fr ;
     *   skos:prefLabel "Grudzień"@pl ;
     *   skos:prefLabel "Декабрь"@ru ;
     *   skos:prefLabel "ﺪﻴﺴﻤﺑﺭ"@ar ;
     *   time:month "--12"^^xsd:gMonth .
     */
    public static Set<OWLAxiom> getDecemberAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.add(df.getOWLClassAssertionAxiom(OWLTimeOntology.monthOfYear, december));

        OWLAnnotation labelAnnotation = df.getOWLAnnotation(df.getRDFSLabel(), df.getOWLLiteral("December"));
        axioms.add(df.getOWLAnnotationAssertionAxiom(december.asOWLNamedIndividual().getIRI(), labelAnnotation));

        OWLLiteral gMonthLiteral = df.getOWLLiteral("--12", OWL2Datatype.getDatatype(XSDVocabulary.G_MONTH.getIRI()));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(OWLTimeOntology.month, december, gMonthLiteral));

        axioms.add(df.getOWLObjectPropertyAssertionAxiom(OWLTimeOntology.unitType, december, OWLTimeOntology.unitMonth));

        return axioms;
    }

    public static Set<OWLAxiom> getGregorianOntologyAxioms() {
        Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();

        axioms.addAll(getJanuaryAxioms());
        axioms.addAll(getFebruaryAxioms());
        axioms.addAll(getMarchAxioms());
        axioms.addAll(getAprilAxioms());
        axioms.addAll(getMayAxioms());
        axioms.addAll(getJuneAxioms());
        axioms.addAll(getJulyAxioms());
        axioms.addAll(getAugustAxioms());
        axioms.addAll(getSeptemberAxioms());
        axioms.addAll(getOctoberAxioms());
        axioms.addAll(getNovemberAxioms());
        axioms.addAll(getDecemberAxioms());

        return axioms;
    }

    public static OWLOntology getGregorianOntology() throws OWLOntologyCreationException {
        OWLOntology ont = manager.createOntology();

        manager.addAxioms(ont, getGregorianOntologyAxioms());
        return ont;
    }
}
