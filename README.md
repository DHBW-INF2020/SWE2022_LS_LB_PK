[![Java CI with Maven](https://github.com/DHBW-INF2020/SWE2022_LS_LB_PK/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/DHBW-INF2020/SWE2022_LS_LB_PK/actions/workflows/maven.yml)

# SWE Satelliten Management Aufgabe

Von: Lea Soffel, Pascal Kraft und Lukas Benner

Das Repository ist auch im [GitHub](https://github.com/DHBW-INF2020/SWE2022_LS_LB_PK) zu finden.

## Entwurf

Alle Diagramme sind im Ordner UML-Diagramme zu finden.
Es wurde erstellt:
1. Architektur Diagramm
2. Komponenten Diagramm
3. Aktivitäts Diagramm
4. Klassen Diagramm

## Kompilieren und ausführen

### Kompilieren
1. [Maven](https://maven.apache.org/download.cgi) installieren
2. Im Verzeichnis des Repositories ausführen:
    ```bash
    mvn clean compile assembly:single
    ```
   Im Verzeichnis "target" ist jetzt eine SatteliteManagement-1.0.jar zu finden.

### Ausführen
1. Ausführen der jar mit:
    ```bash
   java -jar .\target\SatelliteManagement-1.0.jar -a ch-sat -f json -o output.json -i input.json
    ```

2. Ausführen mit Maven:
   ```bash
   mvn exec:java -D exec.args="-a ch-sat -f xml -o output.xml -i input.json"
   ```
3. Parameter:
    - `-a/--aggregate` &#8594; Wählen zwischen ch-sat und sat-trans
    - `-f/--format` &#8594; Wählen zwischen json und xml
    - `-o/--output` &#8594; Wählen in welcher Datei der Output gespeichert werden soll (Dateiendung muss passen!)
    - `-i/--input` &#8594; Pfad zur Eingabedatei

## Generieren der Dokumentation durch Javadocs
Dokumentation der App:
```bash
mvn javadoc:jar
```

Dokumentation der Tests:
```bash
mvn javadoc:test-jar
```

Das Ergebnis liegt jeweils in `documentation`