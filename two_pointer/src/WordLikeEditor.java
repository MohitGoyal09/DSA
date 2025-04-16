import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
public class WordLikeEditor extends JFrame {




        private JTextPane textPane;
        private JFileChooser fileChooser;

        public WordLikeEditor() {
            setTitle("Java Word-like Editor");
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            textPane = new JTextPane();
            fileChooser = new JFileChooser();

            JScrollPane scrollPane = new JScrollPane(textPane);
            add(scrollPane, BorderLayout.CENTER);

            createMenuBar();
            createToolBar();
        }

        private void createToolBar() {
            JToolBar toolBar = new JToolBar();

            JButton boldBtn = new JButton("B");
            boldBtn.setFont(new Font("Arial", Font.BOLD, 12));
            boldBtn.addActionListener(e -> toggleStyle(StyleConstants.CharacterConstants.Bold));

            JButton italicBtn = new JButton("I");
            italicBtn.setFont(new Font("Arial", Font.ITALIC, 12));
            italicBtn.addActionListener(e -> toggleStyle(StyleConstants.CharacterConstants.Italic));

            JButton underlineBtn = new JButton("U");
            underlineBtn.setFont(new Font("Arial", Font.PLAIN, 12));
            underlineBtn.addActionListener(e -> toggleStyle(StyleConstants.CharacterConstants.Underline));

            String[] fontSizes = { "12", "14", "16", "18", "20", "24", "28", "32" };
            JComboBox<String> fontSizeBox = new JComboBox<>(fontSizes);
            fontSizeBox.setSelectedItem("12");
            fontSizeBox.addActionListener(e -> changeFontSize(Integer.parseInt((String) fontSizeBox.getSelectedItem())));

            toolBar.add(boldBtn);
            toolBar.add(italicBtn);
            toolBar.add(underlineBtn);
            toolBar.add(new JLabel(" Font Size: "));
            toolBar.add(fontSizeBox);

            add(toolBar, BorderLayout.NORTH);
        }

        private void toggleStyle(Object style) {
            StyledDocument doc = textPane.getStyledDocument();
            int start = textPane.getSelectionStart();
            int end = textPane.getSelectionEnd();

            if (start == end) return;

            MutableAttributeSet attr = new SimpleAttributeSet();
            boolean isSet = StyleConstants.isBold(doc.getCharacterElement(start).getAttributes());

            if (style == StyleConstants.CharacterConstants.Bold)
                StyleConstants.setBold(attr, !isSet);
            else if (style == StyleConstants.CharacterConstants.Italic)
                StyleConstants.setItalic(attr, !StyleConstants.isItalic(doc.getCharacterElement(start).getAttributes()));
            else if (style == StyleConstants.CharacterConstants.Underline)
                StyleConstants.setUnderline(attr, !StyleConstants.isUnderline(doc.getCharacterElement(start).getAttributes()));

            doc.setCharacterAttributes(start, end - start, attr, false);
        }

        private void changeFontSize(int size) {
            StyledDocument doc = textPane.getStyledDocument();
            int start = textPane.getSelectionStart();
            int end = textPane.getSelectionEnd();
            if (start == end) return;

            MutableAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setFontSize(attr, size);
            doc.setCharacterAttributes(start, end - start, attr, false);
        }

        private void createMenuBar() {
            JMenuBar menuBar = new JMenuBar();

            JMenu fileMenu = new JMenu("File");

            JMenuItem open = new JMenuItem("Open");
            open.addActionListener(e -> openFile());

            JMenuItem save = new JMenuItem("Save");
            save.addActionListener(e -> saveFile());

            JMenuItem exit = new JMenuItem("Exit");
            exit.addActionListener(e -> System.exit(0));

            fileMenu.add(open);
            fileMenu.add(save);
            fileMenu.add(exit);

            menuBar.add(fileMenu);

            setJMenuBar(menuBar);
        }

        private void openFile() {
            int option = fileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                    textPane.read(br, null);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Failed to open file!");
                }
            }
        }

        private void saveFile() {
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileWriter fw = new FileWriter(file)) {
                    textPane.write(fw);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Failed to save file!");
                }
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new WordLikeEditor().setVisible(true);
            });
        }
    }


