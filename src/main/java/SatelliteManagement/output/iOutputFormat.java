package SatelliteManagement.output;

public interface iOutputFormat {
    String getArrayStartTag(Class childClass);
    String getArrayEndTag(Class childClass);
    String getAttribute(String name, String value);
    String getFirstAttribute(String name, String value);
    String getDocumentStart();
    String getDocumentEnd();
    String getObjectStart();
    String getObjectEnd();
}
