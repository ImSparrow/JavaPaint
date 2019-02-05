import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class DrawFrame extends JFrame 
{
   private JButton buttons[]; // array of buttons to hide portions
   private final String names[] = { "Undo","Redo","Clear" };
   private GridLayout gridLayout; // first gridlayout
   private DrawPanel panel;
   private JComboBox comboBoxColor;
   private JComboBox comboBoxShape;
   private JCheckBox filledCheckBox; // to select/deselect bold
   private final String colorName[] = {"Black","Blue","Cyan","Dark Gray","Gray","Green","Light Gray",
       "Magenta","Orange","Pink","Red","White","Yellow"};
   private final String shapeName[] = {"Line","Oval","Rectangle"};
   private JLabel statusLabel;
   private Boolean fill = false;
   
   private JLabel test;
   
   // set up GUI and event handling
   public DrawFrame()
   {
      super( "SuperPaint" );
      statusLabel = new JLabel();
      panel = new DrawPanel(statusLabel);
      
      gridLayout = new GridLayout(1,6,5,5);
      comboBoxShape = new JComboBox( shapeName );
      comboBoxColor = new JComboBox( colorName );
      filledCheckBox = new JCheckBox( "Fill" );
      comboBoxShape.setMaximumRowCount( 4 );
      comboBoxColor.setMaximumRowCount( 4 );

      JPanel topBorder = new JPanel(gridLayout);
      
      setLayout( new BorderLayout() ); // set frame layout
      
      buttons = new JButton[ names.length ]; // set size of array
      // create JButtons and register listeners for them
      ButtonHandler buttonHandler = new ButtonHandler();
      for ( int count = 0; count < names.length; count++ ) 
      {
         buttons[ count ] = new JButton( names[ count ] );
         
         buttons[ count ].addActionListener( buttonHandler );
         topBorder.add(buttons[count]);
      } // end for

       CheckComboBox comboHandler = new CheckComboBox();
       comboBoxColor.addItemListener(comboHandler);
       comboBoxShape.addItemListener(comboHandler);
       
       CheckBoxHandler checkHandler = new CheckBoxHandler();
       filledCheckBox.addItemListener( checkHandler );

      topBorder.add(comboBoxColor);
      topBorder.add(comboBoxShape);
      topBorder.add(filledCheckBox);


      add(topBorder,BorderLayout.NORTH);
      add(panel,BorderLayout.CENTER);
       add(statusLabel,BorderLayout.SOUTH);
      
   } 

   private class CheckComboBox implements ItemListener
   {
       public void itemStateChanged( ItemEvent event)
       {
           if (event.getSource() == comboBoxColor)
           {
               if(event.getStateChange() == ItemEvent.SELECTED)
               {
                   if(colorName[comboBoxColor.getSelectedIndex()] == "Black")
                   {
                       panel.setCurrentShapeColor(Color.BLACK);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Blue")
                   {
                       panel.setCurrentShapeColor(Color.BLUE);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Cyan")
                   {
                       panel.setCurrentShapeColor(Color.CYAN);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Dark Gray")
                   {
                       panel.setCurrentShapeColor(Color.DARK_GRAY);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Gray")
                   {
                       panel.setCurrentShapeColor(Color.GRAY);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Green")
                   {
                       panel.setCurrentShapeColor(Color.GREEN);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Magenta")
                   {
                       panel.setCurrentShapeColor(Color.MAGENTA);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Orange")
                   {
                       panel.setCurrentShapeColor(Color.ORANGE);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Pink")
                   {
                       panel.setCurrentShapeColor(Color.PINK);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Red")
                   {
                       panel.setCurrentShapeColor(Color.RED);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "White")
                   {
                       panel.setCurrentShapeColor(Color.WHITE);
                   }else if (colorName[comboBoxColor.getSelectedIndex()] == "Yellow")
                   {
                       panel.setCurrentShapeColor(Color.YELLOW);
                   }
               }
           }else if (event.getSource() == comboBoxShape) {
               if (event.getStateChange() == ItemEvent.SELECTED) {
                   if (shapeName[comboBoxShape.getSelectedIndex()] == "Rectangle") {
                       panel.setCurrentShapeType(1);
                   } else if (shapeName[comboBoxShape.getSelectedIndex()] == "Oval") {
                       panel.setCurrentShapeType(0);
                   } else if (shapeName[comboBoxShape.getSelectedIndex()] == "Line") {
                       panel.setCurrentShapeType(2);
                   }
               }
           }
       }
   }
   private class CheckBoxHandler implements ItemListener
   {
       public void itemStateChanged( ItemEvent event )
       {
           if ( event.getSource() == filledCheckBox )
           {
               fill = !fill;
               panel.setCurrentShapeFilled(fill);
           }
          
       }
   }
   
   private class ButtonHandler implements ActionListener 
   {
       public void actionPerformed( ActionEvent event )
       {
           if (event.getSource() == buttons[0]){
               panel.clearLastShape();
           }
           if (event.getSource() == buttons[1]){
               panel.redoLastShape();
           }
           if (event.getSource() == buttons[2]){
               panel.clearDrawing();
           }
       } // end method actionPerformed
   }
}