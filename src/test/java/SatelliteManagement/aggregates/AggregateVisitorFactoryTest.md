
# Test Aggregate Visitor Factory


## Function produceVisitor

### Funktion: entscheidet je nach übertragenem Aggregat welcher Visitor zurückgegeben wird
### Eingabe: Aggregate aggregate
### Rückgabe: iVisitor visitor

----
#### aggregate: Äquivalenzklassen gültiger Werte
1. aggregate<sub>CHANNEL_SAT</sub> = Aggregate.CHANNEL_SAT;
2. aggregate<sub>SAT_TRANSPONDER</sub> = Aggregate.SAT_TRANSPONDER;

#### inputTransponders: ungültige Werte
1. aggregate<sub>null</sub> = null;



| Testfall | Äquivalenzklasse |  Name/Wert der Testvariable | Soll-Ausgabe | Ist-Ausgabe |
| ----     |    ----          | ----    | ---- | ---- |
| T1     | aggregate<sub>CHANNEL_SAT</sub>| inputAggregate = Aggregate.CHANNEL_SAT | expectedVistor = ChannelsOverSatellitesVisitor() | actualVisitor |
| T2     | aggregate<sub>SAT_TRANSPONDER</sub>| inputAggregate = Aggregate.SAT_TRANSPONDER | expectedVistor =  SatellitesOverTranspondersVisitor() | actualVisitor |
| T3     | aggregate<sub>null</sub>| inputAggregate = null | Exception | no Exception* |

\* Bei Fall T3, müsste im switch der default-Pfad gewählt werden, in dem eine Exception geworfen wird, im Test ist eine try/catch so drum rum gebaut, dass die Exception abgefangen wird und eine Exception geworfen wird, wenn in der try/catch keine Exception abgefangen werden kann.