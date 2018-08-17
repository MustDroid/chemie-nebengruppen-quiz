package com.example.android.chemienebengruppenquiz;

import java.util.Arrays;

/**
 * Created by Emoke Hajdu on 6/8/2018.
 */

public class QuestionDatabase {
    public static IQuestion[] allQuestions = new IQuestion[]
    {
        new MultiChoiceQuestion("Welche Farben besitzen die folgende Farbpigmente? Kreuzen Sie die falsche Anwort an!",
                "CdS-gelb", "TiO2-braun", "Cr2O3-grün", "CoO-grün",
                Arrays.asList(false, true, false, true)),

        new MultiChoiceQuestion("Welche Elemente sind radioaktiv?",
                "Tc", "Pm", "La", "Pb",
                Arrays.asList(true, true, false, false)),

        new MultiChoiceQuestion("Welche chemische Eigenschaften beschreiben die Metalle?",
                "Verbindungen in wenigen Oxidationsstufen bekannt", "variationsreiche Komplexchemie", "Clusterbildung", "Farbigkeit hervorgerufen durch kovalente Bindungen",
                Arrays.asList(false, true, true, false)),

        new MultiChoiceQuestion("Welche der folgenden Aussagen treffen für Paramagnetismus zu?",
                "Materie mit mindestens einem ungepaarten Elektron", "magnetisches Moment orientiert sich am äusseren Magnetfeld im Sinne einer Abschwächung", "Temperaturunabhängig", "Magnetische Moment des ungepaarten Elektrons ist 10-1000fach stärker als induziertes Magnetfeld",
                Arrays.asList(true, false, false, true)),

        new SingleChoiceQuestion("Welche der folgenden Aussagen treffen für LMCT zu?",
                "Oxidation des Metallzentrum unter Reduktion des Liganden", "bevorzugt bei Metallen in niedrigen Oxidationsstufen", "bevorzugt bei leicht oxidierbaren Liganden", "Beispiele:Berliner-Blau,Pb3O4",
                'C'),

        new SingleChoiceQuestion("Welche der folgenden Aussagen treffen für die oktaedrische Ligandenaufspaltung zu?",
                "Die Orbitale dx2-y2 energetisch angehoben,dxy,dyz,dxz energetisch abgesenkt ", "4-5 Aufspaltung", "7 Punktladungen ordnen sich im Form eines Oktaeders um das Zentralatom an", "Die Elektronanordnungen High- und Low spin gibts beim oktaedrischen Kristallfeld nur bei d3,d4,d5,d6,d7",
                'A'),

        new SingleChoiceQuestion("Welche der folgenden Aussagen treffen für die Trans-Effekt zu?",
                "die Bildung des Substitutionsprodukts wird erschwert im Sinne einer Labilisierung der Abgangs-Gruppe", "Trans-Effekt ist ein kinetischer Effekt", "die Bildung des Substitutionsprodukts wird durch den schwach gebundenen Liganden erleichtert im Sinne einer Labilisierung der Abgangs-Gruppe", "Temperaturabhängig",
                'B'),

        new EditQuestion("Welches Element hat die höchste Dichte aller Elemente?",
                "Iridium"),

        new EditQuestion("Welche Oxidationsstufe ist die stabilste von Nickel?",
                "2"),

        new EditQuestion("Welches Element hat die positivstes Normalpotential aller Elemente?",
                "Gold"),

        new EditQuestion("Welche Oxidationsstufe ist die wichtigste von Cobalt?",
                "2"),
     };


}
