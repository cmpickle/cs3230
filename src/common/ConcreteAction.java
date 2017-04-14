package	common;

import	java.awt.event.*;
import	javax.swing.*;
import	java.beans.*;


/**
 * ConcreteAction provides a concrete implementation of AbstractAction by overriding the abstract
 * actionPerformed method and by creating a proxy listener object that responds to and redirects
 * the action event.  Instances of this class may be used where ever an Action object is required.
 * Event handler methods must be public and may not have arguments:<br>
 * <code>public void method() { . . . }</code>
 *
 * See the documentation for the Action interface and the AbstractAction class for more information.
 * If an instance of concrete action is cloned, both objects will continue to share the original
 * proxy listener.
 */


public class ConcreteAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	private	ActionListener	proxy;


	/**
	 * Creates an Action object with a proxy listener.
	 * @param target the object in which the event handler method is defined.
	 * @param method the name of the method called when the button is pressed (must be public).
	 */

	public ConcreteAction(Object target, String method)
	{
		proxy = (ActionListener)EventHandler.create(ActionListener.class, target, method);
	}


	/**
	 * Creates an Action object with a proxy listener.
	 * @param name the name (<code>Action.NAME</code>) for the action; a value of null is ignored.
	 * @param target the object in which the event handler method is defined.
	 * @param method the name of the method called when the button is pressed (must be public).
	 */

	public ConcreteAction(String name, Object target, String method)
	{
		super(name);
		proxy = (ActionListener)EventHandler.create(ActionListener.class, target, method);
	}


	/**
	 * Creates an Action object with a proxy listener.
	 * @param name the name (<code>Action.NAME</code>) for the action; a value of null is ignored.
	 * @param icon the small icon (<code>Action.SMALL_ICON</code>) for the action; a value of null
	 * is ignored.
	 * @param target the object in which the event handler method is defined.
	 * @param method the name of the method called when the button is pressed (must be public).
	 */

	public ConcreteAction(String name, Icon icon, Object target, String method)
	{
		super(name, icon);
		proxy = (ActionListener)EventHandler.create(ActionListener.class, target, method);
	}


	/**
	 * This implementation redirects action events to a proxy listener object.
	 */

	public void actionPerformed(ActionEvent e)
	{
		proxy.actionPerformed(e);
	}
}

