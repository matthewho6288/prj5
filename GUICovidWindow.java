package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * This class creates a window with functioning buttons that allow users to
 * study COVID statics in six states for five different demographics.
 * 
 * @author Matthew Ho (matthew00)
 * @version (11.28.2020)
 */
public class GUICovidWindow {
    private Window window;
    private State[] states;
    private State state;
    private Button alpha;
    private Button quit;
    private Button cfr;
    private Button dc;
    private Button ga;
    private Button md;
    private Button nc;
    private Button tn;
    private Button va;

    /**
     * This creates a window and adds buttons. This method accepts an array of
     * states as its parameter, and sets the field "states" in the class to the
     * parameter.
     * 
     * @param states
     *            an array of states
     */
    public GUICovidWindow(State[] states) {
        this.states = states;
        window = new Window();
        window.setSize(1440, 828);
        window.setTitle("COVID Visualizer by State");
        createButtons();
        addButtons();
    }


    /**
     * This method exits the window when a button calling this method is
     * pushed.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * This method sets the classes state field to DC and displays a bar graph
     * of the CFR ratios by race in DC.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedDC(Button button) {
        state = states[0];
        bar();
    }


    /**
     * This method sets the classes state field to Georgia and displays a bar
     * graph of the CFR ratios by race in Georgia.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedGA(Button button) {
        state = states[1];
        bar();
    }


    /**
     * This method sets the classes state field to Maryland and displays a bar
     * graph of the CFR ratios by race in Maryland.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedMD(Button button) {
        state = states[2];
        bar();
    }


    /**
     * This method sets the classes state field to North Carolina and displays a
     * bar graph of the CFR ratios by race in North Carolina.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedNC(Button button) {
        state = states[3];
        bar();
    }


    /**
     * This method sets the classes state field to Tennessee and displays a bar
     * graph of the CFR ratios by race in Tennessee.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedTN(Button button) {
        state = states[4];
        bar();
    }


    /**
     * This method sets the classes state field to Virginia and displays a bar
     * graph of the CFR ratios by race in Virginia.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedVA(Button button) {
        state = states[5];
        bar();
    }


    /**
     * This method displays a bar graph of the CFR ratios ordered by
     * Alphabetical
     * order.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedAlpha(Button button) {
        for (int i = 0; i < FileReader.MAX_STATES; i++) {
            states[i].getPopulation().alphaSort();
        }
        if (state != null) {
            bar();
        }
    }


    /**
     * This method displays a bar graph of the CFR ratios ordered by largest CFR
     * to
     * lowest CFR.
     * 
     * @param button
     *            A button in the window will prompt this method
     */
    public void clickedCFR(Button button) {
        for (int i = 0; i < FileReader.MAX_STATES; i++) {
            states[i].getPopulation().cfrSort();
        }
        if (state != null) {
            bar();
        }
    }


    /**
     * This method creates the bar shapes and the text labels in the window.
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
            int barHeight = (int)(pop.getEntry(i).cfr() * window
                .getGraphPanelHeight() * 0.075);
            int barWidth = 30;
            int marker = (int)(window.getGraphPanelWidth() / 6d);
            int barX = marker * (i + 1);
            int barY = window.getGraphPanelHeight() - barHeight - 150;
            TextShape race = new TextShape(barX - 5, window
                .getGraphPanelHeight() - 135, pop.getEntry(i).getRace());
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            String cfrStr = decimalFormat.format(pop.getEntry(i).cfr());
            TextShape cfr = new TextShape(barX - 5, window.getGraphPanelHeight()
                - 100, cfrStr + "%");
            Shape barShape = new Shape(barX, barY, barWidth, barHeight);
            Color color = new Color(165, 209, 232);
            barShape.setBackgroundColor(color);
            barShape.setForegroundColor(color);
            window.addShape(txt);
            window.addShape(barShape);
            window.addShape(race);
            window.addShape(cfr);
            if (cfrStr.equals("-1")) {
                TextShape na = new TextShape(barX + 3, window
                    .getGraphPanelHeight() - 160, "NA");
                window.addShape(na);
                window.removeShape(cfr);
            }
        }
    }


    /**
     * This method creates buttons for sorting, displaying states, and quitting.
     */
    private void createButtons() {
        alpha = new Button("Sort by Alpha");
        alpha.onClick(this, "clickedAlpha");
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        cfr = new Button("Sort by CFR");
        cfr.onClick(this, "clickedCFR");
        dc = new Button("Represent DC");
        dc.onClick(this, "clickedDC");
        ga = new Button("Represent GA");
        ga.onClick(this, "clickedGA");
        md = new Button("Represent MD");
        md.onClick(this, "clickedMD");
        nc = new Button("Represent NC");
        nc.onClick(this, "clickedNC");
        tn = new Button("Represent TN");
        tn.onClick(this, "clickedTN");
        va = new Button("Represent VA");
        va.onClick(this, "clickedVA");
    }


    /**
     * This method adds buttons to the window.
     */
    private void addButtons() {
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
}
