import javax.swing.*;
import java.awt.*;

public class SortedListGUI extends JFrame {
    private SortedList sortedList;
    private JTextField inputField;
    private JTextArea displayArea;
    private JButton addButton;
    private JButton searchButton;

    public SortedListGUI() {
        sortedList = new SortedList();
        
        setTitle("Sorted List Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create input panel
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(20);
        addButton = new JButton("Add");
        searchButton = new JButton("Search");
        
        inputPanel.add(new JLabel("Enter text: "));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);
        
        // Create display area
        displayArea = new JTextArea(20, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        
        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Add action listeners
        addButton.addActionListener(e -> addElement());
        searchButton.addActionListener(e -> searchElement());
        
        // Set frame properties
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        updateDisplay("Welcome to Sorted List Demo!\n");
    }
    
    private void addElement() {
        String input = inputField.getText().trim();
        if (!input.isEmpty()) {
            sortedList.add(input);
            updateDisplay("Current list: " + sortedList.toString() + "\n");
            inputField.setText("");
        }
    }
    
    private void searchElement() {
        String input = inputField.getText().trim();
        if (!input.isEmpty()) {
            SortedList.SearchResult result = sortedList.search(input);
            if (result.found) {
                updateDisplay("Found \"" + result.element + "\" at position " + result.position + "\n");
            } else {
                updateDisplay("Element \"" + input + "\" not found. Would be inserted at position " + result.position + "\n");
            }
            inputField.setText("");
        }
    }
    
    private void updateDisplay(String message) {
        displayArea.append(message + "\n");
        displayArea.setCaretPosition(displayArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortedListGUI());
    }
}