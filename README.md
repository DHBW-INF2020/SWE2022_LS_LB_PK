# SWE Satelliten Management Aufgabe

Von: Lea Soffel, Pascal Kraft und Lukas Benner

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
   java -jar target\SatelliteManagement-1.0.jar
    ```
2. Ausführen mit Maven:
   ```bash
   mvn exec:java
   ```