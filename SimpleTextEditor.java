import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.text.rtf.RTFEditorKit;

public class SimpleTextEditor extends JFrame {

   private JTextPane textPane;
   private JFileChooser fileChooser;

   public SimpleTextEditor() {
       super("Simple Text Editor");
       setSize(800, 600);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // Create a new text pane
       textPane = new JTextPane();
       add(new JScrollPane(textPane), BorderLayout.CENTER);

       // Create a new menu bar
       JMenuBar menuBar = new JMenuBar();
       setJMenuBar(menuBar);

       // Create a new file menu
       JMenu fileMenu = new JMenu("File");
       menuBar.add(fileMenu);

       // Create menu items for new, open, save, and exit
       JMenuItem newFileItem = new JMenuItem("New");
       JMenuItem openFileItem = new JMenuItem("Open");
       JMenuItem saveFileItem = new JMenuItem("Save");
       JMenuItem exitItem = new JMenuItem("Exit");

       newFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
       openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
       saveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
       exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));

       // Add action listeners for the menu items
       newFileItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               textPane.setText("");
           }
       });

       openFileItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               openFile();
           }
       });

       saveFileItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               saveFile();
           }
       });

       exitItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });

       // Create a theme menu
       JMenu themeMenu = new JMenu("Theme");

       JMenuItem lightThemeItem = new JMenuItem("Light");
       lightThemeItem.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           // Set light theme
           textPane.setBackground(Color.WHITE);
           textPane.setForeground(Color.BLACK);
           }
       });

       JMenuItem darkThemeItem = new JMenuItem("Dark");
       darkThemeItem.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           // Set dark theme
           textPane.setBackground(Color.BLACK);
           StyledDocument doc = textPane.getStyledDocument();
           Style style = doc.addStyle("blackOnWhite", null);
           StyleConstants.setForeground(style, Color.WHITE); // White color
           doc.setCharacterAttributes(0, doc.getLength(), style, false);
           textPane.setParagraphAttributes(style, false); // Set default style
           }
       });

       themeMenu.add(lightThemeItem);
       themeMenu.add(darkThemeItem);   

       // Add the menu items to the file menu
       fileMenu.add(newFileItem);
       fileMenu.add(openFileItem);
       fileMenu.add(saveFileItem);
       fileMenu.addSeparator();
       fileMenu.add(exitItem);

       // Create a new edit menu
       JMenu editMenu = new JMenu("Edit");
       menuBar.add(editMenu);
       menuBar.add(themeMenu);

       // Create menu items for cut, copy, paste, and select all
       JMenuItem cutItem = new JMenuItem("Cut");
       JMenuItem copyItem = new JMenuItem("Copy");
       JMenuItem pasteItem = new JMenuItem("Paste");
       JMenuItem selectAllItem = new JMenuItem("Select All");

       cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
       copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
       pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
       selectAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));

       // Add action listeners for the menu items
       cutItem.addActionListener(new DefaultEditorKit.CutAction());
       copyItem.addActionListener(new DefaultEditorKit.CopyAction());
       pasteItem.addActionListener(new DefaultEditorKit.PasteAction());

       selectAllItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               textPane.selectAll();
           }
       });

       // Add the menu items to the edit menu
       editMenu.add(cutItem);
       editMenu.add(copyItem);
       editMenu.add(pasteItem);
       editMenu.addSeparator();
       editMenu.add(selectAllItem);

       // Create a new format menu
       JMenu formatMenu = new JMenu("Format");
       menuBar.add(formatMenu);

       // Create menu items for bold, italics, and underline
       JCheckBoxMenuItem boldItem = new JCheckBoxMenuItem("Bold");
       JCheckBoxMenuItem italicItem = new JCheckBoxMenuItem("Italic");
       JCheckBoxMenuItem underlineItem = new JCheckBoxMenuItem("Underline");

       // Add action listeners for the menu items
       boldItem.addActionListener(new StyledEditorKit.BoldAction());
       italicItem.addActionListener(new StyledEditorKit.ItalicAction());
       underlineItem.addActionListener(new StyledEditorKit.UnderlineAction());

       // Add the menu items to the format menu
       formatMenu.add(boldItem);
       formatMenu.add(italicItem);
       formatMenu.add(underlineItem);

       // Create a new align menu
       JMenu alignMenu = new JMenu("Align");
       formatMenu.add(alignMenu);

       // Create menu items for left, right, center, and justified
       JMenuItem leftItem = new JMenuItem("Left");
       JMenuItem rightItem = new JMenuItem("Right");
       JMenuItem centerItem = new JMenuItem("Center");
       JMenuItem justifiedItem = new JMenuItem("Justified");

       // Add action listeners for the menu items
       leftItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               StyledDocument doc = textPane.getStyledDocument();
               SimpleAttributeSet left = new SimpleAttributeSet();
               StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
               doc.setParagraphAttributes(0, doc.getLength(), left, false);
           }
       });

       rightItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               StyledDocument doc = textPane.getStyledDocument();
               SimpleAttributeSet right = new SimpleAttributeSet();
               StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
               doc.setParagraphAttributes(0, doc.getLength(), right, false);
           }
       });

       centerItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               StyledDocument doc = textPane.getStyledDocument();
               SimpleAttributeSet center = new SimpleAttributeSet();
               StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
               doc.setParagraphAttributes(0, doc.getLength(), center, false);
           }
       });

       justifiedItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               StyledDocument doc = textPane.getStyledDocument();
               SimpleAttributeSet justified = new SimpleAttributeSet();
               StyleConstants.setAlignment(justified, StyleConstants.ALIGN_JUSTIFIED);
               doc.setParagraphAttributes(0, doc.getLength(), justified, false);
           }
       });

       // Add the menu items to the align menu
       alignMenu.add(leftItem);
       alignMenu.add(rightItem);
       alignMenu.add(centerItem);
       alignMenu.add(justifiedItem);

       // Create a new help menu
       JMenu helpMenu = new JMenu("Help");
       menuBar.add(helpMenu);

       // Create a menu item for about
       JMenuItem aboutItem = new JMenuItem("About");

       // Add an action listener for the menu item
       aboutItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(SimpleTextEditor.this, "Simple Text Editor \n(Project by Aashi)");
           }
       });

       // Add the menu item to the help menu
       helpMenu.add(aboutItem);

       // Create a new file chooser
       fileChooser = new JFileChooser();
   }

   // Method to open a file
   private void openFile() {
       int returnValue = fileChooser.showOpenDialog(this);
       if (returnValue == JFileChooser.APPROVE_OPTION) {
           File selectedFile = fileChooser.getSelectedFile();
           try {
               textPane.setPage(selectedFile.toURI().toURL());
           } catch (IOException e) {
               JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
           }
       }
   }

   // Method to save a file
   private void saveFile() {
       int returnValue = fileChooser.showSaveDialog(this);
       if (returnValue == JFileChooser.APPROVE_OPTION) {
           File selectedFile = fileChooser.getSelectedFile();
           try {
               StyledDocument doc = textPane.getStyledDocument();
               RTFEditorKit kit = new RTFEditorKit();
               try (FileWriter writer = new FileWriter(selectedFile)) {
                   kit.write(writer, doc, 0, doc.getLength());
               }
           } catch (IOException | BadLocationException  e) {
               JOptionPane.showMessageDialog(this, "Error writing file: " + 
e.getMessage());
           }
       }
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
           SimpleTextEditor editor = new SimpleTextEditor();
           editor.setVisible(true);
       });
   }
}