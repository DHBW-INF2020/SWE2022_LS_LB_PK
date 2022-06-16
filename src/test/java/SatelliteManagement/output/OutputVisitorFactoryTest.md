
# Test Output Visitor Factory


## Function produceVisitor

### Funktion: entscheidet je nach übertragenem Format welcher OutputVisitor zurückgegeben wird
### Eingabe: Format format
### Rückgabe: iOutputVisitor iOutputVisitor

----
#### format: Äquivalenzklassen gültiger Werte
1. format<sub>XML</sub> = Format.XML;
2. format<sub>JSON</sub> = Format.JSON;

#### format: ungültige Werte
1. format<sub>null</sub> = null;



| Testfall | Äquivalenzklasse |  Name/Wert der Testvariable | Soll-Ausgabe | Ist-Ausgabe |
| ----     |    ----          | ----    | ---- | ---- |
| T1     | format<sub>XML</sub> | inputFormat = Format.XML | expectedVistor = XmlOutputVisitor() | actualVisitor |
| T2     | format<sub>JSON</sub> | inputFormat = Format.JSON | expectedVistor =  JsonOutputVisitor() | actualVisitor |
| T3     | format<sub>null</sub> | inputFormat = null | Exception | no Exception* |

* Bei Fall T3, müsste im switch der default-Pfad gewählt werden, in dem eine Exception geworfen wird, im Test ist eine try/catch so drum rum gebaut, dass die Exception abgefangen wird und eine Exception geworfen wird, wenn in der try/catch keine Exception abgefangen werden kann.