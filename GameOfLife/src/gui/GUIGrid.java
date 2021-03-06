package gui;
import java.awt.*;
import gameoflife.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @author Jacob Ahlberg, Alice Darner, Viktor Aoun, Shaon Ahmed.
 */
public class GUIGrid extends javax.swing.JFrame {
    
    boolean play = false;
    
    private static final Color ALIVE_COLOR = new Color(5, 83, 197),
                                DEAD_COLOR = new Color(58, 70, 89),
                                GRID_COLOR = new Color(5, 21, 64);
    
    private static int width = 50, 
                       height = 25;
    
    //Speed at the beginning
    private int fps = 1015;
    
    Graphics offScreenGraph;
    Image offScImg;
    

    Timer time;
    private static Board board = new Board(height, width);
    
    //For updating the board.
    private static boolean shouldChangeSize = false, shouldGenerate = false;

    private void updateFields(){
        livingCellField.setText("" + board.getNumberOfAliveCells());
        deadCellField.setText("" + ((width * height) - board.getNumberOfAliveCells()));
    }
    
    public static Board getBoard(){
        return board;
    }
    
    public static void setBoard(Board in){
        board = in;
    }
    
    public static void setGridSize(int w, int h){
        width = w;
        height = h;
    }
    
    public void updateBoardSize(){
        board = new Board(height,width);
    }
    
    public static void setShouldChangeSize(boolean should){
        shouldChangeSize = should;
    }
    public static void setShouldGenerate(boolean should){
        shouldGenerate = should;
    }
    
    public GUIGrid() {
        initComponents();
        this.setTitle("Game Of Life v.1.0.1");
        time = new javax.swing.Timer(fps, new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(shouldChangeSize){
                        updateBoardSize();
                        shouldChangeSize = false;
                }
                if(shouldGenerate){
                        updateBoardSize();
                        board.generate();
                        shouldGenerate = false;
                }
                updateFields();
                gridColor();
                if (play){
                    board.update();
                }
            }
        });
        time.start();
    }
    
    private void gridColor(){
        offScreenGraph.setColor(DEAD_COLOR);
        offScreenGraph.fillRect(0, 0, gridPanel.getWidth(), gridPanel.getHeight());
        //The user can manually place out living cells
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if (board.getCell(i, j).isAlive()){
                    offScreenGraph.setColor(ALIVE_COLOR);
                    int x = j * gridPanel.getWidth()/width;
                    int y = i * gridPanel.getHeight()/height;
                    offScreenGraph.fillRect(x, y, gridPanel.getWidth()/width, gridPanel.getHeight()/height);
                }
            }
        }
        //Writes out the height of the grid
        offScreenGraph.setColor(GRID_COLOR);
        for (int i = 1; i <= height; i++){
            int y = i * gridPanel.getHeight() / height;
            offScreenGraph.drawLine(0, y, gridPanel.getWidth(), y);
        }
        //Writes out the width of the grid
        for (int j = 1; j <= width; j++){
            int x = j * gridPanel.getWidth() / width;
            offScreenGraph.drawLine(x, 0, x, gridPanel.getHeight());
        }
        gridPanel.getGraphics().drawImage(offScImg, 0, 0, gridPanel);
    }
    
    //
    public void resetGrid(){
        board.reset();
        updateFields();
        gridColor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gridPanel = new javax.swing.JPanel();
        speedSlider = new javax.swing.JSlider();
        speedLabel = new javax.swing.JLabel();
        deadCellField = new javax.swing.JTextField();
        livingCellField = new javax.swing.JTextField();
        deadCellLabel = new javax.swing.JLabel();
        livingCellLabel = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gridPanel.setBackground(new java.awt.Color(153, 153, 153));
        gridPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridPanelMouseClicked(evt);
            }
        });
        gridPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                gridPanelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout gridPanelLayout = new javax.swing.GroupLayout(gridPanel);
        gridPanel.setLayout(gridPanelLayout);
        gridPanelLayout.setHorizontalGroup(
            gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gridPanelLayout.setVerticalGroup(
            gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        speedSlider.setMaximum(2000);
        speedSlider.setMinimum(30);
        speedSlider.setValue(1015);
        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });

        speedLabel.setText("Speed");

        deadCellLabel.setText("Dead cells");

        livingCellLabel.setText("Living cells");

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        settingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/cogs.png"))); // NOI18N
        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setFocusPainted(false);
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(clearButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(speedLabel)))
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deadCellLabel)
                                .addGap(9, 9, 9))
                            .addComponent(deadCellField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(livingCellLabel)
                            .addComponent(livingCellField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                        .addComponent(settingsButton))
                    .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(speedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(settingsButton))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(livingCellLabel)
                                    .addComponent(deadCellLabel))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(livingCellField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deadCellField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28))))
        );

        playButton.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if (playButton.getText().equals("Play")){
            playButton.setText("Pause");
            play = true;
        }else{
            playButton.setText("Play");
            play = false;
        }
    }//GEN-LAST:event_playButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        resetGrid();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        String[] s = {};
        Setting.main(s);
        playButton.setText("Play");
        play = false;
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void gridPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridPanelMouseClicked
        int j = width * evt.getX() / gridPanel.getWidth();
        int i = height * evt.getY() / gridPanel.getHeight();
        board.getCell(i, j).setState(!board.getCell(i,j).isAlive());
        gridColor();
        
    }//GEN-LAST:event_gridPanelMouseClicked

    private void gridPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_gridPanelComponentResized
        offScImg = createImage(gridPanel.getWidth(), gridPanel.getHeight());
        offScreenGraph = offScImg.getGraphics();
        gridColor();
    }//GEN-LAST:event_gridPanelComponentResized

    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderStateChanged
        fps = speedSlider.getValue();
        time.setDelay(speedSlider.getMaximum() - fps);
    }//GEN-LAST:event_speedSliderStateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIGrid grid = new GUIGrid();
                grid.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField deadCellField;
    private javax.swing.JLabel deadCellLabel;
    private javax.swing.JPanel gridPanel;
    private javax.swing.JTextField livingCellField;
    private javax.swing.JLabel livingCellLabel;
    private javax.swing.JButton playButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JSlider speedSlider;
    // End of variables declaration//GEN-END:variables
    
}
