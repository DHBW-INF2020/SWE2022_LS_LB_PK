
# Test Input Handler


## Function getSatellitesFromInputFormat

### Funktion: speichert überlieferte Transponder in zugehörigem Satelliten, die Satelliten werden in einem Array gespeichert
### Eingabe: ArrayList&lt;InputTransponder&gt; inputTransponders
### Rückgabe: ArrayList&lt;Node&gt;

----
#### inputTransponders: Äquivalenzklassen gültiger Werte
1. inputTransponders<sub>empty</sub> = [ ];
2. inputTransponders<sub>one</sub> = [ Transponder ];
3. inputTranponders<sub>multiple</sub> = [ Transponder1, Transponder2, Transponder3, Transponder4, ... ]

#### inputTransponders: ungültige Werte
1. inputTransponders<sub>null</sub> = null;



| Testfall | Äquivalenzklasse |  Name/Wert der Testvariable | Soll-Ausgabe | Ist-Ausgabe |
| ----     |    ----          | ----    | ---- | ---- |
| T1     | inputTransponders<sub>empty</sub>| [ ] | expectedEmptySatellite | actual |
| T2     | inputTransponders<sub>one</sub>| oneInputTransponder | expectedOneSatellite | actual |
| T3     | inputTransponders<sub>multiple</sub>| twoInputTransponder | expectedTwoSatellites | actual |
| T4     | inputTransponders<sub>null</sub>| null | Exception | actual |



## Function parseJsonToTree

### Funktion: liest die Eingabedatei ein und konvertiert die JSON Datei in eine Liste von Transpondern, mit der Liste der Transponder als Übergabewert wird dann die Funktion getSatellitesFromInputFormat aufgerufen
### Eingabe: String filename
### Rückgabe: Node (Root)

----
#### filename: Äquivalenzklassen gültiger Werte
1. filename<sub>empty</sub> = "";
2. filename<sub>correct</sub> = input.json;

#### inputTransponders: ungültige Werte
1. filename<sub>null</sub> = null;
2. filename<sub>notExist</sub> = input.xml;


| Testfall | Äquivalenzklasse |  Name/Wert der Testvariable | Soll-Ausgabe | Ist-Ausgabe |
| ----     |    ----          | ----    | ---- | ---- |
| T1     | filename<sub>empty</sub>| emptyFilename = "" | Exception | no Exception* |
| T2     | filename<sub>correct</sub>| correctFilename = "input.json" | no Exception | no Exception |
| T3     | filename<sub>null</sub>| nullFilename = null | Exception | no Exception* |
| T4     | filename<sub>notExist</sub>| notExistFilename ="input.xml" | Exception | no Exception* |

* Die Funktion arbeitet mit try/catch, bei den Fällen T1, T3, T4 wo eine Exception geworfen werden soll wurde im Test eine try/catch so drum rum gebaut, dass diese abgefangen wird und eine Exception geworfen wird, wenn in der try/catch keine Exception abgefangen werden kann.