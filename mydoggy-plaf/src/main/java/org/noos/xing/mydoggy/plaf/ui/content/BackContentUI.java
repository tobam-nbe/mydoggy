package org.noos.xing.mydoggy.plaf.ui.content;

import org.noos.xing.mydoggy.Content;

import java.beans.PropertyChangeListener;

/**
 * @author Angelo De Caro (angelo.decaro@gmail.com)
 */
public interface BackContentUI extends Content {

    void addUIPropertyChangeListener(PropertyChangeListener listener);

    void removeUIPropertyChangeListener(PropertyChangeListener listener);

    void fireSelected(boolean selected);
    
}
