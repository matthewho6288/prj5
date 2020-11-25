package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
/**
 * 
 * @author matthewho
 */
public class GUICovidWindow {
    private Window window;
    private State[] states;
    private State state;
    
    public GUICovidWindow(State[] states) {
        this.states = states;
        window = new Window();
        window.setSize(1440, 828);
        window.setTitle("COVID Visualizer by State");
        Button alpha = new Button("Sort by Alpha");
        alpha.onClick(this, "clickedAlpha");
        
        Button quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        
        Button cfr = new Button("Sort by CFR");
        cfr.onClick(this, "clickedCFR");
        
        Button dc = new Button("Represent DC");
        dc.onClick(this, "clickedDC");
        
        Button ga = new Button("Represent GA");
        ga.onClick(this, "clickedGA");
        
        Button md = new Button("Represent MD");
        md.onClick(this, "clickedMD");
        
        Button nc = new Button("Represent NC");
        nc.onClick(this, "clickedNC");

        Button tn = new Button("Represent TN");
        tn.onClick(this, "clickedTN");

        Button va = new Button("Represent VA");
        va.onClick(this, "clickedVA");

        window.addButton(alpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(cfr, WindowSide.NORTH);
        window.addButton(dc, WindowSide.SOUTH);
        window.addButton(ga, WindowSide.SOUTH);
        window.addButton(md, WindowSide.SOUTH);
        window.addButton(nc, WindowSide.SOUTH);
        window.addButton(tn, WindowSide.SOUTH);
        window.addButton(va, WindowSide.SOUTH);
    }


    /**
     * This exits the window when a button calling this method is
     * pushed.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * This displays a bar graph of the CFR ratios by race in DC.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedDC(Button button) {
        state = states[0];
        bar();
    }


    /**
     * This displays a bar graph of the CFR ratios by race in Georgia.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedGA(Button button) {
        state = states[1];
        bar();
    }


    /**
     * This displays a bar graph of the CFR ratios by race in Maryland.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedMD(Button button) {
        state = states[2];
        bar();
    }


    /**
     * This displays a bar graph of the CFR ratios by race in North Carolina.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedNC(Button button) {
        state = states[3];
        bar();
    }


    /**
     * This displays a bar graph of the CFR ratios by race in Tennessee.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedTN(Button button) {
        state = states[4];
        bar();
    }


    /**
     * This displays a bar graph of the CFR ratios by race in Virginia.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedVA(Button button) {
        state = states[5];
        bar();
    }


    /**
     * This creates a the bar shapes and the text labels in the window.
     */
    private void bar() {
        window.removeAllShapes();
        TextShape txt = new TextShape((window.getGraphPanelWidth() / 2), 30,
            state.getName() + " Case Fatality Ratios by Race");
        int txtWidth = txt.getWidth();
        txt.setX((window.getGraphPanelWidth() / 2) - (txtWidth / 2));
        LinkedList<Demographic> pop = state.getPopulation();
        String pattern = "#.#";
        for (int i = 0; i < 5; i++) {
            int barHeight = (int)(pop.getEntry(i).cfr() * 50);
            int barWidth = 50;
            int marker = (int)(window.getGraphPanelWidth() / 6d);
            int barX = marker * (i + 1);
            int barY = window.getGraphPanelHeight() - barHeight - 200;
            TextShape race = new TextShape(barX + 4, window
                .getGraphPanelHeight() - 175, pop.getEntry(i).getRace());
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            String cfrStr = decimalFormat.format(pop.getEntry(i).cfr());
            TextShape cfr = new TextShape(barX + 4, window.getGraphPanelHeight()
                - 150, cfrStr + "%");
            Shape barShape = new Shape(barX, barY, barWidth, barHeight);
            Color color = new Color(165, 209, 232);
            barShape.setBackgroundColor(color);
            barShape.setForegroundColor(color);
            window.addShape(txt);
            window.addShape(barShape);
            window.addShape(race);
            window.addShape(cfr);
            if (cfrStr.equals("-1")) {
                TextShape na = new TextShape(barX + 11, window
                    .getGraphPanelHeight() - 200, "NA");
                window.addShape(na);
                window.removeShape(cfr);
            }
        }
    }


    /**
     * This displays a bar graph of the CFR ratios ordered by Alphabetical
     * order.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedAlpha(Button button) {
        if (state != null) {
            state.getPopulation().alphaSort();
            bar();
        }
    }


    /**
     * This displays a bar graph of the CFR ratios ordered by largest CFR to
     * lowest CFR.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedCFR(Button button) {
        if (state != null) {
            state.getPopulation().cfrSort();
            bar();
        }
    }
}
