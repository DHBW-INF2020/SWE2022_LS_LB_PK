/**
 * 
 */
package tree;

/**
 * 
 * @author Lea
 *
 */
public class Satellite extends Node{

private String _name;
private String _orbital;

public Satellite(String name, String orbital) {
	_name = name;
	_orbital = orbital;
}


/**
 * @return _name
 */
public String get_name() {
	return _name;
}


/**
 * @return _orbital
 */
public String get_orbital() {
	return _orbital;
}

	


}
