package org.noos.xing.mydoggy.plaf.ui.cmp;

import org.noos.xing.mydoggy.Dockable;
import org.noos.xing.mydoggy.ToolWindowAnchor;
import org.noos.xing.mydoggy.plaf.ui.look.DockableDropPanelUI;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Transferable;

/**
 * @author Angelo De Caro (angelo.decaro@gmail.com)
 */
public class DockableDropPanel extends JPanel {

    /**
     * @see #getUIClassID
     * @see #readObject
     */
    private static final String uiClassID = "DockableDropPanelUI";


    protected Class<? extends Dockable>[] targets;
    protected String parentPrefix;
    protected int threshold;


    public DockableDropPanel(String parentPrefix, Class<? extends Dockable>... targets) {
        this(parentPrefix, 20, targets);
    }

    public DockableDropPanel(String parentPrefix, int threshold, Class<? extends Dockable>... targets) {
        if (targets == null || targets.length == 0)
            throw new IllegalArgumentException("Targets cannot be null or zero length.");

        this.targets = targets;
        this.parentPrefix = parentPrefix;
        this.threshold = threshold;

        updateUI();
    }


    @Override
    public void paint(Graphics g) {
        if (this.isOpaque()) {
            g.setColor(this.getBackground());
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        super.paint(g);

        paintComponent(g);
   }

    public void updateUI() {
        if (parentPrefix != null)
            setUI((DockableDropPanelUI) UIManager.getUI(this));
    }

    public String getUIClassID() {
        return uiClassID;
    }

    public void setUI(DockableDropPanelUI ui) {
        super.setUI(ui);
    }

    public DockableDropPanelUI getUI() {
        return (DockableDropPanelUI) super.getUI();
    }


    public String getParentPrefix() {
        return parentPrefix;
    }

    public int getThreshold() {
        return threshold;
    }

    public Component getComponent() {
        return getUI().getComponent();
    }

    public void setComponent(Component component) {
        getUI().setComponent(component);
    }

    public void resetComponent() {
        getUI().resetComponent();
    }

    public Class<? extends Dockable>[] getTargets() {
        return targets;
    }


    public void dragExit() {
        getUI().dragExit();
    }

    public boolean dragStart(Transferable transferable, int action) {
        return getUI().dragStart(transferable);
    }

    public void dragOver(Point location) {
        getUI().dragOver(location);
    }

    public void dragEnd() {
        getUI().dragEnd();
    }

    public boolean drop(Transferable transferable) {
        return false;
    }


    public ToolWindowAnchor getOnAnchor() {
        return getUI().getOnAnchor();
    }

    public Dockable getOnDockable() {
        return getUI().getOnDockable();
    }

    public int getOnIndex() {
        return getUI().getOnIndex();
    }

    public Component getOnDockableContainer() {
        return getUI().getOnDockableContainer();
    }

}
