
package org.mule.modules.quickbooks.online.process;

import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public interface ProcessAdapter<O >{

    <T> ProcessTemplate<T, O> getProcessTemplate();
}
