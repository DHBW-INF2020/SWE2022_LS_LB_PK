
# Test Input Handler


## Function getSatellitesFromInputFormat

### Funktion: speichert überlieferte Transponder in zugehörigem Satelliten
### Eingabe: ArrayList&lt;InputTransponder&gt; inputTransponders
### Rückgabe: ArrayList&lt;Node&gt;

----
#### inputTransponders: Äquivalenzklassen gültiger Werte
1. inputTransponders<sub>empty</sub> = [ ];
2. inputTransponders<sub>one</sub> = [ Transponder ];
3. inputTranponders<sub>multiple</sub> = [ Transponder1, Transponder2, Transponder3, Transponder4, ... ]

#### inputTransponders: ungültige Werte
1. inputTransponders<sub>null</sub> = null;



| Testfall | Äquivalenzklasse |  Wert der Testvariable | Soll-Ausgabe | Ist-Ausgabe |
| ----     |    ----          | ----    | ---- | ---- |
| T1     | inputTransponders<sub>empty</sub>| [ ] | expectedEmptySatellite | actual |
| T2     | inputTransponders<sub>one</sub>| oneInputTransponder | expectedOneSatellite | actual |
| T3     | inputTransponders<sub>multiple</sub>| twoInputTransponder | expectedTwoSatellites | actual |
| T4     | inputTransponders<sub>null</sub>| null | Exception | actual |

